package com.vmware.task.vmware.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;


@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter
{
    @Autowired
    ClientRegistrationRepository clientRegistrationRepository;


    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http
            .authorizeRequests()
            .antMatchers("/", "/error", "/webjars/**").permitAll()
            .anyRequest().authenticated()
            .and()
            .exceptionHandling(e -> e.authenticationEntryPoint(new Http403ForbiddenEntryPoint()))
            .logout()
            .logoutSuccessUrl("/")
            .invalidateHttpSession(true)
            .clearAuthentication(true)
            .deleteCookies("JSESSIONID")
            .permitAll()
            .and()
            .oauth2Login()
            .successHandler(successHandler());

        http.csrf(c -> c.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()));
    }



    private SimpleUrlAuthenticationSuccessHandler successHandler()
    {
        return new SimpleUrlAuthenticationSuccessHandler("/calculator");
    }
}
