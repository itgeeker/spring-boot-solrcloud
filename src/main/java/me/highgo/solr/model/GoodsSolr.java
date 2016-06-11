package me.highgo.solr.model;

import org.apache.solr.client.solrj.beans.Field;

import java.io.Serializable;
import java.util.Date;

/**
 * desc
 * Created by ykgao on 12/9/15.
 */
public class GoodsSolr implements Serializable {

    private static final long serialVersionUID = -1964267036221058179L;
    @Field
    private String id;
    @Field
    private String goodsName;
    @Field
    private Long goodsMainPhotoId;
    @Field
    private Date addTime;
    @Field
    private Double goodsCurrentPrice;
    @Field
    private Integer supportTop;
    @Field
    private Integer goodsCollect;
    @Field
    private Double wellEvaluate;
    @Field
    private Integer goodsCod;
    @Field
    private Integer goodsTransfee;
    @Field
    private Integer showStatus;
    @Field
    private Integer goodsInventory;
    @Field
    private Integer goodsType;
    @Field
    private Integer paymentMethod;
    @Field
    private Integer activityStatus;
    @Field
    private Integer groupBuy;
    @Field
    private Long groupId;
    @Field
    private Integer combinStatus;
    @Field
    private Integer orderEnoughGiveStatus;
    @Field
    private Integer enoughReduce;
    @Field
    private Integer fSaleType;
    @Field
    private Integer advanceSaleType;
    @Field
    private Integer goodsSalenum;
    @Field
    private Integer evaluateCount;
    @Field
    private Integer ztcStatus;
    @Field
    private Date ztcBeginTime;
    @Field
    private Integer ztcGold;
    @Field
    private Boolean goodsRecommend;
    @Field
    private Boolean storeRecommend;
    @Field
    private Double storePrice;
    @Field
    private String goodsSpecsInfo;
    @Field
    private Integer goodsStatus;
    @Field
    private String goodsMainPhotoPath;
    @Field
    private String industryMark;
    @Field
    private String brandName;
    @Field
    private String storeName;
    @Field
    private String storeSecondDomain;
    @Field
    private Long gcId;
    @Field
    private Long goodsBrandId;
    @Field
    private Long goodsStoreId;
    @Field
    private String goodsProperty;
    @Field
    private Integer ztcDredgePrice;
    @Field
    private String goodsPhotos;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Long getGoodsMainPhotoId() {
        return goodsMainPhotoId;
    }

    public void setGoodsMainPhotoId(Long goodsMainPhotoId) {
        this.goodsMainPhotoId = goodsMainPhotoId;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Double getGoodsCurrentPrice() {
        return goodsCurrentPrice;
    }

    public void setGoodsCurrentPrice(Double goodsCurrentPrice) {
        this.goodsCurrentPrice = goodsCurrentPrice;
    }

    public Integer getSupportTop() {
        return supportTop;
    }

    public void setSupportTop(Integer supportTop) {
        this.supportTop = supportTop;
    }

    public Integer getGoodsCollect() {
        return goodsCollect;
    }

    public void setGoodsCollect(Integer goodsCollect) {
        this.goodsCollect = goodsCollect;
    }

    public Double getWellEvaluate() {
        return wellEvaluate;
    }

    public void setWellEvaluate(Double wellEvaluate) {
        this.wellEvaluate = wellEvaluate;
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

    public Integer getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(Integer showStatus) {
        this.showStatus = showStatus;
    }

    public Integer getGoodsInventory() {
        return goodsInventory;
    }

    public void setGoodsInventory(Integer goodsInventory) {
        this.goodsInventory = goodsInventory;
    }

    public Integer getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Integer goodsType) {
        this.goodsType = goodsType;
    }

    public Integer getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(Integer paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Integer getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(Integer activityStatus) {
        this.activityStatus = activityStatus;
    }

    public Integer getGroupBuy() {
        return groupBuy;
    }

    public void setGroupBuy(Integer groupBuy) {
        this.groupBuy = groupBuy;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Integer getCombinStatus() {
        return combinStatus;
    }

    public void setCombinStatus(Integer combinStatus) {
        this.combinStatus = combinStatus;
    }

    public Integer getOrderEnoughGiveStatus() {
        return orderEnoughGiveStatus;
    }

    public void setOrderEnoughGiveStatus(Integer orderEnoughGiveStatus) {
        this.orderEnoughGiveStatus = orderEnoughGiveStatus;
    }

    public Integer getEnoughReduce() {
        return enoughReduce;
    }

    public void setEnoughReduce(Integer enoughReduce) {
        this.enoughReduce = enoughReduce;
    }

    public Integer getfSaleType() {
        return fSaleType;
    }

    public void setfSaleType(Integer fSaleType) {
        this.fSaleType = fSaleType;
    }

    public Integer getAdvanceSaleType() {
        return advanceSaleType;
    }

    public void setAdvanceSaleType(Integer advanceSaleType) {
        this.advanceSaleType = advanceSaleType;
    }

    public Integer getGoodsSalenum() {
        return goodsSalenum;
    }

    public void setGoodsSalenum(Integer goodsSalenum) {
        this.goodsSalenum = goodsSalenum;
    }

    public Integer getEvaluateCount() {
        return evaluateCount;
    }

    public void setEvaluateCount(Integer evaluateCount) {
        this.evaluateCount = evaluateCount;
    }

    public Integer getZtcStatus() {
        return ztcStatus;
    }

    public void setZtcStatus(Integer ztcStatus) {
        this.ztcStatus = ztcStatus;
    }

    public Date getZtcBeginTime() {
        return ztcBeginTime;
    }

    public void setZtcBeginTime(Date ztcBeginTime) {
        this.ztcBeginTime = ztcBeginTime;
    }

    public Integer getZtcGold() {
        return ztcGold;
    }

    public void setZtcGold(Integer ztcGold) {
        this.ztcGold = ztcGold;
    }

    public Boolean getGoodsRecommend() {
        return goodsRecommend;
    }

    public void setGoodsRecommend(Boolean goodsRecommend) {
        this.goodsRecommend = goodsRecommend;
    }

    public Boolean getStoreRecommend() {
        return storeRecommend;
    }

    public void setStoreRecommend(Boolean storeRecommend) {
        this.storeRecommend = storeRecommend;
    }

    public Double getStorePrice() {
        return storePrice;
    }

    public void setStorePrice(Double storePrice) {
        this.storePrice = storePrice;
    }

    public String getGoodsSpecsInfo() {
        return goodsSpecsInfo;
    }

    public void setGoodsSpecsInfo(String goodsSpecsInfo) {
        this.goodsSpecsInfo = goodsSpecsInfo;
    }

    public Integer getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(Integer goodsStatus) {
        this.goodsStatus = goodsStatus;
    }

    public String getGoodsMainPhotoPath() {
        return goodsMainPhotoPath;
    }

    public void setGoodsMainPhotoPath(String goodsMainPhotoPath) {
        this.goodsMainPhotoPath = goodsMainPhotoPath;
    }

    public String getIndustryMark() {
        return industryMark;
    }

    public void setIndustryMark(String industryMark) {
        this.industryMark = industryMark;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreSecondDomain() {
        return storeSecondDomain;
    }

    public void setStoreSecondDomain(String storeSecondDomain) {
        this.storeSecondDomain = storeSecondDomain;
    }

    public Long getGcId() {
        return gcId;
    }

    public void setGcId(Long gcId) {
        this.gcId = gcId;
    }

    public Long getGoodsBrandId() {
        return goodsBrandId;
    }

    public void setGoodsBrandId(Long goodsBrandId) {
        this.goodsBrandId = goodsBrandId;
    }

    public Long getGoodsStoreId() {
        return goodsStoreId;
    }

    public void setGoodsStoreId(Long goodsStoreId) {
        this.goodsStoreId = goodsStoreId;
    }

    public String getGoodsProperty() {
        return goodsProperty;
    }

    public void setGoodsProperty(String goodsProperty) {
        this.goodsProperty = goodsProperty;
    }

    public Integer getZtcDredgePrice() {
        return ztcDredgePrice;
    }

    public void setZtcDredgePrice(Integer ztcDredgePrice) {
        this.ztcDredgePrice = ztcDredgePrice;
    }

    public String getGoodsPhotos() {
        return goodsPhotos;
    }

    public void setGoodsPhotos(String goodsPhotos) {
        this.goodsPhotos = goodsPhotos;
    }
}
