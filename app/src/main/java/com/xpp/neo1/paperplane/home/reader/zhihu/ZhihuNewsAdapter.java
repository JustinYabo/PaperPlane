package com.xpp.neo1.paperplane.home.reader.zhihu;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.xpp.neo1.paperplane.R;
import com.xpp.neo1.paperplane.bean.ZhihuNews;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by neo1 on 2017/2/17.
 */

public class ZhihuNewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final Context mContext;
    private final LayoutInflater mInflater;
    private List<ZhihuNews.StoriesBean> mBeanList;
    private OnItemClickListener mItemClickListener;

    private static final int TYPE_NORMAL = 0;
    private static final int TYPE_FOOTER = 1;

    public ZhihuNewsAdapter(Context context, List<ZhihuNews.StoriesBean> beanList) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mBeanList = beanList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_NORMAL)
            return new NormalViewHolder(mInflater.inflate(R.layout.home_list_item_layout, parent, false), mItemClickListener);
        if (viewType == TYPE_FOOTER)
            return new FooterViewHolder(mInflater.inflate(R.layout.list_footer, parent, false));
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof NormalViewHolder) {
            NormalViewHolder viewHolder = (NormalViewHolder) holder;
            ZhihuNews.StoriesBean bean = mBeanList.get(position);
            Glide.with(mContext)
                    .load(bean.getImages().get(0))
                    .asBitmap()
                    .placeholder(R.mipmap.placeholder)
                    .error(R.mipmap.placeholder)
                    .centerCrop()
                    .into(viewHolder.cover);
            viewHolder.title.setText(bean.getTitle());
        }
    }

    @Override
    public int getItemCount() {
        return mBeanList.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == mBeanList.size())
            return ZhihuNewsAdapter.TYPE_FOOTER;
        return ZhihuNewsAdapter.TYPE_NORMAL;
    }

    public interface OnItemClickListener {
        void OnItemClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mItemClickListener = listener;
    }

    public static class NormalViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.textViewTitle)
        TextView title;
        @BindView(R.id.imageViewCover)
        ImageView cover;

        public NormalViewHolder(final View itemView, final OnItemClickListener listener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null)
                        listener.OnItemClick(itemView, getLayoutPosition());
                }
            });
        }

    }

    public static class FooterViewHolder extends RecyclerView.ViewHolder {

        public FooterViewHolder(View itemView) {
            super(itemView);
        }
    }
}
