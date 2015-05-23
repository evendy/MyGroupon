package cn.evendy.groupon.module;

/**
 * @author: evendy
 * @time: 2015/5/23 09:50
 * @mail: 244085027@qq.com
 */
public class GrouponBaseDTO {
    /**
     * 名称
     */
    private String name;
    /**
     * 描述
     */
    private String describe;
    /**
     * 价格
     */
    private float price;
    /**
     * 已售数量
     */
    private int saleNumber;
    /**
     * 图片
     */
    private String iConUrl;
    /**
     * 特价
     */
    private float salePrice;
    /**
     * 原价
     */
    private float originalPrice;
    /**
     * 是否列表
     */
    private boolean group;
    /**
     * 是否属于精选
     */
    private boolean feature;
    /**
     * 是否属于特殊推荐
     */
    private boolean special;
    /**
     * 是否主页显示
     */
    private boolean homeShow;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getIConUrl() {
        return iConUrl;
    }

    public void setIConUrl(String iConUrl) {
        this.iConUrl = iConUrl;
    }

    public boolean isGroup() {
        return group;
    }

    public void setGroup(boolean group) {
        this.group = group;
    }

    public boolean isFeature() {
        return feature;
    }

    public void setFeature(boolean feature) {
        this.feature = feature;
    }

    public boolean isSpecial() {
        return special;
    }

    public void setSpecial(boolean special) {
        this.special = special;
    }

    public boolean isHomeShow() {
        return homeShow;
    }

    public void setHomeShow(boolean homeShow) {
        this.homeShow = homeShow;
    }

    public int getSaleNumber() {
        return saleNumber;
    }

    public void setSaleNumber(int saleNumber) {
        this.saleNumber = saleNumber;
    }

    public float getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(float originalPrice) {
        this.originalPrice = originalPrice;
    }

    public float getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(float salePrice) {
        this.salePrice = salePrice;
    }
}
