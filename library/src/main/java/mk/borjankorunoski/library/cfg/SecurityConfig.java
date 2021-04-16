package mk.borjankorunoski.library.cfg;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/**").permitAll()
                .and().httpBasic()
                .and().formLogin()
                .and().logout().permitAll().invalidateHttpSession(true).deleteCookies("JSESSIONID").deleteCookies("SESSION")
                .and().csrf().disable();
        http.headers().frameOptions().disable();
    }
}
