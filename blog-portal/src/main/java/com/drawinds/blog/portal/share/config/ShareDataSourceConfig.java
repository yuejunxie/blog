package com.drawinds.blog.portal.share.config;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2018/12/29 22:21
 * Description:
 */
//@Configuration
public class ShareDataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari.share")
    public DataSource shareDataSource(){
        return new HikariDataSource();
    }

    @Bean
    public SqlSessionFactory shareSqlSessionFactory(@Qualifier("shareDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        return sessionFactoryBean.getObject();
    }

    @Bean
    public DataSourceTransactionManager shareDataSourceTransactionManager(@Qualifier("shareDataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public SqlSessionTemplate shareSqlSessionTemplate(@Qualifier("shareSqlSessionFactory")SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}