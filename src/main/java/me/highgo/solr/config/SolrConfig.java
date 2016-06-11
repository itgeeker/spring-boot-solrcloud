package me.highgo.solr.config;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.CloudSolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.PropertyResolver;
import org.springframework.data.solr.core.SolrTemplate;
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

    @Override
    public void setEnvironment(Environment environment) {
        propResolver = new RelaxedPropertyResolver(environment);
    }


    public static String zkHost;
    public static int zkClientTimeout;
    public static int zkConnectTimeout;
    public static int maxConnections;
    public static String defaultCollection;

    public SolrConfig() {
        zkHost = propResolver.getProperty("spring.data.solr.zk.host");
        zkClientTimeout = Integer.valueOf(propResolver.getProperty("spring.data.solr.zk.client.timeout"));
        zkConnectTimeout = Integer.valueOf(propResolver.getProperty("spring.data.solr.zk.connect.timeout"));
        maxConnections = Integer.valueOf(propResolver.getProperty("spring.data.solr.zk.connect.maxConnections"));
        defaultCollection = propResolver.getProperty("spring.data.solr.defaultCollection");
    }

}
