package com.drawinds.blog.enterprise.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2019/4/6 1:03
 * Description:
 */
@Configuration
@EnableTransactionManagement
@EntityScan("com.drawinds.blog.entity.usercenter.entity")
@EnableJpaRepositories("com.drawinds.blog.repo.usercenter.repo")
public class JpaConfig {
//    @Bean
//    public EntityManagerFactory entityManagerFactory(){
//        return new En
//    }

//    @Bean
//    public TransactionManager transactionManager(){
//        return new JpaTransactionManager();
//    }
}
