package ar.edu.unju.edm.app.config;

import ar.edu.unju.edm.app.data.source.AuthServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthListener authListener;

    String[] resources = new String[] { "/include/**", "/css/**", "/icons/**", "/img/**", "/js/**", "/layer/**", "/webjars/**" };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/administration", "/accounts/edit!{ID}", "/accounts/delete!{ID}", "/points/new", "/points/edit!{ID}", "/points/delete!{ID}").hasAuthority("Administrator")
                .antMatchers("/staff", "/points/new", "/points/edit!{ID}", "/points/delete/{ID}").hasAuthority("Staff")
                .antMatchers("/explorer").hasAuthority("User")
                .antMatchers("/", "/planes", "/about").permitAll()
                .antMatchers("/accounts/new").permitAll() // Access Routes
                .antMatchers(resources).permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .successHandler(authListener)
                .failureUrl("/login?error")
                .usernameParameter("email")
                .passwordParameter("password")
                .and()
                .logout()
                .logoutUrl("/logout") // URL para cerrar sesión
                .logoutSuccessUrl("/login?logout") // URL a la que se redirige después de cerrar sesión
                .invalidateHttpSession(true) // Invalidar la sesión actual
                .permitAll()
                .logoutSuccessUrl("/")
                .and()
                .exceptionHandling().accessDeniedPage("/");
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(4);
    }

    @Autowired
    AuthServiceImpl accessDB;

}