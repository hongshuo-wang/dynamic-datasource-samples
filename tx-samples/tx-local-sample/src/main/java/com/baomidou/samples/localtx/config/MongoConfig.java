package com.baomidou.samples.localtx.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDbFactory;

@Configuration
public class MongoConfig {


    @Value("${spring.data.mongodb.first.uri}")
    private String firstUri;

    @Value("${spring.data.mongodb.second.uri}")
    private String secondUri;

    @Value("${spring.data.mongodb.three.uri}")
    private String threeUri;

    @Value("${spring.data.mongodb.client.uri}")
    private String clientUri;


    @Bean(name = "firstMongoTemplate")
    public MongoTemplate firstMongoTemplate() throws Exception {
        SimpleMongoClientDbFactory simpleMongoClientDbFactory = new SimpleMongoClientDbFactory(this.firstUri);
        return new MongoTemplate(simpleMongoClientDbFactory);
    }

    /**
     * 默认读转换前的
     *
     * @return
     * @throws Exception
     */
    @Primary
    @Bean(name = "mongoTemplate")
    public MongoTemplate mongoTemplate() throws Exception {
        SimpleMongoClientDbFactory simpleMongoClientDbFactory = new SimpleMongoClientDbFactory(this.secondUri);
        return new MongoTemplate(simpleMongoClientDbFactory);
    }


    @Bean(name = "threeMongoTemplate")
    public MongoTemplate threeMongoTemplate() throws Exception {
        SimpleMongoClientDbFactory simpleMongoClientDbFactory = new SimpleMongoClientDbFactory(this.threeUri);
        return new MongoTemplate(simpleMongoClientDbFactory);
    }

    @Bean(name = "clientMongoTemplate")
    public MongoTemplate clientMongoTemplate() throws Exception {
        SimpleMongoClientDbFactory simpleMongoClientDbFactory = new SimpleMongoClientDbFactory(this.clientUri);
        return new MongoTemplate(simpleMongoClientDbFactory);
    }

    @Bean("mongoTransactionManager")
    MongoTransactionManager mongoTransactionManager(MongoDatabaseFactory factory) {
        return new MongoTransactionManager(factory);
    }
}
