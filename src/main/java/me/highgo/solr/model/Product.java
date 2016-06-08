package me.highgo.solr.model;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.util.Date;

/**
 * Product.java
 *
 * @Description : SolrCloud的Model类
 * @Author huangzhiwei
 * @DATE 2016/6/3
 */
public class Product {
    //商品ID
    @Field
    @Indexed
    private Integer id;

    //商品名称
    @Field
    @Indexed
    private String name;

    //商品分类ID
    @Field
    private Integer catalog;

    //商品分类名称
    @Field
    private String catalog_name;

    //商品价格
    @Field
    private Double price;

    //商品图片
    @Field
    private String picture;

    //发布时间
    @Field
    private Date release_time;

    //版本
    @Field
    private String _version_;

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

    public Integer getCatalog() {
        return catalog;
    }

    public void setCatalog(Integer catalog) {
        this.catalog = catalog;
    }

    public String getCatalog_name() {
        return catalog_name;
    }

    public void setCatalog_name(String catalog_name) {
        this.catalog_name = catalog_name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Date getRelease_time() {
        return release_time;
    }

    public void setRelease_time(Date release_time) {
        this.release_time = release_time;
    }

    public String get_version_() {
        return _version_;
    }

    public void set_version_(String _version_) {
        this._version_ = _version_;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", catalog=" + catalog +
                ", catalog_name='" + catalog_name + '\'' +
                ", price=" + price +
                ", picture='" + picture + '\'' +
                '}';
    }
}

