package com.yonyou.hhtpos.interactor.Impl;

import android.text.TextUtils;

import com.yonyou.framework.library.bean.ErrorBean;
import com.yonyou.framework.library.common.utils.StringUtil;
import com.yonyou.hhtpos.base.BaseLoadedListener;
import com.yonyou.hhtpos.bean.dish.RequestEditDishEntity;
import com.yonyou.hhtpos.global.API;
import com.yonyou.hhtpos.interactor.IDishEditInteractor;
import com.yonyou.hhtpos.manager.ReqCallBack;
import com.yonyou.hhtpos.manager.RequestManager;

import java.util.HashMap;

/**
 * 作者：liushuofei on 2017/7/22 11:59
 * 邮箱：lsf@yonyou.com
 */
public class DishEditInteractorImpl implements IDishEditInteractor {

    /**修改数量监听 */
    private BaseLoadedListener updateQuantityListener;
    /**删除菜品监听 */
    private BaseLoadedListener deleteDishListener;
    /**更新菜品状态监听 */
    private BaseLoadedListener updateDishStatusListener;
    /**赠菜退菜监听 */
    private BaseLoadedListener handleDishListener;
    /**称重确认监听 */
    private BaseLoadedListener confirmWeightListener;
    /**转台监听 */
    private BaseLoadedListener switchTableListener;
    /**取消赠送监听 */
    private BaseLoadedListener cancelGiftDishesListener;
    /**修改菜品监听 */
    private BaseLoadedListener updateDishListener;

    public DishEditInteractorImpl(BaseLoadedListener updateQuantityListener, BaseLoadedListener deleteDishListener, BaseLoadedListener updateDishStatusListener,
                                  BaseLoadedListener handleDishListener, BaseLoadedListener confirmWeightListener, BaseLoadedListener switchTableListener,
                                  BaseLoadedListener cancelGiftDishesListener, BaseLoadedListener updateDishListener) {
        this.updateQuantityListener = updateQuantityListener;
        this.deleteDishListener = deleteDishListener;
        this.updateDishStatusListener = updateDishStatusListener;
        this.handleDishListener = handleDishListener;
        this.confirmWeightListener = confirmWeightListener;
        this.switchTableListener = switchTableListener;
        this.cancelGiftDishesListener = cancelGiftDishesListener;
        this.updateDishListener = updateDishListener;
    }
    
    @Override
    public void updateQuantity(String companyId, String id, String quantity, String shopId) {
        HashMap<String,String> hashMap = new HashMap<>();
        //hashMap.put("companyId", companyId);
        hashMap.put("id", id);
        hashMap.put("quantity", quantity);
        hashMap.put("shopId", shopId);
        RequestManager.getInstance().requestPostByAsyn(API.URL_UPDATE_DISH_QUANTITY, hashMap, new ReqCallBack<String>() {

            @Override
            public void onReqSuccess(String result) {
                updateQuantityListener.onSuccess(0, result);
            }

            @Override
            public void onFailure(String result) {
                updateQuantityListener.onException(result);
            }

            @Override
            public void onReqFailed(ErrorBean errorBean) {
                updateQuantityListener.onBusinessError(errorBean);
            }
        });
    }

    @Override
    public void deleteDish(String companyId, String id, String shopId) {
        HashMap<String,String> hashMap = new HashMap<>();
        //hashMap.put("companyId", companyId);
        hashMap.put("id", id);
        hashMap.put("shopId", shopId);
        RequestManager.getInstance().requestPostByAsyn(API.URL_DELETE_DISH, hashMap, new ReqCallBack<String>() {

            @Override
            public void onReqSuccess(String result) {
                deleteDishListener.onSuccess(0, result);
            }

            @Override
            public void onFailure(String result) {
                deleteDishListener.onException(result);
            }

            @Override
            public void onReqFailed(ErrorBean errorBean) {
                deleteDishListener.onBusinessError(errorBean);
            }
        });
    }

    @Override
    public void updateDishStatus(String companyId, String dishStatus, String id, String shopId) {
        HashMap<String,String> hashMap = new HashMap<>();
        //hashMap.put("companyId", companyId);
        hashMap.put("id", id);
        hashMap.put("shopId", shopId);
        hashMap.put("dishStatus", dishStatus);
        RequestManager.getInstance().requestPostByAsyn(API.URL_UPDATE_DISH_STATUS, hashMap, new ReqCallBack<String>() {

            @Override
            public void onReqSuccess(String result) {
                updateDishStatusListener.onSuccess(0, result);
            }

            @Override
            public void onFailure(String result) {
                updateDishStatusListener.onException(result);
            }

            @Override
            public void onReqFailed(ErrorBean errorBean) {
                updateDishStatusListener.onBusinessError(errorBean);
            }
        });
    }

    @Override
    public void specialHandleDish(String dishAbnormalStatus, String id, String shopId, String count) {
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("dishAbnormalStatus", dishAbnormalStatus);
        hashMap.put("shopId", shopId);
        hashMap.put("count", count);
        hashMap.put("id", id);

        // TODO: waiterId
        hashMap.put("waiterId", "BB9930642C000000FD00000000316122");
        RequestManager.getInstance().requestPostByAsyn(API.URL_SPECIAL_HANDLE_DISH, hashMap, new ReqCallBack<String>() {

            @Override
            public void onReqSuccess(String result) {
                handleDishListener.onSuccess(0, result);
            }

            @Override
            public void onFailure(String result) {
                handleDishListener.onException(result);
            }

            @Override
            public void onReqFailed(ErrorBean errorBean) {
                handleDishListener.onBusinessError(errorBean);
            }
        });
    }

    @Override
    public void confirmWeightDish(String id, String quantity, String shopId) {
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("id", id);
        hashMap.put("shopId", shopId);
        hashMap.put("quantity", quantity);
        RequestManager.getInstance().requestPostByAsyn(API.URL_CONFIRM_WEIGHT, hashMap, new ReqCallBack<String>() {

            @Override
            public void onReqSuccess(String result) {
                confirmWeightListener.onSuccess(0, result);
            }

            @Override
            public void onFailure(String result) {
                confirmWeightListener.onException(result);
            }

            @Override
            public void onReqFailed(ErrorBean errorBean) {
                confirmWeightListener.onBusinessError(errorBean);
            }
        });
    }

    @Override
    public void switchTable(String id, String count, String shopId, String tableBillId) {
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("id", id);
        hashMap.put("count", count);
        hashMap.put("shopId", shopId);
        hashMap.put("tableBillId", tableBillId);
        RequestManager.getInstance().requestPostByAsyn(API.URL_SWITCH_TABLE, hashMap, new ReqCallBack<String>() {

            @Override
            public void onReqSuccess(String result) {
                switchTableListener.onSuccess(0, result);
            }

            @Override
            public void onFailure(String result) {
                switchTableListener.onException(result);
            }

            @Override
            public void onReqFailed(ErrorBean errorBean) {
                switchTableListener.onBusinessError(errorBean);
            }
        });
    }

    @Override
    public void cancelGiftDish(String id, String shopId, String waiterId) {
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("id", id);
        hashMap.put("shopId", shopId);

        // TODO: waiterId
        hashMap.put("waiterId", "BB9930642C000000FD00000000316122");
        RequestManager.getInstance().requestPostByAsyn(API.URL_CANCEL_GIFT_DISHES, hashMap, new ReqCallBack<String>() {

            @Override
            public void onReqSuccess(String result) {
                cancelGiftDishesListener.onSuccess(0, result);
            }

            @Override
            public void onFailure(String result) {
                cancelGiftDishesListener.onException(result);
            }

            @Override
            public void onReqFailed(ErrorBean errorBean) {
                cancelGiftDishesListener.onBusinessError(errorBean);
            }
        });
    }

    @Override
    public void updateDish(RequestEditDishEntity bean) {
        if (null == bean)
            return;

        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("dishType", bean.getDishType());
        hashMap.put("id", bean.getId());
        hashMap.put("shopId", bean.getShopId());

        // 	菜品规格id（为空则不修改，不为空修改）
        if (!TextUtils.isEmpty(bean.getDishStandardId())){
            hashMap.put("dishStandardId", bean.getDishStandardId());
        }
        // 	所选做法id列表（为空则不修改，不为空修改）
        if (!TextUtils.isEmpty(bean.getPractices())){
            hashMap.put("practices", bean.getPractices());
        }
        //  数量（为空则不修改，不为空修改）
        if (!TextUtils.isEmpty(bean.getQuantity())){
            hashMap.put("quantity", bean.getQuantity());
        }
        // 备注（为空则不修改，不为空修改）
        if (!TextUtils.isEmpty(bean.getRemark())){
            hashMap.put("remark", bean.getRemark());
        }
        // 所选备注id列表（为空则不修改，不为空修改）
        if (!TextUtils.isEmpty(bean.getRemarks())){
            hashMap.put("remarks", bean.getRemarks());
        }

        RequestManager.getInstance().requestPostByAsyn(API.URL_UPDATE_DISH, hashMap, new ReqCallBack<String>() {

            @Override
            public void onReqSuccess(String result) {
                updateDishListener.onSuccess(0, result);
            }

            @Override
            public void onFailure(String result) {
                updateDishListener.onException(result);
            }

            @Override
            public void onReqFailed(ErrorBean errorBean) {
                updateDishListener.onBusinessError(errorBean);
            }
        });
    }
}
