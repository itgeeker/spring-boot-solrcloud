package me.highgo.solr.model;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * desc
 * Created by ykgao on 12/9/15.
 */
public class GoodsFront implements Serializable {

    private static final long serialVersionUID = 783033135052292365L;

    private Long id;

    private String goodsName;

    private Long goodsMainPhotoId;

    private Date addTime;

    private String goodsCurrentPrice;

    private Integer supportTop;

    private Integer goodsCollect;

    private String wellEvaluate;

    private Integer goodsCod;

    private Integer goodsTransfee;

    private Integer showStatus;

    private Integer goodsInventory;

    private Integer goodsType;

    private Integer paymentMethod;

    private Integer activityStatus;

    private Integer groupBuy;

    private Long groupId;

    private Integer combinStatus;

    private Integer orderEnoughGiveStatus;

    private Integer enoughReduce;

    private Integer fSaleType;

    private Integer advanceSaleType;

    private Integer goodsSalenum;

    private Integer evaluateCount;

    private Integer ztcStatus;

    private Date ztcBeginTime;

    private Integer ztcGold;

    private Boolean goodsRecommend;

    private Boolean storeRecommend;

    private String storePrice;

    private String goodsSpecsInfo;

    private Integer goodsStatus;

    private String goodsMainPhotoPath;

    private String industryMark;

    private String brandName;

    private String storeName;

    private String storeSecondDomain;

    private Long gcId;

    private Long goodsBrandId;

    private Long goodsStoreId;

    private String goodsProperty;

    private String goodsPhotos;

    private List<String> goodsPhotoList;

    public List<String> getGoodsPhotoList() {
        return goodsPhotoList;
    }

    public void setGoodsPhotoList(List<String> goodsPhotoList) {
        this.goodsPhotoList = goodsPhotoList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getGoodsCurrentPrice() {
        return goodsCurrentPrice;
    }

    public void setGoodsCurrentPrice(String goodsCurrentPrice) {
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

    public String getWellEvaluate() {
        return wellEvaluate;
    }

    public void setWellEvaluate(String wellEvaluate) {
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

    public String getStorePrice() {
        return storePrice;
    }

    public void setStorePrice(String storePrice) {
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

    public String getGoodsPhotos() {
        return goodsPhotos;
    }

    public void setGoodsPhotos(String goodsPhotos) {
        this.goodsPhotos = goodsPhotos;
    }
}
