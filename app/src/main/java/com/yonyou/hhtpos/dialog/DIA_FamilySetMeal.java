package com.yonyou.hhtpos.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yonyou.hhtpos.R;
import com.yonyou.hhtpos.adapter.ADA_FamilySetMealGrid;
import com.yonyou.hhtpos.adapter.ADA_FamilySetMealList;
import com.yonyou.hhtpos.bean.FilterItemEntity;
import com.yonyou.hhtpos.bean.SetMealGridEntity;
import com.yonyou.hhtpos.bean.SetMealListEntity;
import com.yonyou.hhtpos.widgets.FilterWheelView;

import java.util.ArrayList;

/**
 * 服务员点菜全家福弹框
 * 作者：ybing on 2017/7/12
 * 邮箱：ybing@yonyou.com
 */

public class DIA_FamilySetMeal implements View.OnClickListener,FilterWheelView.AdaItemCallback {
    /**上下文 */
    protected Context mContext;
    protected Dialog mDialog;
    protected View mContentView;

    /**界面控件 */
    private LinearLayout llFinishSelect;
    private ImageButton ibClose;
    private FilterWheelView fvSetDetailSelect;
    private int fvwItems;
    private RecyclerView rvDishGrid;
    private RecyclerView rvDishList;
    private TextView tvDishSelectedPrice;
    private TextView tvDishTotalCount;


    /**选项数据*/
    private FilterItemEntity mealSetDetailOption;
    private ArrayList<SetMealGridEntity> setMealGridEntities;
    private ArrayList<SetMealListEntity> setMealListEntities;

    /**数据适配器*/
    private ADA_FamilySetMealGrid adaSetMealGrid;
    private ADA_FamilySetMealList adaSetMealList;

    public DIA_FamilySetMeal(Context mContext,FilterItemEntity mealSetDetailOption,
                             ArrayList<SetMealGridEntity> setMealGridEntities, ArrayList<SetMealListEntity> setMealListEntities ) {
        this.mContext = mContext;
        initView();
        this.mealSetDetailOption = mealSetDetailOption;
        this.setMealListEntities = setMealListEntities;
        this.setMealGridEntities = setMealGridEntities;
        initData();

    }
    private void initView() {
        mDialog = new Dialog(mContext, R.style.style_custom_dialog);
        mContentView = LayoutInflater.from(mContext).inflate(R.layout.dia_family_set_meal, null);
        mDialog.setContentView(mContentView);

        llFinishSelect = (LinearLayout)mContentView.findViewById(R.id.ll_finish_select);
        ibClose =(ImageButton) mContentView.findViewById(R.id.ib_close);
        fvSetDetailSelect =(FilterWheelView) mContentView.findViewById(R.id.fv_set_detail_select);
        fvSetDetailSelect.setAdaItemCallback(this);

        ibClose.setOnClickListener(this);
        llFinishSelect.setOnClickListener(this);

        rvDishGrid = (RecyclerView) mContentView.findViewById(R.id.rv_set_meal_grid);
        rvDishList = (RecyclerView) mContentView.findViewById(R.id.rv_set_meal_list);
        tvDishSelectedPrice = (TextView) mContentView.findViewById(R.id.tv_dish_selected_price);
        tvDishTotalCount = (TextView) mContentView.findViewById(R.id.tv_dish_whole_count);
    }
    private void initData() {

        fvSetDetailSelect.setData(mealSetDetailOption);

        RecyclerView.LayoutManager gridManager = new GridLayoutManager(mContext,3);
        rvDishGrid.setLayoutManager(gridManager);
        adaSetMealGrid = new ADA_FamilySetMealGrid(mContext,setMealGridEntities);
        rvDishGrid.setAdapter(adaSetMealGrid);

        rvDishList.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false));
        adaSetMealList = new ADA_FamilySetMealList(mContext,setMealListEntities);
        rvDishList.setAdapter(adaSetMealList);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ib_close:
                mDialog.dismiss();
                break;
            case R.id.ll_finish_select:
                break;
            default:
                break;
        }
    }
    public Dialog getDialog(){
        mDialog.getWindow().setGravity(Gravity.CENTER);
        WindowManager.LayoutParams lp = mDialog.getWindow().getAttributes();
        lp.dimAmount = 0.2f;// 背景灰度
        lp.width = 1686;
        lp.height= 980;
        lp.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        mDialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        return mDialog;
    }

    @Override
    public void sendItems(int items) {
        this.fvwItems = items;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)fvSetDetailSelect.getLayoutParams();
        layoutParams.width = 215 * items;
        fvSetDetailSelect.setLayoutParams(layoutParams);
        Log.e("LinearLayout.width",layoutParams.width+"");
    }
}
