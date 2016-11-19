package pl.akademiakodu.giflib.config;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;

/**
 * Created by trojan on 19.11.16.
 */
@PropertySource("app.properties")
@Configuration
public class DataConfig {
    @Autowired
    private Environment env;

    @Autowired
    private DataSource dataSource;
    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        Resource config = new ClassPathResource("hibernate.cfg.xml");
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setConfigLocation(config);
        factoryBean.setDataSource(dataSource);
        factoryBean.setPackagesToScan(env.getProperty("giflib.entity.package"));
        return factoryBean;
    }


}
