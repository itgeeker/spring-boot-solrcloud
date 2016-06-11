package me.highgo.solr.model;

/**
 * GoodsSpec.java
 *
 * @Description : 商品规格实体
 * @Author huangzhiwei
 * @DATE 2016/6/8
 */
public class GoodsSpec {

    /**
     * 规格id
     */
    private Integer id;

    /**
     * 规格名称
     */
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
