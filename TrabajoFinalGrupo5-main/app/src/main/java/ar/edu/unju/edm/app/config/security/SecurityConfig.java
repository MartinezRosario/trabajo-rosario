package ar.edu.unju.edm.app.config.security;

import ar.edu.unju.edm.app.config.auth.AuthenticationSuccess;
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
@Deprecated
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationSuccess authenticationSuccess;

    String[] resources = new String[] { "/include/**", "/css/**", "/icons/**", "/img/**", "/js/**", "/layer/**", "/webjars/**" };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/administration").hasAuthority("Administrator")
                .antMatchers("/staff", "/points/new", "/points/edit!{ID}", "/points/delete!{ID}").hasAnyAuthority("Staff", "Administrator")
                .antMatchers("/accounts/edit!{ID}", "/points/details!{ID}", "/points/comment", "/points/review").hasAnyAuthority("User", "Staff", "Administrator")
                .antMatchers("/", "/explorer", "/planes", "/about").permitAll()
                .antMatchers("/accounts/new").permitAll() // Access Routes
                .antMatchers(resources).permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .successHandler(authenticationSuccess)
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

    /*@Autowired
    public void globalConfig(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(accessDB);
    }*/

}