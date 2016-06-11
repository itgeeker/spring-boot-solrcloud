package me.highgo.solr.model;

import java.io.Serializable;

/**
 * OrderEnum.java
 *
 * @Description : 排序枚举类型
 * @Author huangzhiwei
 * @DATE 2016/6/8
 */
public enum OrderEnum  implements Serializable{

    SUPPORTTOP("supportTop", "desc"), //综合
    GOODSSALENUM("goodsSalenum", "desc"), //销量
    GOODSCOLLECT("goodsCollect", "desc"), //人气排行
    WELLEVALUATE("wellEvaluate", "desc"), //好评数
    GOODSPRICEDESC("goodsCurrentPrice", "desc"), //商品价格
    GOODSPRICEASC("goodsCurrentPrice", "asc"),
    LATESTGOODS("addTime", "desc"); //新品

    private String field = null;
    private String order = null;

    OrderEnum(String field, String order) {
        this.field = field;
        this.order = order;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
