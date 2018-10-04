package ex1.mb.config;

import ex1.mb.controller.Message;
import ex1.mb.service.CreateTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource(value = "classpath:util.properties")

public class AppConfig {
    @Autowired
    private Environment environment;


  /*  @Bean
    public Message message(){
        return  new Message("Bean from annonation");
    }*/
  @Bean
  public DriverManagerDataSource dataSource() {
      DriverManagerDataSource dataSource = new DriverManagerDataSource();
      dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.postgresql.driver"));
      dataSource.setUrl(environment.getRequiredProperty("jdbc.postgresql.url"));
      dataSource.setUsername(environment.getRequiredProperty("jdbc.postgresql.user"));
      dataSource.setPassword(environment.getRequiredProperty("jdbc.postgresql.password"));
      return dataSource;
  }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }

    @Bean
    public CreateTable createTable() {
        return new CreateTable(jdbcTemplate());
    }
}
