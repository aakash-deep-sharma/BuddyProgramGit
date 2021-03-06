package org.onlineshoppingportal.config;

import org.apache.log4j.Logger;
import org.onlineshoppingportal.authentication.MyDBAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
 
	   public static Logger logger = Logger.getLogger(WebSecurityConfig.class);
	   
	   @Autowired
	   MyDBAuthenticationService myDBAauthenticationService;
	 
	   @Autowired
	   public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	       // For User in database.
	       auth.userDetailsService(myDBAauthenticationService).passwordEncoder(bCryptPasswordEncoder());
	 
	   }
	   @Bean
	   public BCryptPasswordEncoder bCryptPasswordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	 
	    @Autowired
	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(myDBAauthenticationService).passwordEncoder(bCryptPasswordEncoder());
	    }
	 
	   @Override
	   protected void configure(HttpSecurity http) throws Exception {
	 
	       http.csrf().disable();
	 
	       // The pages requires login as EMPLOYEE or MANAGER.
	       // If no login, it will redirect to /login page.
	       http.authorizeRequests().antMatchers("/orderList","/buyProduct", "/orderList")//
	               .access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");
	 
	       /*http.authorizeRequests().antMatchers("/css/**", "/signUp").permitAll();*/
	       // When the user has logged in as XX.
	       // But access a page that requires role YY,
	       // AccessDeniedException will throw.
	       http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
	 
	       // Config for Login Form
	       http.authorizeRequests().and().formLogin()//
	               // Submit URL of login page.
	               .loginProcessingUrl("/j_spring_security_check") // Submit URL
	               .loginPage("/login")//
	               .defaultSuccessUrl("/")//
	               .failureUrl("/login?error=true")//
	               .usernameParameter("userName")//
	               .passwordParameter("password")
	               // Config for Logout Page
	               // (Go to home page).
	               .and().logout().logoutUrl("/logout").logoutSuccessUrl("/");
	       if(logger.isInfoEnabled())
	        	logger.info("Web security configured");
	 
	   }
	   
	   @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	   @Override
	   public AuthenticationManager authenticationManagerBean() throws Exception {
	       return super.authenticationManagerBean();
	   }
}
