package me.highgo.solr;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootSolrcloudApplication implements CommandLineRunner{


	public static void main(String[] args) {
		SpringApplication.run(SpringBootSolrcloudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Product product = productRepository.findOne("2");
//		System.out.println(product);
	}
}
