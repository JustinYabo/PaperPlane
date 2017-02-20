package com.xpp.neo1.paperplane.home.reader.zhihu;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.xpp.neo1.paperplane.R;
import com.xpp.neo1.paperplane.bean.ZhihuNews;
import com.xpp.neo1.paperplane.home.reader.DetailActivity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ZhihuFragment extends Fragment implements ZhihuContract.View {
    @Inject
    ZhihuPresenter mPresenter;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refreshLayout)
    SwipeRefreshLayout refreshLayout;


    private ZhihuNewsAdapter mAdapter;
    private List<ZhihuNews.StoriesBean> mBeanList;

    private int mYear = Calendar.getInstance().get(Calendar.YEAR);
    private int mMonth = Calendar.getInstance().get(Calendar.MONTH) + 1;
    private int mDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

    public static ZhihuFragment newInstance() {
        return new ZhihuFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupFragmentComponent();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_zhihu, container, false);
        ButterKnife.bind(this, view);
        initViews();
        return view;
    }

    @Override
    public void showError() {
        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        Snackbar.make(fab, "加载失败", Snackbar.LENGTH_INDEFINITE)
                .setAction("重新加载", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mPresenter.refresh();
                    }
                })
                .show();
    }

    @Override
    public void showLoading() {
        refreshLayout.setRefreshing(true);
    }

    @Override
    public void hideLoading() {
        refreshLayout.setRefreshing(false);
    }

    @Override
    public void showDatas(List<ZhihuNews.StoriesBean> beanList, boolean cleaning) {
        //如果是重新加载需要清除数据以后加载，如果是添加更多不需要清除
        if (cleaning) mBeanList.clear();
        for (ZhihuNews.StoriesBean storiesBean : beanList) {
            mBeanList.add(storiesBean);
        }
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showTimePickerDialog() {
        Calendar now = Calendar.getInstance();
        now.set(mYear, mMonth, mDay);
        DatePickerDialog dialog = DatePickerDialog.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
                mYear = year;
                mMonth = monthOfYear;
                mDay = dayOfMonth;
                Calendar temp = Calendar.getInstance();
                temp.clear();
                temp.set(year, monthOfYear, dayOfMonth);
                mPresenter.loadPosts(temp.getTimeInMillis(), true);
            }
        }, now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH));

        dialog.setMaxDate(Calendar.getInstance());
        Calendar minDate = Calendar.getInstance();
        // 2013.5.20是知乎日报api首次上线
        minDate.set(2013, 5, 20);
        dialog.setMinDate(minDate);
        dialog.vibrate(false);

        dialog.show(getActivity().getFragmentManager(), "DatePickerDialog");

    }

    private void setupFragmentComponent() {
        DaggerZhihuFragmentComponent
                .builder()
                .zhihuPresenterModule(new ZhihuPresenterModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void initViews() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mBeanList = new ArrayList<>();
        mAdapter = new ZhihuNewsAdapter(getActivity(), mBeanList);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            private boolean isSlideToLast = false;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();
                //当不滚动时
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    //获取最后一个完全显示的item的position
                    int lastVisableItem = manager.findLastCompletelyVisibleItemPosition();
                    int itemCounts = manager.getItemCount();

                    //如果滑动到底部，并且向下滑动就加载更多
                    if (lastVisableItem == (itemCounts - 1) && isSlideToLast) {
                        Calendar cal = Calendar.getInstance();
                        cal.set(mYear, mMonth, --mDay);
                        mPresenter.loadMore(cal.getTimeInMillis());
                    }

                }
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                isSlideToLast = dy > 0;
                super.onScrolled(recyclerView, dx, dy);
            }
        });
        //设置recyclerview的item点击事件,进入详细页面
        mAdapter.setOnItemClickListener(new ZhihuNewsAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, int position) {
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra("id", mBeanList.get(position).getId())
                        .putExtra("title", mBeanList.get(position).getTitle())
                        .putExtra("coverUrl", mBeanList.get(position).getImages().get(0));
                startActivity(intent);
            }
        });
        mPresenter.start();
        //设置下拉刷新的按钮的颜色
        refreshLayout.setColorSchemeResources(R.color.colorPrimary);

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.refresh();
            }
        });
    }
}
