package com.example.xianicai.newdouyu.home.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.xianicai.newdouyu.R;
import com.example.xianicai.newdouyu.home.model.bean.ColumnBean;
import com.example.xianicai.newdouyu.widget.glide.GlideImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Zhanglibin on 2017/11/29.
 */

public class ColumnAdapter extends RecyclerView.Adapter<ColumnAdapter.ColumnVH> {

    private Context mContext;
    private List<ColumnBean.DataBean> dataBeans;

    public ColumnAdapter(Context mContext, List<ColumnBean.DataBean> dataBeans) {
        this.mContext = mContext;
        this.dataBeans = dataBeans;
    }

    @Override
    public ColumnVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.column_adapter_item, parent, false);
        return new ColumnVH(view);
    }

    @Override
    public void onBindViewHolder(ColumnVH holder, int position) {
        holder.mImageIcon.setRoundImage(dataBeans.get(position).getIcon_url(), 4);
        holder.mTvName.setText(dataBeans.get(position).getTag_name());
    }

    @Override
    public int getItemCount() {
        return dataBeans.size();
    }

    class ColumnVH extends RecyclerView.ViewHolder {
        @BindView(R.id.image_icon)
        GlideImageView mImageIcon;
        @BindView(R.id.tv_name)
        TextView mTvName;

        public ColumnVH(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
