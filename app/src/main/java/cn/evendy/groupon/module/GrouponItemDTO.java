package cn.evendy.groupon.module;

import java.util.List;

/**
 * @author: evendy
 * @time: 2015/5/23 09:57
 * @mail: 244085027@qq.com
 */
public class GrouponItemDTO extends GrouponBaseDTO {

    /**
     * 是否比其他团购低价
     */
    private boolean isLow;
    /**
     * 比其他团购低价的描述
     */
    private String saleDescribe;
    /**
     * 活动列表
     */
    private List<String> actives;
    /**
     * 距离
     */
    private float distance;
    /**
     * 闪发
     */
    private boolean flashPush;
    /**
     * 免预约
     */
    private boolean freeAppoint;

    /**
     * 销售价
     */
    private float sellingPrice;

    /**
     * 评分
     */
    private float score;

    /**
     * 是否优惠券
     */
    private boolean isTicket;

    /**
     * 是否有会员权益
     */
    private boolean vipRight;

    public boolean isLow() {
        return isLow;
    }

    public void setIsLow(boolean isLow) {
        this.isLow = isLow;
    }

    public String getSaleDescribe() {
        return saleDescribe;
    }

    public void setSaleDescribe(String saleDescribe) {
        this.saleDescribe = saleDescribe;
    }

    public List<String> getActives() {
        return actives;
    }

    public void setActives(List<String> actives) {
        this.actives = actives;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public boolean isFlashPush() {
        return flashPush;
    }

    public void setFlashPush(boolean flashPush) {
        this.flashPush = flashPush;
    }

    public boolean isFreeAppoint() {
        return freeAppoint;
    }

    public void setFreeAppoint(boolean freeAppoint) {
        this.freeAppoint = freeAppoint;
    }

    public float getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(float sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public boolean isTicket() {
        return isTicket;
    }

    public void setIsTicket(boolean isTicket) {
        this.isTicket = isTicket;
    }

    public boolean isVipRight() {
        return vipRight;
    }

    public void setVipRight(boolean vipRight) {
        this.vipRight = vipRight;
    }
}
