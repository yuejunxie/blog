package com.drawinds.blog.portal.share.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Author: JackyShieh
 * Corporation: CornerStone LTD
 * WE LINK
 * blog
 * Created: 2018/12/28 23:00
 * Description:
 */
@Configuration
@MapperScan(basePackages = "com.drawinds.blog.portal.share.mapper", sqlSessionFactoryRef = "shareSqlSessionFactory")
public class ShareMyBatisConfig {
}
