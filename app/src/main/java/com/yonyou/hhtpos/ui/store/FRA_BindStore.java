package com.yonyou.hhtpos.ui.store;

import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import com.yonyou.framework.library.base.BaseFragment;
import com.yonyou.framework.library.bean.ErrorBean;
import com.yonyou.framework.library.eventbus.EventCenter;
import com.yonyou.hhtpos.R;
import com.yonyou.hhtpos.dialog.DIA_ChooseStore;
import com.yonyou.hhtpos.ui.login.ACT_Login;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by zj on 2017/6/27.
 * 邮箱：zjuan@yonyou.com
 * 描述：绑定门店页面
 */
public class FRA_BindStore extends BaseFragment {
    @Bind(R.id.rb_finish)
    RadioButton rbFinish;
    @Bind(R.id.choose_store)
    TextView tvStoreName;
    private DIA_ChooseStore diaChooseStore;

    @Override
    protected void onFirstUserVisible() {

    }

    @Override
    protected void onUserVisible() {

    }

    @Override
    protected void onUserInvisible() {

    }

    @Override
    protected View getLoadingTargetView() {
        return null;
    }

    @Override
    protected void initViewsAndEvents() {
        diaChooseStore = new DIA_ChooseStore(mContext, new DIA_ChooseStore.OnChoosStoreListener() {
            @Override
            public void onChooseStore(String storeName, int poition) {
                tvStoreName.setText(storeName);
            }
        });
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fra_bind_store;
    }

    @OnClick({R.id.rb_finish, R.id.choose_store})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rb_finish:
                readyGoThenKill(ACT_Login.class);
                break;
            case R.id.choose_store:
                diaChooseStore.show();
                break;
        }
    }

    @Override
    protected void onEventComming(EventCenter eventCenter) {

    }

    @Override
    protected boolean isBindEventBusHere() {
        return false;
    }

    @Override
    public void showBusinessError(ErrorBean error) {

    }
}