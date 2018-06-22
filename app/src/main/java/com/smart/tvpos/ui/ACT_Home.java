package com.smart.tvpos.ui;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.smart.framework.library.base.BaseActivity;
import com.smart.framework.library.bean.ErrorBean;
import com.smart.framework.library.netstatus.NetUtils;
import com.smart.tvpos.R;
import com.smart.tvpos.adapter.ADA_HomeMenu;
import com.smart.tvpos.bean.HomeMenuEntity;
import com.smart.tvpos.widgets.BanSlideListView;
import com.smart.tvpos.widgets.CommonPopupWindow;
import com.smart.tvpos.widgets.RingChartView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by JoJo on 2018/6/21.
 * wechat：18510829974
 * description：主页：数据监控
 */
public class ACT_Home extends BaseActivity {
    @Bind(R.id.tv_rest_home_num)
    TextView tvRestHomeNum;
    @Bind(R.id.tv_user_num)
    TextView tvUserNum;
    @Bind(R.id.tv_bedroom_num)
    TextView tvBedroomNum;
    @Bind(R.id.tv_live_rate)
    TextView tvLiveRate;
    @Bind(R.id.iv_menu)
    ImageView ivMenu;
    @Bind(R.id.alertchartview)
    RingChartView chartviewDataAlert;
    @Bind(R.id.userlivingchartview)
    RingChartView chartviewUserLiving;
    @Bind(R.id.nurselevelchartview)
    RingChartView chartviewNurselevel;
    @Bind(R.id.employeechartview)
    RingChartView chartviewEmployee;
    private CommonPopupWindow mPopupWindow;
    private CommonPopupWindow.LayoutGravity mPopuplayoutGravity;
    private List<HomeMenuEntity> menuList = new ArrayList();
    private String[] memuTitle = {"数据监控", "概览", "护理进度"};
    private int[] memuIcons = {R.drawable.ic_data_watching, R.drawable.ic_genneral_view, R.drawable.ic_nurse_progress};

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    protected void initViewsAndEvents() {
        for (int i = 0; i < 3; i++) {
            HomeMenuEntity itemMenu = new HomeMenuEntity();
            itemMenu.menuIcon = memuIcons[i];
            itemMenu.menuTxt = memuTitle[i];
            menuList.add(itemMenu);
        }
        mPopupWindow = new CommonPopupWindow(this, R.layout.popup_home_menu, 192, ViewGroup.LayoutParams.WRAP_CONTENT) {
            @Override
            protected void initView() {
                View view = getContentView();
                BanSlideListView listview = (BanSlideListView) view.findViewById(R.id.listview);
                ADA_HomeMenu adapter = new ADA_HomeMenu(mContext);
                listview.setAdapter(adapter);
                adapter.update(menuList, true);
            }

            @Override
            protected void initEvent() {
            }
        };
        mPopuplayoutGravity = new CommonPopupWindow.LayoutGravity(CommonPopupWindow.LayoutGravity.ALIGN_ABOVE | CommonPopupWindow.LayoutGravity.TO_RIGHT);

        initChartView();
    }

    private void initChartView() {
        /**
         *  入住用户
         */
        // 添加的颜色
        List<Integer> userLivingChartcolorList = new ArrayList<>();
        //未处理
        userLivingChartcolorList.add(R.color.color_34617e);
        userLivingChartcolorList.add(R.color.color_f1b133);
        userLivingChartcolorList.add(R.color.color_2e84ba);
        userLivingChartcolorList.add(R.color.color_55c7f2);
        userLivingChartcolorList.add(R.color.color_5ffefd);
        userLivingChartcolorList.add(R.color.color_e36853);
        userLivingChartcolorList.add(R.color.color_7c80fe);

        //  添加的是百分比
        List<Float> userLivingChartRateList = new ArrayList<>();
        userLivingChartRateList.add(5f);
        userLivingChartRateList.add(10f);
        userLivingChartRateList.add(20f);
        userLivingChartRateList.add(15f);
        userLivingChartRateList.add(30f);
        userLivingChartRateList.add(10f);
        userLivingChartRateList.add(10f);
        chartviewUserLiving.setShow(userLivingChartcolorList, userLivingChartRateList, true, true);

        /**
         *  报警数据
         */
        // 添加的颜色
        List<Integer> alertChartcolorList = new ArrayList<>();
        //未处理
        alertChartcolorList.add(R.color.color_f1b133);
        alertChartcolorList.add(R.color.color_2b84b9);

        //  添加的是百分比
        List<Float> alertChartRateList = new ArrayList<>();
        alertChartRateList.add(32f);
        alertChartRateList.add(68f);
        chartviewDataAlert.setShow(alertChartcolorList, alertChartRateList, true, true);

        /**
         * 护理级别
         */
        // 添加的颜色
        List<Integer> nurseLevelChartcolorList = new ArrayList<>();
        nurseLevelChartcolorList.add(R.color.color_55c7f2);
        nurseLevelChartcolorList.add(R.color.color_5ffefd);
        nurseLevelChartcolorList.add(R.color.color_e36853);
        nurseLevelChartcolorList.add(R.color.color_7c80fe);

        //  添加的是百分比
        List<Float> nurseLevelChartRateList = new ArrayList<>();
        nurseLevelChartRateList.add(40f);
        nurseLevelChartRateList.add(10f);
        nurseLevelChartRateList.add(5f);
        nurseLevelChartRateList.add(45f);
        chartviewNurselevel.setShow(nurseLevelChartcolorList, nurseLevelChartRateList, true, true);
        /**
         * 员工统计
         */
        // 添加的颜色
        List<Integer> employeeChartcolorList = new ArrayList<>();
        employeeChartcolorList.add(R.color.color_55c7f2);
        employeeChartcolorList.add(R.color.color_5ffefd);
        employeeChartcolorList.add(R.color.color_34617e);
        employeeChartcolorList.add(R.color.color_7c80fe);
        employeeChartcolorList.add(R.color.color_f1b133);
        //  添加的是百分比
        List<Float> employeeChartRateList = new ArrayList<>();
        employeeChartRateList.add(40f);
        employeeChartRateList.add(20f);
        employeeChartRateList.add(5f);
        employeeChartRateList.add(20f);
        employeeChartRateList.add(15f);
        chartviewEmployee.setShow(employeeChartcolorList, employeeChartRateList, true, true);

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.act_home;
    }

    @OnClick({R.id.iv_menu})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_menu:
                mPopupWindow.showBashOfAnchor(ivMenu, mPopuplayoutGravity, 0, 0);
                break;
        }
    }

    @Override
    protected View getLoadingTargetView() {
        return null;
    }


    @Override
    protected void onNetworkConnected(NetUtils.NetType type) {

    }

    @Override
    protected void onNetworkDisConnected() {

    }

    @Override
    public void showBusinessError(ErrorBean error) {

    }

    @Override
    protected boolean isApplyKitKatTranslucency() {
        return false;
    }

    @Override
    protected boolean isApplyStatusBarTranslucency() {
        return false;
    }

    @Override
    protected boolean isBindEventBusHere() {
        return false;
    }

    @Override
    protected boolean toggleOverridePendingTransition() {
        return true;
    }

    @Override
    protected TransitionMode getOverridePendingTransitionMode() {
        return TransitionMode.RIGHT;
    }
}
