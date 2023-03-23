package com.jedisebas.restapi;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class PropertySourceResolver {

    @Value("${spring.datasource.url}")
    private String springDatasourceUrl;

    @Value("${spring.datasource.driverClassName}")
    private String springDatasourceDriverClassName;

    @Value("${spring.datasource.username}")
    private String springDatasourceUsername;

    @Value("${spring.datasource.password}")
    private String springDatasourcePassword;

    @Value("${spring.jpa.database-platform}")
    private String springJpaDatabasePlatform;

    @Value("${spring.h2.console.enabled}")
    private String springH2ConsoleEnabled;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String springJpaHibernateDdlAuto;

    @Value("${spring.jpa.show-sql}")
    private String springJpaShowSql;

    @Value("${spring.jpa.properties.hibernate.dialect}")
    private String springJpaPropertiesHibernateDialect;


}
