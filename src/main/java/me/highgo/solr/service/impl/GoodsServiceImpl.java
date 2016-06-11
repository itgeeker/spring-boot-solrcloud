package me.highgo.solr.service.impl;

import me.highgo.solr.model.GoodsFront;
import me.highgo.solr.model.GoodsParam;
import me.highgo.solr.model.GoodsSolr;
import me.highgo.solr.model.Page;
import me.highgo.solr.service.GoodsService;
import me.highgo.solr.util.CloudSolrServerFactory;
import me.highgo.solr.util.ResultConverter;
import me.highgo.solr.util.SolrQueryBuilder;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.CloudSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;

import java.util.List;

/**
 * GoodsServiceImpl.java
 *
 * @Description : 商品service服务实现类
 * @Author huangzhiwei
 * @DATE 2016/6/11
 */
public class GoodsServiceImpl implements GoodsService {
    @Override
    public Page<GoodsFront> queryGoodsList(GoodsParam goodsParam) throws Exception {
        if (goodsParam!=null){
            SolrQuery solrQuery = SolrQueryBuilder.getInstance().buildSolrQuery(goodsParam);

            CloudSolrServer cloudSolrServer = CloudSolrServerFactory.getInstance().getCloudSolrServer();

            QueryResponse response = cloudSolrServer.query(solrQuery);
            List<GoodsSolr> goodsSolrList = response.getBeans(GoodsSolr.class);

            List<GoodsFront> goodsFrontList = ResultConverter.converter(goodsSolrList);

            return new Page<GoodsFront>(goodsParam.getRows(), goodsParam.getStart(), goodsFrontList, response.getResults().getNumFound());

        }

        return null;
    }
}
