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
}
