package me.highgo.solr.util;

import me.highgo.solr.config.SolrConfig;
import org.apache.solr.client.solrj.impl.CloudSolrServer;

/**
 * CloudSolrServerFactory.java
 *
 * @Description : CloudSolrClient懒汉单例工厂
 * @Author huangzhiwei
 * @DATE 2016/6/9
 */
public class CloudSolrServerFactory {

    private static CloudSolrServerFactory solrServerFactory;

    private CloudSolrServer cloudSolrServer = null;

    private CloudSolrServerFactory() {
    }

    public static synchronized CloudSolrServerFactory getInstance() {
        if (solrServerFactory == null){
            solrServerFactory = new CloudSolrServerFactory();
        }
        return solrServerFactory;
    }

    public synchronized CloudSolrServer getCloudSolrServer(){
        if (cloudSolrServer == null){
            cloudSolrServer = new CloudSolrServer(SolrConfig.zkHost);
            cloudSolrServer.setZkClientTimeout(SolrConfig.zkClientTimeout);
            cloudSolrServer.setZkConnectTimeout(SolrConfig.zkConnectTimeout);
            cloudSolrServer.setDefaultCollection(SolrConfig.defaultCollection);
            cloudSolrServer.connect();
        }
        return cloudSolrServer;
    }

}
