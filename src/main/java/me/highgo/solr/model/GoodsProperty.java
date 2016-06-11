package me.highgo.solr.model;

import java.io.Serializable;

/**
 * GoodsProperty.java
 *
 * @Description : 商品属性列表
 * @Author huangzhiwei
 * @DATE 2016/6/8
 */
public class GoodsProperty implements Serializable {

    private static final long serialVersionUID = -1827118363915596131L;

    /**
     * 属性ID
     */
    private String id;
    /**
     * 属性名称
     */
    private String name;
    /**
     * 属性值
     */
    private String value;
    /**
     * 是否过滤掉
     */
    private int isShow = 1;

    public int getIsShow() {
        return isShow;
    }

    public void setIsShow(int isShow) {
        this.isShow = isShow;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

