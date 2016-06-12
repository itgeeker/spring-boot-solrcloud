package me.highgo.solr.util;

import me.highgo.solr.model.GoodsFront;
import me.highgo.solr.model.GoodsSolr;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ResultConverter.java
 *
 * @Description : 结果转换器
 * @Author huangzhiwei
 * @DATE 2016/6/11
 */
public class ResultConverter {

    //构建商品返回结果
    public static List<GoodsFront> converter(List<GoodsSolr> goodsSolrList) throws Exception {
        if (goodsSolrList !=null && goodsSolrList.size()>0){
            List<GoodsFront> goodsFrontList = new ArrayList();
            for (GoodsSolr goodsSolr : goodsSolrList) {
                GoodsFront goodsFront = new GoodsFront();

                BeanUtils.copyProperties(goodsFront, goodsSolr);

                //单独处理的属性
                String goodsCurrentPrice = goodsFront.getGoodsCurrentPrice();
                String goodsStorePrice = goodsFront.getStorePrice();

                BigDecimal goodsPrice = new BigDecimal(goodsCurrentPrice);
                BigDecimal storePrice = new BigDecimal(goodsStorePrice);

                goodsFront.setGoodsCurrentPrice(goodsPrice.setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                goodsFront.setStorePrice(storePrice.setScale(2, BigDecimal.ROUND_HALF_UP).toString());

                String goodsPhotos = goodsFront.getGoodsPhotos();
                if (StringUtils.isNotBlank(goodsPhotos)) {
                    String[] goodsPhotoArray = goodsPhotos.split("\\|");
                    if (goodsPhotoArray != null && goodsPhotoArray.length > 0) {
                        goodsFront.setGoodsPhotoList(Arrays.asList(goodsPhotoArray));
                    }
                }
                goodsFrontList.add(goodsFront);
            }
            return goodsFrontList;
        }
        return null;
    }
}
