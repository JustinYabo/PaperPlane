package com.xpp.neo1.paperplane.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xpp.neo1.paperplane.R;
import com.xpp.neo1.paperplane.home.reader.douban.DoubanFragment;
import com.xpp.neo1.paperplane.home.reader.douban.DoubanPresenter;
import com.xpp.neo1.paperplane.home.reader.guoke.GuokeFragment;
import com.xpp.neo1.paperplane.home.reader.guoke.GuokePresenter;
import com.xpp.neo1.paperplane.home.reader.meizi.MeiziFragment;
import com.xpp.neo1.paperplane.home.reader.meizi.MeiziPresenter;
import com.xpp.neo1.paperplane.home.reader.zhihu.ZhihuFragment;
import com.xpp.neo1.paperplane.home.reader.zhihu.ZhihuPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainFragment extends Fragment {
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    private ZhihuFragment mZhihuFragment;
    private MeiziFragment mMeiziFragment;
    private GuokeFragment mGuokeFragment;
    private DoubanFragment mDoubanFragment;


    private ZhihuPresenter mZhihuPresenter;
    private MeiziPresenter mMeiziPresenter;
    private GuokePresenter mGuokePresenter;
    private DoubanPresenter mDoubanPresenter;

    private static final String ZHIHU_TAG = "zhihu";
    private static final String MEIZI_TAG = "meizi";
    private static final String GUOKE_TAG = "guoke";
    private static final String DOUBAN_TAG = "douban";


    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            FragmentManager manager = getChildFragmentManager();
            mZhihuFragment = (ZhihuFragment) manager.getFragment(savedInstanceState, ZHIHU_TAG);
            mMeiziFragment = (MeiziFragment) manager.getFragment(savedInstanceState, MEIZI_TAG);
            mGuokeFragment = (GuokeFragment) manager.getFragment(savedInstanceState, GUOKE_TAG);
            mDoubanFragment = (DoubanFragment) manager.getFragment(savedInstanceState, DOUBAN_TAG);
        } else {
            mZhihuFragment = ZhihuFragment.newInstance();
            mMeiziFragment = MeiziFragment.newInstance();
            mGuokeFragment = GuokeFragment.newInstance();
            mDoubanFragment = DoubanFragment.newInstance();
        }

        mZhihuPresenter = new ZhihuPresenter(getActivity(), mZhihuFragment);
        mMeiziPresenter = new MeiziPresenter(getActivity(), mMeiziFragment);
        mGuokePresenter = new GuokePresenter(getActivity(), mGuokeFragment);
        mDoubanPresenter = new DoubanPresenter(getActivity(), mDoubanFragment);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, root);
        return root;
    }


}
