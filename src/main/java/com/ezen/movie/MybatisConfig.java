package com.ezen.movie;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@MapperScan(basePackages = "com.ezen.movie.mapper")
public class MybatisConfig {
	@Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setTypeAliasesPackage("com.ezen.movie.service");
        
        // Enable snake_case to camelCase mapping
        org.apache.ibatis.session.Configuration mybatisConfig = new org.apache.ibatis.session.Configuration();
        mybatisConfig.setMapUnderscoreToCamelCase(true);
        sessionFactory.setConfiguration(mybatisConfig);
        
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactory.setMapperLocations(resolver.getResources("mapper/*.xml"));
        return sessionFactory.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception {
        final SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
        return sqlSessionTemplate;
    }
    
    @Bean
    public DataSource dataSource()
    {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        String PASSWORD = "DB_DECRYPT_KEY";
        String dbDecryptKey = System.getenv(PASSWORD);
        encryptor.setPassword(dbDecryptKey);
        
		String DbPw = encryptor.decrypt("jHTcCCz4qn3s6TlKWPlUnEkcui/yT1dK");
        dataSourceBuilder.driverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
        dataSourceBuilder.url("jdbc:log4jdbc:mysql://mysql.cnewsfhi3ek0.ap-northeast-2.rds.amazonaws.com:3306/mysql_ssjy");
        dataSourceBuilder.username("mysql_ssyj");
        dataSourceBuilder.password(DbPw);
        return dataSourceBuilder.build();
    }
}
