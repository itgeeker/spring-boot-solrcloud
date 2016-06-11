package me.highgo.solr.model;

import java.io.Serializable;
import java.util.List;

/**
 * GoodsParam.java
 *
 * @Description : 商品搜索参数实体类
 * @Author huangzhiwei
 * @DATE 2016/6/8
 */
public class GoodsParam implements Serializable{

    private Long id;

    /**
     * 商品品牌列表
     */
    private List<Long> brandIdList;

    /**
     * 商品规格列表
     */
    private List<GoodsSpec> goodsSpecList;

    /**
     * 商品属性列表
     */
    private List<GoodsProperty> goodsPropertyList;

    /**
     * 商品排序列表
     */
    private List<OrderEnum> orderEnumList;

    /**
     * 商品货到付款
     * 0：支持货到付款，-1为不支持货到付款
     * null 为查询全部
     */
    private Integer goodsCod;

    /**
     * 运费承担方式
     * 0为买家承担，1为卖家承担
     * null 查询全部
     */
    private Integer goodsTransfee;

    /**
     * 商品是否有货
     * true为查询库存大于0，false为查询全部
     */
    private Boolean inStock = false;

    /**
     * 商品类型
     * 0为自营商品，1为第三方经销商
     * null 查询全部
     */
    private Integer goodsType;

    /**
     * 产品分类ID
     */
    private List<Long> gcIdList;

    /**
     * 起始行数
     */
    private Integer start;

    /**
     * 行数
     */
    private Integer rows;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getBrandIdList() {
        return brandIdList;
    }

    public void setBrandIdList(List<Long> brandIdList) {
        this.brandIdList = brandIdList;
    }

    public List<GoodsSpec> getGoodsSpecList() {
        return goodsSpecList;
    }

    public void setGoodsSpecList(List<GoodsSpec> goodsSpecList) {
        this.goodsSpecList = goodsSpecList;
    }

    public List<OrderEnum> getOrderEnumList() {
        return orderEnumList;
    }

    public void setOrderEnumList(List<OrderEnum> orderEnumList) {
        this.orderEnumList = orderEnumList;
    }

    public Integer getGoodsCod() {
        return goodsCod;
    }

    public void setGoodsCod(Integer goodsCod) {
        this.goodsCod = goodsCod;
    }

    public Integer getGoodsTransfee() {
        return goodsTransfee;
    }

    public void setGoodsTransfee(Integer goodsTransfee) {
        this.goodsTransfee = goodsTransfee;
    }

    public Boolean getInStock() {
        return inStock;
    }

    public void setInStock(Boolean inStock) {
        this.inStock = inStock;
    }

    public Integer getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Integer goodsType) {
        this.goodsType = goodsType;
    }

    public List<Long> getGcIdList() {
        return gcIdList;
    }

    public void setGcIdList(List<Long> gcIdList) {
        this.gcIdList = gcIdList;
    }

    public List<GoodsProperty> getGoodsPropertyList() {
        return goodsPropertyList;
    }

    public void setGoodsPropertyList(List<GoodsProperty> goodsPropertyList) {
        this.goodsPropertyList = goodsPropertyList;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}
