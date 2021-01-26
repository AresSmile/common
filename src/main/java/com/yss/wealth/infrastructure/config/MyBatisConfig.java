/****************************************************
 * 创建人：  @author hechengcheng
 * 创建时间: 2019-6-7/14:30:36
 * 项目名称: dfas-common-util
 * 文件名称: MyBatisConfig.java
 * 文件描述: @Description
 * 公司名称: 深圳市赢时胜信息技术有限公司
 *
 * All rights Reserved, Designed By 深圳市赢时胜信息技术有限公司
 * @Copyright:2019-2030
 *
 ********************************************************/

package com.yss.wealth.infrastructure.config;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.mapping.VendorDatabaseIdProvider;
import org.apache.ibatis.session.LocalCacheScope;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

/**
 * Mybatis基础配置
 * 包名称： com.win.dfas.common.config 
 * 类名称：MyBatisConfig 
 * 类描述：TODO
 * 创建人：@author wanglei 
 * 创建时间：2019年8月7日/上午11:32:24
 *
 */
@Configuration
@MapperScan(basePackages = "com.yss.**.domain.mapper", sqlSessionFactoryRef = "defaultSqlSessionFactory")
@Conditional(MyBatisCondition.class)
@RefreshScope
public class MyBatisConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyBatisConfig.class);

    @Autowired
    private Environment env;

    /**
     * @Title: defaultDataSource
     * @Description: 创建数据源
     * @return DataSource
     * @throws SQLException
     */
    @Primary
    @Bean(name = "defaultDataSource")
    public DataSource defaultDataSource() throws SQLException {
        String sDriver = env.getProperty("spring.datasource.driver-class-name");
        if (StringUtils.isEmpty(sDriver)) {
            return null;
        }

        HikariDataSource dataSource = new HikariDataSource();
//        dataSource.setJdbcUrl();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        dataSource.setJdbcUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));
        //心跳检查
        dataSource.setConnectionTestQuery(env.getProperty("spring.datasource.hikari.connection-test-query"));
        /** 配置获取连接等待超时的时间 毫秒 */
        String maxWait = env.getProperty("spring.datasource.hikari.connection-timeout");
        if (StrUtil.isNotBlank(maxWait)) {
            dataSource.setConnectionTimeout(Long.parseLong(maxWait));
        }
        /** 最大并发连接数 maximum-pool-size */
        String maxActive = env.getProperty("spring.datasource.hikari.maximum-pool-size");
        if (StrUtil.isNotBlank(maxActive)) {
            dataSource.setMaximumPoolSize(Integer.parseInt(maxActive));
        }
        /** 最小空闲连接数 minIdle 官方建议不设置*/
        String minIdle = env.getProperty("spring.datasource.hikari.minimum-idle");
        if (StrUtil.isNotBlank(minIdle)) {
            dataSource.setMinimumIdle(Integer.parseInt(minIdle));
        }
        /** idleTimeout 空闲连接释放最大时间-最大空闲连接时间*/
        String idleTimeout = env.getProperty("spring.datasource.hikari.idle-timeout");
        if (StrUtil.isNotBlank(idleTimeout)) {
            dataSource.setIdleTimeout(Long.parseLong(idleTimeout));
        }
        /** maxLifetime 连接的最大生命周期*/
        String maxLifetime = env.getProperty("spring.datasource.hikari.max-lifetime");
        if (StrUtil.isNotBlank(maxLifetime)) {
            dataSource.setMaxLifetime(Long.parseLong(maxLifetime));
        }
        /**设置连接池名*/
        String poolname = env.getProperty("spring.datasource.hikari.pool-name");
        if (StrUtil.isNotBlank(poolname)) {
            dataSource.setPoolName(poolname);
        }
        return dataSource;
    }

	private String buildTypeAliasesPackage(String packagePattern) throws IOException,ClassNotFoundException {
		String typeAliasesPackage = "";
		Set<String> packageNames = new TreeSet<String>();
		ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
		MetadataReaderFactory readerFactory = new CachingMetadataReaderFactory(resourcePatternResolver);

		for (Resource resource : resourcePatternResolver.getResources(packagePattern)) {
			if (resource.isReadable()) {
				MetadataReader reader = readerFactory.getMetadataReader(resource);
				String className = reader.getClassMetadata().getClassName();
				packageNames.add(className.substring(0, className.lastIndexOf('.')));
			}
		}

		if (!CollectionUtil.isEmpty(packageNames)) {
			typeAliasesPackage = StringUtils.collectionToDelimitedString(packageNames,
					ConfigurableApplicationContext.CONFIG_LOCATION_DELIMITERS);
		}

		return typeAliasesPackage;
	}
	
	/**
	 * 
	 * @Title: databaseIdProvider
	 * @Description: 数据库识别
	 * @return   
	 * @return: DatabaseIdProvider   
	 * @throws
	 * @author: hechengcheng 
	 * @Date:  2020年4月15日/下午3:42:14
	 */
	@Bean
	public DatabaseIdProvider databaseIdProvider() {
		
		DatabaseIdProvider databaseIdProvider = new VendorDatabaseIdProvider();
		
	    Properties properties = new Properties();
	    
	    properties.setProperty("MySQL", "mysql");
	    properties.setProperty("Oracle", "oracle");
	    
	    databaseIdProvider.setProperties(properties);
	    
	    return databaseIdProvider;
	}
    
    /**
     * @Title: sqlSessionFactoryBean
     * @Description: 获取session工厂
     * @param defaultDataSource 默认的数据源
     * @return SqlSessionFactory
     */
    @Primary
    @Bean(name = "defaultSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean(@Qualifier("defaultDataSource") DataSource defaultDataSource) {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        /**
         * 关于session的全局缓存，否则将导致同一微服务部署多台，缓存不同步问题，
         * 需要设置 CacheEnabled=false ，LocalCacheScope=Statement
         */
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setCacheEnabled(false);
        configuration.setLocalCacheScope(LocalCacheScope.STATEMENT);
        //打开下划线转驼峰开关
        configuration.setMapUnderscoreToCamelCase(true);
//        默认将空值jdbcType设置为null
        configuration.setJdbcTypeForNull(JdbcType.NULL);
        bean.setConfiguration(configuration);

        bean.setDataSource(defaultDataSource);
        bean.setVfs(SpringBootVFS.class);
        bean.setDatabaseIdProvider(databaseIdProvider());
        
        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
        	bean.setTypeAliasesPackage(buildTypeAliasesPackage(Optional.ofNullable(env.getProperty("mybatis.type-aliases-package")).orElse("classpath*:com/win/**/entity/*.class")));
            bean.setMapperLocations(resolver.getResources(Optional.ofNullable(env.getProperty("mybatis.mapperLocations")).orElse("classpath*:com/win/**/entity/*.class")));
            return bean.getObject();
        } catch (Exception e) {
        	LOGGER.error("mybatis初始化sqlSessionFactoryBean失败", e);
        }
        return null;
    }
    
    /**
     * @Title: sqlSessionTemplate
     * @Description: sqlSessionTemplate实例
     * @param sqlSessionFactory session工厂
     * @return SqlSessionTemplate
     */
    @Primary
    @Bean("defaultSqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
    	return new SqlSessionTemplate(sqlSessionFactory);
    }

    /**
     * @Title: transactionManager
     * @Description: 事物管理
     * @param dataSource 数据源
     * @return DataSourceTransactionManager
     */
    @Primary
    @Bean(name = "defaultTransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("defaultDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}

/**
 * 
 * 包名称： com.win.dfas.common.config 
 * 类名称：MyBatisCondition 
 * 类描述：数据库配置判断
 * 创建人：@author hechengcheng 
 * 创建时间：2019年10月24日/下午2:45:31
 *
 */
class MyBatisCondition implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		return StrUtil.isNotEmpty(context.getEnvironment().getProperty("spring.datasource.url"));
	}
	
}
