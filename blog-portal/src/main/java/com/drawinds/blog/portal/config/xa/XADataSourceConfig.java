package com.drawinds.blog.portal.config.xa;

import com.mysql.cj.jdbc.MysqlXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2018/12/31 18:07
 * Description:
 */
@Configuration
public class XADataSourceConfig {

    @Bean
    @Primary
    public DataSource dataSource(XADBConfig config) throws SQLException {
        MysqlXADataSource xaDataSource = new MysqlXADataSource();
        xaDataSource.setURL(config.getUrl());
        xaDataSource.setUser(config.getUsername());
        xaDataSource.setPassword(config.getPassword());
        xaDataSource.setPinGlobalTxToPhysicalConnection(true);

        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setXaDataSource(xaDataSource);
        atomikosDataSourceBean.setUniqueResourceName("dataSource");
//        atomikosDataSourceBean.setMinPoolSize(config.getMinPoolSize());
//        atomikosDataSourceBean.setMaxPoolSize(config.getMaxPoolSize());
//        atomikosDataSourceBean.setMaxLifetime(config.getMaxLifetime());
//        atomikosDataSourceBean.setMaxIdleTime(config.getMaxIdleTime());
//        atomikosDataSourceBean.setBorrowConnectionTimeout(config.getBorrowConnectionTimeout());
//        atomikosDataSourceBean.setLoginTimeout(config.getLoginTimeout());
//        atomikosDataSourceBean.setMaintenanceInterval(config.getMaintenanceInterval());
//        atomikosDataSourceBean.setTestQuery(config.getTestQuery());
        return atomikosDataSourceBean;
    }

    @Bean
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    @Primary
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
