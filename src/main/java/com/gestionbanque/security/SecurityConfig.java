// package com.gestionbanque.security;

// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig /*extends WebSecurityAdapter*/{
// 	//@Override
// 	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		
// 		auth.inMemoryAuthentication().withUser("admin").password("<PASSWORD>").roles("ADMIN");
//         auth.inMemoryAuthentication().withUser("user").password("<PASSWORD>").roles("USER");
		
// 	}

//     @Override
//     protected void configure(HttpSecurity http) throws Exception {
//         http.formLogin()
//     }
// }
