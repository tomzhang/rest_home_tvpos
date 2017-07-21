package com.yonyou.hhtpos.bean.dish;

import com.yonyou.framework.library.common.utils.StringUtil;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zj on 2017/7/15.
 * 邮箱：zjuan@yonyou.com
 * 描述：外卖-点菜列表实体类
 */
public class DishesEntity implements Serializable {
    /**
     * 套餐菜品价格
     */
    private String comboDishPrice;

    /**
     * 适合人数
     */
    public int comboForPsnnum;

    /**
     * 公司id
     */
    public String companyId;

    /**
     * 描述
     */
    public String description;

    /**
     * 菜品编码
     */
    public String dishCode;

    /**
     * 菜品名称
     */
    public String dishName;

    /**
     * 菜品类型
     */
    public String dishType;
    /**
     * 与菜类关联的菜品id
     */
    public String dishTypeRelateId;

    /**
     * 套餐菜品组
     */
    public List<GroupDishEntity> groups;

    /**
     * id
     */
    public String id;

    /**
     * 介绍
     */
    public String introduction;
    /**
     * 是否打折
     */
    public String isDiscount;
    /**
     * 赠与否
     */
    public String isGift;
    /**
     * 是否是称重菜
     */
    public String isWeigh;
    /**
     * 菜品价格
     */
    private String price;
    /**
     * 标签列表
     */
    public List<DishLabelEntity> labels;

    /**
     * 做法列表
     */

    public List<DishPriceEntity> practices;

    /***/
    public String printOutTypeId;

    /**
     * 关联id
     */
    public String relateId;


    /***/
    public List<DishRemarkEntity> remarks;

    /**
     * 销售模式
     */
    public String saleManne;

    /**
     * 门店菜类关联ID
     */
    public String shopDishTypeRelateId;
    /**
     * shopId
     */
    public String shopId;
    /**
     * 排序号
     */
    public String sortNo;

    /**
     * 规格列表
     */
    public List<DishStandardEntity> standards;

    /**
     * 口味列表
     */
    public List<DishTastesEntity> tastes;
    /**
     * 重量
     */
    public String weight;

    /**
     * 标记是否选中
     */
    public boolean isCheck;


    public DishesEntity() {
    }

    public String getComboDishPrice() {
        return StringUtil.getFormattedMoney(comboDishPrice);
    }

    public void setComboDishPrice(String comboDishPrice) {
        this.comboDishPrice = comboDishPrice;
    }

    public String getPrice() {
        return StringUtil.getFormattedMoney(price);
    }

    public void setPrice(String dishPrice) {
        this.price = dishPrice;
    }

    @Override
    public String toString() {
        return "DishesEntity{" +
                "comboDishPrice='" + comboDishPrice + '\'' +
                ", comboForPsnnum=" + comboForPsnnum +
                ", companyId='" + companyId + '\'' +
                ", description='" + description + '\'' +
                ", dishCode='" + dishCode + '\'' +
                ", dishName='" + dishName + '\'' +
                ", dishType='" + dishType + '\'' +
                ", dishTypeRelateId='" + dishTypeRelateId + '\'' +
                ", groups=" + groups +
                ", id='" + id + '\'' +
                ", introduction='" + introduction + '\'' +
                ", isDiscount='" + isDiscount + '\'' +
                ", isGift='" + isGift + '\'' +
                ", isWeigh='" + isWeigh + '\'' +
                ", dishPrice='" + price + '\'' +
                ", labels=" + labels +
                ", practices=" + practices +
                ", printOutTypeId='" + printOutTypeId + '\'' +
                ", relateId='" + relateId + '\'' +
                ", remarks=" + remarks +
                ", saleManne='" + saleManne + '\'' +
                ", shopDishTypeRelateId='" + shopDishTypeRelateId + '\'' +
                ", shopId='" + shopId + '\'' +
                ", sortNo='" + sortNo + '\'' +
                ", standards=" + standards +
                ", tastes=" + tastes +
                ", weight='" + weight + '\'' +
                ", isCheck=" + isCheck +
                '}';
    }
}