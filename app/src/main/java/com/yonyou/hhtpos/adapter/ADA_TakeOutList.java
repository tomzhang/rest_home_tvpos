package com.yonyou.hhtpos.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yonyou.framework.library.base.BaseAbsAdapter;
import com.yonyou.hhtpos.R;
import com.yonyou.hhtpos.bean.TakeOutListBean;

/**
 * 外带列表adapter
 * 作者：liushuofei on 2017/7/5 09:43
 */
public class ADA_TakeOutList extends BaseAbsAdapter<TakeOutListBean> {

    private TakeOutListBean currentBean;

    public ADA_TakeOutList(Context context) {
        super(context);
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_take_out_list, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        final TakeOutListBean bean = mDataSource.get(position);
        handleDataSource(position, holder, bean);

        if (bean.isCheck()){
            currentBean = bean;
            holder.mRoot.setBackgroundResource(R.color.color_eaeaea);
            holder.mLeftLine.setVisibility(View.VISIBLE);
            holder.mNumber.setTextColor(ContextCompat.getColor(mContext, R.color.color_eb6247));
            holder.mPrice.setTextColor(ContextCompat.getColor(mContext, R.color.color_eb6247));
            holder.mStatus.setTextColor(ContextCompat.getColor(mContext, R.color.color_eb6247));
            holder.mTime.setTextColor(ContextCompat.getColor(mContext, R.color.color_eb6247));
        }else {
            holder.mRoot.setBackgroundResource(R.color.color_FFFFFF);
            holder.mLeftLine.setVisibility(View.INVISIBLE);
            holder.mNumber.setTextColor(ContextCompat.getColor(mContext, R.color.color_222222));
            holder.mPrice.setTextColor(ContextCompat.getColor(mContext, R.color.color_222222));
            holder.mStatus.setTextColor(ContextCompat.getColor(mContext, R.color.color_666666));
            holder.mTime.setTextColor(ContextCompat.getColor(mContext, R.color.color_999999));
        }
        return convertView;
    }

    private void handleDataSource(int position, final ViewHolder holder, final TakeOutListBean bean) {
        holder.mRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!bean.equals(currentBean)){
                    bean.setCheck(true);
                    if (null != currentBean){
                        currentBean.setCheck(false);
                    }
                    currentBean = bean;
                    notifyDataSetChanged();
                }
            }
        });
    }

    static class ViewHolder {

        RelativeLayout mRoot;
        View mLeftLine;
        TextView mNumber;
        TextView mPrice;
        TextView mStatus;
        TextView mTime;

        ViewHolder(View v) {
            mRoot = (RelativeLayout) v.findViewById(R.id.rl_root);
            mLeftLine = (View) v.findViewById(R.id.v_left_line);
            mNumber = (TextView) v.findViewById(R.id.tv_number);
            mPrice = (TextView) v.findViewById(R.id.tv_price);
            mStatus = (TextView) v.findViewById(R.id.tv_status);
            mTime = (TextView) v.findViewById(R.id.tv_time);
        }
    }
}
