package com.jedisebas.restapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PropertySourceResolverTest {

    @Autowired
    private PropertySourceResolver resolver;

    @Test
    void shouldTestResourceFile_overridePropertyValues() {
        assertEquals("org.h2.Driver", resolver.getSpringDatasourceDriverClassName());
        assertEquals("sa", resolver.getSpringDatasourceUsername());
        assertEquals("password", resolver.getSpringDatasourcePassword());
        assertEquals("org.hibernate.dialect.H2Dialect", resolver.getSpringJpaDatabasePlatform());
        assertEquals("true", resolver.getSpringH2ConsoleEnabled());
        assertEquals("update", resolver.getSpringJpaHibernateDdlAuto());
        assertEquals("true", resolver.getSpringJpaShowSql());
        assertEquals("org.hibernate.dialect.H2Dialect", resolver.getSpringJpaPropertiesHibernateDialect());
    }
}