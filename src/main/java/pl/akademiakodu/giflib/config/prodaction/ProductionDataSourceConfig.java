package pl.akademiakodu.giflib.config.prodaction;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import pl.akademiakodu.giflib.config.dev.DevDataSourceConfig;

import javax.sql.DataSource;

/**
 * Created by Camillo on 19.11.2016.
 */

@PropertySource("prot.properties")
@Configuration
@Profile("prot")
public class ProductionDataSourceConfig {
    private Logger loger = LoggerFactory.getLogger(ProductionDataSourceConfig.class);
    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource(){
        loger.info(env.getProperty("giflib.db.log2"));
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName(env.getProperty("giflib.db.Driver"));
        basicDataSource.setUrl(env.getProperty("giflib.db.url"));
        basicDataSource.setUsername(env.getProperty("giflib.db.username"));
        basicDataSource.setPassword(env.getProperty("giflib.db.password"));
        return basicDataSource;
    }
}
