package ex1.mb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**").access("hasRole('ADMIN')")//имеет доступ только admin
                .antMatchers("/").permitAll()  //имеют доступ все
                .and().csrf().disable().formLogin().defaultSuccessUrl("/", false);        //вводится страничка для введения пароля и тд
        //и переход на страничку
    }


    //  не использ в production,настройка авторизации
    // по пользователям, по ролям из памяти
/*    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
    }*/
// получение пользователя из БД
        @Override
        public void configure(AuthenticationManagerBuilder auth) throws Exception {



    }
}