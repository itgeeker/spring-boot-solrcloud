package me.highgo.solr.repository;

import me.highgo.solr.model.Product;
import org.springframework.data.solr.repository.SolrCrudRepository;

/**
 * ProductRepository.java
 *
 * @Description : Solr的仓库
 * @Author huangzhiwei
 * @DATE 2016/6/7
 */
public interface ProductRepository extends SolrCrudRepository<Product,String> {
    Product findByName(String name);
}
