package me.highgo.solr.config;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.CloudSolrServer;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertyResolver;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

/**
 * SolrConfig.java
 *
 * @Description : SolrCloud配置类
 * @Author huangzhiwei
 * @DATE 2016/6/8
 */
@Configuration
@EnableSolrRepositories(basePackages = "me.highgo.solr",multicoreSupport = true)
public class SolrConfig implements EnvironmentAware{

    private PropertyResolver propResolver;

    private static final String ZK_HOST = "spring.data.solr.zk-host";
    private static final String DEFAULT_COLLECTION = "goodslist_1";
    private static final int    ZK_CONNECTTIMEOUT = 30000;
    private static final int    ZK_CLIENTTIMEOUT = 30000;

    @Override
    public void setEnvironment(Environment environment) {
        propResolver = new RelaxedPropertyResolver(environment);
    }

    @Bean(name="solrServer")
    public SolrServer cloudSolrClinet(){
        String zkHost = propResolver.getProperty(ZK_HOST);
        CloudSolrServer cloudSolrServer = new CloudSolrServer(zkHost);
        cloudSolrServer.setDefaultCollection(DEFAULT_COLLECTION);
        cloudSolrServer.setZkConnectTimeout(ZK_CONNECTTIMEOUT);
        cloudSolrServer.setZkClientTimeout(ZK_CLIENTTIMEOUT);
        return cloudSolrServer;
    }
}
