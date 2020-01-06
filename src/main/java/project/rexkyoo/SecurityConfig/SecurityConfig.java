package project.rexkyoo.SecurityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

// JV, MG, TA

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private DataSource datasource;

    @Value("${spring.queries.admin-query}")
    private String adminQuery;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.
                jdbcAuthentication()
                .usersByUsernameQuery(adminQuery).authoritiesByUsernameQuery(adminQuery)
                .dataSource(datasource)
                .passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.
                authorizeRequests()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/JavaScript/**").permitAll()
                .antMatchers("/images/**").permitAll()
                .antMatchers("/admin/login").permitAll()
                .antMatchers("/dk/**").permitAll()
                .anyRequest()
                .authenticated().and().csrf().disable()
                .formLogin()
                .loginPage("/admin/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/admin/home", true)
                .and().logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/admin/login").and().exceptionHandling()
                .accessDeniedPage("/admin/denied");
    }

}
