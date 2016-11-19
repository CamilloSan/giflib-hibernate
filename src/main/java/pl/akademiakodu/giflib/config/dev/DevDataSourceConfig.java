package pl.akademiakodu.giflib.config.dev;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * Created by Camillo on 19.11.2016.
 */
@PropertySource("dev.properties")
@Configuration
@Profile("dev")
public class DevDataSourceConfig {

    private Logger loger = LoggerFactory.getLogger(DevDataSourceConfig.class);

    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource(){
        loger.info(env.getProperty("giflib.db.log"));
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName(env.getProperty("giflib.db.Driver"));
        basicDataSource.setUrl(env.getProperty("giflib.db.url"));
        basicDataSource.setUsername(env.getProperty("giflib.db.username"));
        basicDataSource.setPassword(env.getProperty("giflib.db.password"));
        basicDataSource.setUrl("jdbc:h2:mem:giflib:USER=giflib;PASSWORD=test");
        return basicDataSource;
    }

}
