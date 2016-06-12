package me.highgo.solr;

import me.highgo.solr.model.*;
import me.highgo.solr.repository.ProductRepository;
import me.highgo.solr.service.GoodsService;
import me.highgo.solr.util.CloudSolrServerFactory;
import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.FacetField;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.params.CommonParams;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringBootSolrcloudApplication.class)
public class SpringBootSolrcloudApplicationTests {

	@Autowired
	private ProductRepository productRepository;

//	@Autowired
//	private SolrTemplate solrTemplate;

	@Autowired
	private HttpSolrServer httpSolrServer;

	@Autowired
	private GoodsService goodsService;

	@Test
	public void contextLoads() {
	}

	@Test
	/**
	 * 单字段查询
	 * 查询字段如果是中文分词字段，则支持关键字查询
	 */
	public void testFindByName(){
//		Product product = productRepository.findByName("家天下达贺第二代洗头刷洗发梳6658");
		Product product = productRepository.findByName("洗发梳");
		System.out.println(product);
	}

	@Test
	/**
	 * 重构后的商品列表查询
	 */
	public void testQueryGoodsList() throws Exception {
		GoodsParam goodsParam = new GoodsParam();
		List<Long> gcIds = new ArrayList<>();
		gcIds.add(10l);

		//添加商品分类
		goodsParam.setGcIdList(gcIds);
		//货到付款
		goodsParam.setGoodsCod(0);
		//卖家承担运费
		goodsParam.setGoodsTransfee(1);
		//设置排序
		ArrayList<OrderEnum> orderEnumList = new ArrayList();
		orderEnumList.add(OrderEnum.SUPPORTTOP); //默认排序
		goodsParam.setOrderEnumList(orderEnumList);
		//只显示有货
		goodsParam.setInStock(true);
		goodsParam.setGoodsType(1);
		goodsParam.setStart(0);
		goodsParam.setRows(10);

		Page<GoodsFront> goodsFrontPage = goodsService.queryGoodsList(goodsParam);
		System.out.println("查询完毕");
	}

	@Test
	public void testFacetQuery() throws SolrServerException {
		SolrQuery solrQuery = new SolrQuery();
		solrQuery.set(CommonParams.Q,"goodsStatus:0 AND showStatus:1 AND -paymentMethod:2 AND -industryMark:JIAZE AND -industryMark:JIAZA");
		solrQuery.set(CommonParams.FQ,"gcId:");//564 手机id
		solrQuery.setFacet(true); //开启Facet
		solrQuery.addFacetField("goodsProperty");
		solrQuery.setFacetMinCount(2); //获取重复数量大于2
		solrQuery.setFacetLimit(15);
		solrQuery.setFacetSort("count");

		CloudSolrServer cloudSolrServer = CloudSolrServerFactory.getInstance().getCloudSolrServer();
		QueryResponse response = cloudSolrServer.query(solrQuery);
		List<FacetField> facetFields = response.getFacetFields();
		for (FacetField facet : facetFields){
			List<FacetField.Count> facetValues = facet.getValues();
			for (FacetField.Count count : facetValues)
				System.out.println(count.getName()+"数量"+count.getCount());
		}
	}

	@Test
	/**
	 * 多字段查询
	 */
	public void testFindByCriterial() throws Exception {
		GoodsParam goodsParam = new GoodsParam();
		List<Long> gcIds = new ArrayList<>();
		gcIds.add(10l);

		//添加商品分类
		goodsParam.setGcIdList(gcIds);
		//货到付款
		goodsParam.setGoodsCod(0);
		//卖家承担运费
		goodsParam.setGoodsTransfee(1);
		//设置排序
		ArrayList<OrderEnum> orderEnumList = new ArrayList();
		orderEnumList.add(OrderEnum.SUPPORTTOP); //默认排序
		goodsParam.setOrderEnumList(orderEnumList);
		//只显示有货
		goodsParam.setInStock(true);
		goodsParam.setGoodsType(0);

		SolrQuery solrQuery = buildQueryGoodsListParams(goodsParam);
		QueryResponse queryResponse = httpSolrServer.query(solrQuery);
	}

	SolrQuery buildQueryGoodsListParams(GoodsParam goodsParam) throws Exception {
		SolrQuery solrQuery = new SolrQuery();
		String q = "goodsStatus:0 AND showStatus:1 AND -paymentMethod:2 AND -industryMark:JIAZE AND -industryMark:JIAZA";
		String fq = "";
		fq = buildQueryGoodsListFq(goodsParam);

		solrQuery.setQuery(q);
		solrQuery.setStart(0);
		solrQuery.setRows(10);
		solrQuery.setFilterQueries(fq);
		buildOrderFields(solrQuery, goodsParam.getOrderEnumList());
		return solrQuery;
	}

	/**
	 * 构建查询语句
	 * @param idList
	 * @param field
	 * @param type
	 * @return
	 */
	private String buildQueryIds(List<Long> idList, String field, String type) {
		String ids = "";
		if (idList != null) {
			for (int i = 0; i < idList.size(); i++) {
				if (i + 1 == idList.size()) {
					ids = ids + field + ":" + idList.get(i);
				} else {
					ids = ids + field + ":" + idList.get(i) + " " + type + " ";
				}
			}
		}
		return ids;
	}

	private String buildQueryGoodsListFq(GoodsParam goodsParam) throws Exception {
		String fq = "";
		if (goodsParam != null) {
			//是否货到付款 0：支持货到付款，-1为不支持货到付款
			if (goodsParam.getGoodsCod() != null) {
				fq = "goodsCod:" + goodsParam.getGoodsCod();
			}
			// 运费承担方式 0为买家承担，1为卖家承担
			if (goodsParam.getGoodsTransfee() != null) {
				if (StringUtils.isNotBlank(fq)) {
					fq = fq + " AND goodsTransfee:" + goodsParam.getGoodsTransfee();
				} else {
					fq = "goodsTransfee:" + goodsParam.getGoodsTransfee();
				}
			}
			// 查询库存大于0（true） f
			//
			// alse 查询全部
			if (goodsParam.getInStock()) {
				if (StringUtils.isNotBlank(fq)) {
					fq = fq + " AND goodsInventory:[1 TO *]";
				} else {
					fq = "goodsInventory:[1 TO *]";
				}
			}
			// 0为自营商品，1为第三方经销商
			if (goodsParam.getGoodsType() != null) {
				if (StringUtils.isNotBlank(fq)) {
					fq = fq + " AND goodsType:" + goodsParam.getGoodsType();
				} else {
					fq = "goodsType:" + goodsParam.getGoodsType();
				}
			}
			// 品牌设置
			String brandIds = this.buildQueryIds(goodsParam.getBrandIdList(), "goodsBrandId", "OR");
			if (StringUtils.isNotBlank(brandIds)) {
				if (StringUtils.isNotBlank(fq)) {
					fq = fq + " AND (" + brandIds + ")";
				} else {
					fq = fq + "(" + brandIds + ")";
				}
			}
			// 商品分类
			String gcIds = this.buildQueryIds(goodsParam.getGcIdList(), "gcId", "OR");
			if (StringUtils.isNotBlank(gcIds)) {
				if (StringUtils.isNotBlank(fq)) {
					fq = fq + " AND (" + gcIds + ")";
				} else {
					fq = fq + "(" + gcIds + ")";
				}
			}
			// 筛选属性
			if (goodsParam.getGoodsSpecList() != null) {
				String property = this.buildGoodsProperty(goodsParam.getGoodsPropertyList());
				if (StringUtils.isNotBlank(property)) {
					if (StringUtils.isNotBlank(fq)) {
						fq = fq + " AND " + property;
					}
				}
			}

		}
		return fq;
	}

	/**
	 * 构建搜索属性查询条件
	 *
	 * @param goodsProperties goodsProperties
	 * @return fq
	 */
	private String buildGoodsProperty(List<GoodsProperty> goodsProperties) {
		String property = "";
		if (goodsProperties != null) {
			for (int i = 0; i < goodsProperties.size(); i++) {
				GoodsProperty goodsPorperty = goodsProperties.get(i);
				String id = goodsPorperty.getId();
				String name = goodsPorperty.getName();
				String value = goodsPorperty.getValue();
				if ("price".equals(name)) {
					String[] splits = value.split("-");
					if (splits != null) {
						if (splits.length == 1) {
							String start = splits[0].replaceAll("[\u4e00-\u9fa5]", "");
							if (i + 1 == goodsProperties.size()) {
								property = property + "goodsCurrentPrice:[" + start + " TO *]";
							} else {
								property = property + "goodsCurrentPrice:[" + start + " TO *] AND ";
							}
						} else if (splits.length == 2) {
							String start = splits[0].replaceAll("[\u4e00-\u9fa5]", "");
							String end = splits[1].replaceAll("[\u4e00-\u9fa5]", "");
							if (i + 1 == goodsProperties.size()) {
								property = property + "goodsCurrentPrice:[" + start + " TO " + end + "]";
							} else {
								property = property + "goodsCurrentPrice:[" + start + " TO " + end + "] AND ";
							}
						}
					}

				} else {
					if (i + 1 == goodsProperties.size()) {
						property = property + "goodsProperty:" + id + " AND goodsProperty:" + value + "";
					} else {
						property = property + "goodsProperty:" + id + " AND goodsProperty:" + value + " AND ";
					}
				}

			}
		}
		return property;
	}

	/**
	 * 构建排序条件
	 *
	 * @param orderEnums 排序枚举
	 * @return String
	 */
	private void buildOrderFields(SolrQuery solrQuery,List<OrderEnum> orderEnums) {
		if (orderEnums != null && orderEnums.size() > 0) {
			for (int i = 0; i < orderEnums.size(); i++) {
				OrderEnum orderEnum = orderEnums.get(i);
				SolrQuery.SortClause sortClause = new SolrQuery.SortClause(orderEnum.getField(),orderEnum.getOrder());
				solrQuery.addSort(sortClause);
			}
		}
	}

}
