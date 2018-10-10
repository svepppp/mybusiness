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
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

@Configuration
@PropertySource(value = "classpath:util.properties")
@PropertySource(value = "classpath:auth.properties")
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
    public UserDetailsService userDetailsService(){
        JdbcDaoImpl jdbcDao=new JdbcDaoImpl();
        jdbcDao.setDataSource(dataSource());    // из  jdbcTemplate()
        jdbcDao.setUsersByUsernameQuery();   //пользователь и пароль
        jdbcDao.setAuthoritiesByUsernameQuery(); //роль данного пользователя
        return jdbcDao;
    }



    @Bean
    public CreateTable createTable() {
        return new CreateTable(jdbcTemplate());
    }
}
