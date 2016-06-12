package me.highgo.solr.util;

import me.highgo.solr.model.GoodsParam;
import me.highgo.solr.model.GoodsProperty;
import me.highgo.solr.model.OrderEnum;
import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.common.params.CommonParams;
import org.apache.solr.common.params.SolrParams;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * SolrQueryBuilder.java
 *
 * @Description : SolrQuery懒汉单例构建器
 * @Author huangzhiwei
 * @DATE 2016/6/9
 */
public class SolrQueryBuilder {

    private SolrQueryBuilder(){}

    private static SolrQueryBuilder solrQueryBuilder = new SolrQueryBuilder();

    public static SolrQueryBuilder getInstance() {
        return solrQueryBuilder;
    }

    public SolrQuery buildSolrQuery(GoodsParam goodsParam) {
        SolrQuery solrQuery = new SolrQuery();

        solrQuery.setRequestHandler(CommonParams.QT);

        String q = buildSolrQ();
        solrQuery.set(CommonParams.Q, q);

        String fq = buildSolrFQ(goodsParam);
        solrQuery.set(CommonParams.FQ, fq);

        buildSolrSort(solrQuery,goodsParam);

        buildSolrpagination(solrQuery,goodsParam);

//        String fl = buildSolrFL();
//        solrQuery.set(CommonParams.FL,fl);

        solrQuery.set(CommonParams.WT,"json");

        return solrQuery;
    }

    private String buildSolrQ() {
        String q = "goodsStatus:0 AND showStatus:1 AND -paymentMethod:2 AND -industryMark:JIAZE AND -industryMark:JIAZA";
        return q;
    }

    private String buildSolrFQ(GoodsParam goodsParam) {
        String fq = "";
        if (goodsParam != null) {
            String brandIds = buildQueryIds(goodsParam.getBrandIdList(),"brandId","OR");
            fq = joinFQ(fq,brandIds);

            String gcIds = this.buildQueryIds(goodsParam.getGcIdList(), "gcId", "OR");
            fq = joinFQ(fq,gcIds);

            // 筛选属性
            if (goodsParam.getGoodsSpecList() != null) {
                String property = this.buildGoodsProperty(goodsParam.getGoodsPropertyList());
                fq = joinFQ(fq,property);
            }

            //是否货到付款 0：支持货到付款，-1为不支持货到付款
            if (goodsParam.getGoodsCod() !=null){
                fq = joinFQ(fq,"goodsCod:"+goodsParam.getGoodsCod());
            }

            // 运费承担方式 0为买家承担，1为卖家承担
            if (goodsParam.getGoodsTransfee() != null) {
                fq = joinFQ(fq,"goodsTransfee:"+goodsParam.getGoodsTransfee());
            }

            // 0为自营商品，1为第三方经销商
            if (goodsParam.getGoodsType() != null) {
                fq = joinFQ(fq,"goodsType:"+goodsParam.getGoodsType());
            }

            // 查询库存大于0（true） false 查询全部
            if (goodsParam.getInStock()) {
                fq = joinFQ(fq,"goodsInventory:[1 TO *]");
            }
        }
       return fq;
    }

    private void buildSolrSort(SolrQuery solrQuery,GoodsParam goodsParam) {
        List<OrderEnum> orderEnumList = goodsParam.getOrderEnumList();
        if (orderEnumList!=null && orderEnumList.size()>0){
            for (int i=0;i<orderEnumList.size();i++){
                OrderEnum orderEnum = orderEnumList.get(i);
                SolrQuery.SortClause sortClause = new SolrQuery.SortClause(orderEnum.getField(),orderEnum.getOrder());
                solrQuery.addSort(sortClause);
            }
        }
    }

    private void buildSolrpagination(SolrQuery solrQuery, GoodsParam goodsParam) {
        if (goodsParam.getStart() !=null){
            solrQuery.set(CommonParams.START,goodsParam.getStart());
        }else{
            solrQuery.set(CommonParams.START,0);
        }
        if (goodsParam.getRows()!=null){
            solrQuery.set(CommonParams.ROWS,goodsParam.getRows());
        }else{
            solrQuery.set(CommonParams.ROWS,10);
        }
    }

    private String buildSolrFL() {
        String fl = "";
        return fl;
    }

    private String joinFQ(String fq,String joint){
        if (StringUtils.isNotBlank(joint)){
            if (StringUtils.isNotBlank(fq)) {
                fq = fq + " AND " + joint;
            }else{
                fq = joint;
            }
        }
        return fq;
    }


    private String buildGoodsProperty(List<GoodsProperty> goodsPropertyList) {
        return null;
    }


    private String buildQueryIds(List<Long> idList, String field, String logicalId) {
        String ids = "";
        if (idList != null && idList.size() > 0) {
            for (int i = 0; i < idList.size(); i++) {
                if (i + 1 == idList.size()) {
                    ids += field + ":" + idList.get(i);
                } else {
                    ids += field + ":" + idList.get(i) + " " + logicalId;
                }

            }
        }
        return ids;

    }

}
