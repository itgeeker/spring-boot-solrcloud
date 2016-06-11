package me.highgo.solr.service;

import me.highgo.solr.model.*;

/**
 * ProductService.java
 *
 * @Description : 商品列表Service
 * @Author huangzhiwei
 * @DATE 2016/6/11
 */
public interface GoodsService {

    /**
     * 查询商品列表
     * @param goodsParam 查询参数
     * @return
     */
    Page<GoodsFront> queryGoodsList(GoodsParam goodsParam) throws Exception;
}
