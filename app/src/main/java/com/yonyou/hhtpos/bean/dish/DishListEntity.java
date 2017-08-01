package com.yonyou.hhtpos.bean.dish;

import com.yonyou.framework.library.common.utils.StringUtil;

import java.io.Serializable;
import java.util.List;

/**
 * 已点菜品列表实体类
 * 作者：liushuofei on 2017/7/17 19:16
 */
public class DishListEntity implements Serializable {

    /**菜类已点个数 */
    //private List<String> dishTypeNum;
    /**已点菜品 */
    private List<Dishes> dishes;
    /**已点菜品分类数量 */
    private List<DishType> dishTypelist;

    public List<Dishes> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dishes> dishes) {
        this.dishes = dishes;
    }

    public List<DishType> getDishTypelist() {
        return dishTypelist;
    }

    public void setDishTypelist(List<DishType> dishTypelist) {
        this.dishTypelist = dishTypelist;
    }

    /**
     * 菜品实体
     */
    public class Dishes implements Serializable{
//        /**套餐详情列表 */
//        private List<String> details;
        /**分类id */
        private String dishClassId;
        /**唯一标识*/
        public String dishRelateId;
        /**名称 */
        private String dishName;
        /**价格 */
        private String dishPrice;
        /**状态 */
        private int dishStatus;
        /**类型 */
        private String dishType;
        /**展示做法 */
        private String listShowPractice;
        /**展示备注 */
        private String listShowRemark;

        /**做法id */
        private String practice;
        /**数量 */
        private String quantity;
        /**菜品备注 */
        private String remark;
        /**备注id列表 */
        private List<String> remarks;
        /**规格ID */
        private String standardId;

        /**下单时间 */
        private String orderTime;

        /**是否为称重菜（0：不是  1：是） */
        private int unit;

        /**id */
        private String id;

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getPractice() {
            return practice;
        }

        public void setPractice(String practice) {
            this.practice = practice;
        }

        public List<String> getRemarks() {
            return remarks;
        }

        public void setRemarks(List<String> remarks) {
            this.remarks = remarks;
        }

        public String getStandardId() {
            return standardId;
        }

        public void setStandardId(String standardId) {
            this.standardId = standardId;
        }

        /**退增的list */
        private List<Abnormal> abnormalList;

        public String getDishType() {
            return dishType;
        }

        public void setDishType(String dishType) {
            this.dishType = dishType;
        }

        public String getDishClassId() {
            return dishClassId;
        }

        public void setDishClassId(String dishClassId) {
            this.dishClassId = dishClassId;
        }

        public List<Abnormal> getAbnormalList() {
            return abnormalList;
        }

        public void setAbnormalList(List<Abnormal> abnormalList) {
            this.abnormalList = abnormalList;
        }

        public String getDishName() {
            return dishName;
        }

        public void setDishName(String dishName) {
            this.dishName = dishName;
        }

        public String getDishPrice() {
            return StringUtil.getFormattedMoney(dishPrice);
        }

        public void setDishPrice(String dishPrice) {
            this.dishPrice = dishPrice;
        }

        public String getQuantity() {
            return StringUtil.getFormattedMoney(quantity);
        }

        public void setQuantity(String quantity) {
            this.quantity = quantity;
        }

        public int getDishStatus() {
            return dishStatus;
        }

        public void setDishStatus(int dishStatus) {
            this.dishStatus = dishStatus;
        }

        public String getOrderTime() {
            return orderTime;
        }

        public void setOrderTime(String orderTime) {
            this.orderTime = orderTime;
        }

        public String getListShowPractice() {
            return listShowPractice;
        }

        public void setListShowPractice(String listShowPractice) {
            this.listShowPractice = listShowPractice;
        }

        public String getListShowRemark() {
            return listShowRemark;
        }

        public void setListShowRemark(String listShowRemark) {
            this.listShowRemark = listShowRemark;
        }

        public int getUnit() {
            return unit;
        }

        public void setUnit(int unit) {
            this.unit = unit;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDishRelateId() {
            return dishRelateId;
        }

        public void setDishRelateId(String dishRelateId) {
            this.dishRelateId = dishRelateId;
        }

        public class Abnormal implements Serializable{
            /**退增状态 */
            private String dishAbnormalStatus;
            /**服务员姓名 */
            private String waiterName;
            /**退增时间 */
            private long createTime;
            /**数量 */
            private String quantity;

            public long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }

            public String getDishAbnormalStatus() {
                return dishAbnormalStatus;
            }

            public void setDishAbnormalStatus(String dishAbnormalStatus) {
                this.dishAbnormalStatus = dishAbnormalStatus;
            }

            public String getWaiterName() {
                return waiterName;
            }

            public void setWaiterName(String waiterName) {
                this.waiterName = waiterName;
            }

            public String getQuantity() {
                return quantity;
            }

            public void setQuantity(String quantity) {
                this.quantity = quantity;
            }
        }
    }

    public class DishType implements Serializable{
        /**菜品分类id */
        private String dishClassId;
        /**数量 */
        private String quantity;

        public String getDishClassId() {
            return dishClassId;
        }

        public void setDishClassId(String dishClassId) {
            this.dishClassId = dishClassId;
        }

        public String getQuantity() {
            return quantity;
        }

        public void setQuantity(String quantity) {
            this.quantity = quantity;
        }
    }
}
