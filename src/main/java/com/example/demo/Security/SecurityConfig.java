package com.example.demo.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers("/login", "/admin/**", "/upload/**").permitAll();// tous permet creer login
                                                                                              // et register
        http.authorizeRequests().antMatchers("/appUsers/**", "/appRoles/**").permitAll();//
        // http.authorizeRequests().antMatchers("/user/**").hasAuthority("ADMIN");//

        http.authorizeRequests().antMatchers("/chauffeur/**").permitAll();
        http.authorizeRequests().antMatchers("/chauffeur/add").permitAll();
        http.authorizeRequests().antMatchers("/avis/**").hasAuthority("PASSAGER");

        http.authorizeRequests().antMatchers("/model/**").permitAll();

        http.authorizeRequests()
                .antMatchers("/res/reservations", "/res/validerreservation/**", "/res/resrvationaccepter/**",
                        "/res/reservationenattend/**", "/res/deleteresrvation/**", "/res/deleteresrvationnovalid/**")
                .permitAll();
        http.authorizeRequests().antMatchers("/res/limitreservation/**").hasAuthority("PASSAGER");
        http.authorizeRequests().antMatchers("/categorie/**").permitAll();
        http.authorizeRequests().antMatchers("/user/**").permitAll();
        http.authorizeRequests().antMatchers("/image/**").permitAll();
        http.authorizeRequests().antMatchers("/produit/**").permitAll();
        http.authorizeRequests().antMatchers("/annonce/get/recherchannonce").permitAll();
        http.authorizeRequests().antMatchers("/annonce/add/**").hasAuthority("CONDUCTEUR");
        http.authorizeRequests().antMatchers("/annonce/edit/**").hasAuthority("CONDUCTEUR");
        http.authorizeRequests().antMatchers("/voitur/**").permitAll();
        http.authorizeRequests().antMatchers("/reclamation/**").permitAll();

        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(new JWTAuthenticationFilter(authenticationManager()));
        http.addFilterBefore(new JWTAuthorizationFiler(), UsernamePasswordAuthenticationFilter.class);

    }

}

// li y5allini net7akem fi droit d'accées , generer l'autorité selon les roles
