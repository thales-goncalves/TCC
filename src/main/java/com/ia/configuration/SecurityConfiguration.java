package com.ia.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ia.web.repositories.UserRepository;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserRepository userRepository; 
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");

	}
	
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {

	final String login = "/login";

	http.authorizeRequests()

		.antMatchers(HttpMethod.GET, "/**").permitAll()
		.antMatchers(HttpMethod.POST, "/**").permitAll()
		.anyRequest().authenticated()
		.and().formLogin().loginPage(login)
		.defaultSuccessUrl("/home")
		.failureUrl("/login?error").permitAll();

/*	http.exceptionHandling()
		.authenticationEntryPoint(new ContinueEntryPoint(login))
		.and()
			.authenticationProvider(ldapAndDbAuthenticationProvider)
			.authorizeRequests()
			.antMatchers(login)
			.anonymous().anyRequest().authenticated()
		.and()
        		.formLogin()
        		.loginPage(login)
        		.defaultSuccessUrl("/home")
        		.failureUrl("/login?error")
		.and()
			.logout().logoutSuccessUrl("/login?logout")
		.and()
        		.exceptionHandling()
        		.accessDeniedPage("/denied");
*/
    }
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userRepository)
			.passwordEncoder(new BCryptPasswordEncoder());
	}

}
