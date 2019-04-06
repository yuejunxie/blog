package com.drawinds.blog.enterprise.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2019/4/6 0:27
 * Description:
 */
//@Configuration
public class DatasourceConfig {

    public static final String DATASOURCE_PREFIX = "spring.datasource";

    @Autowired
    private Environment environment;

//    @Bean
//    @ConfigurationProperties(prefix = DATASOURCE_PREFIX)
//    public DataSource dataSource() {
//        Properties dbProperties = new Properties();
//        Map<String, Object> map = new HashMap<>();
//        for (PropertySource<?> propertySource : ((AbstractEnvironment) environment).getPropertySources()) {
//            getPropertiesFromSource(propertySource, map);
//        }
//        dbProperties.putAll(map);
//        HikariDataSource dds;
//        try {
//            dds = (HikariDataSource) HikariDataSource.createDataSource(dbProperties);
//            dds.init();
//        } catch (Exception e) {
//            throw new RuntimeException("load datasource error, dbProperties is :" + dbProperties, e);
//        }
//        return dds;
//    }

//    private void getPropertiesFromSource(PropertySource<?> propertySource, Map<String, Object> map) {
//        if (propertySource instanceof MapPropertySource) {
//            for (String key : ((MapPropertySource) propertySource).getPropertyNames()) {
//                if (key.startsWith(DATASOURCE_PREFIX))
//                    map.put(key.replaceFirst(DATASOURCE_PREFIX, ""), propertySource.getProperty(key));
//                else if (key.startsWith(DATASOURCE_PREFIX))
//                    map.put(key.replaceFirst(DATASOURCE_PREFIX, ""), propertySource.getProperty(key));
//            }
//        }
//
//        if (propertySource instanceof CompositePropertySource) {
//            for (PropertySource<?> s : ((CompositePropertySource) propertySource).getPropertySources()) {
//                getPropertiesFromSource(s, map);
//            }
//        }
//    }

//    @Bean
//    public ServletRegistrationBean druidServlet() {
//        return new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
//    }

//    @Bean
//    public FilterRegistrationBean filterRegistrationBean() {
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//        filterRegistrationBean.setFilter(new WebStatFilter());
//        filterRegistrationBean.addUrlPatterns("/*");
//        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
//        return filterRegistrationBean;
//    }

}
