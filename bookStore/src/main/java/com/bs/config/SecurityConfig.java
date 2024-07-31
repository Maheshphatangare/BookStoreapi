package com.bs.config;

import org.springframework.context.annotation.Configuration;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnable = true)

public class SecurityConfig {
	
	@Bean
             public UserDetailsService userDetailsService() {
            UserDetails user	= User.withUsername("user").password(passwordEncoder().encode("1234")).roles("USER").build();
            UserDetails admin	= User.withUsername("admin").password(passwordEncoder().encode("1234")).roles("ADMIN").build();
             
             return new InMemoryUserDetailsManager(user,admin); 
             }
             @Bean
             public PasswordEncoder passwordEncoder()
             {
            	 return new BCryptPasswordEncoder();
             }
             @Bean
             public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
             {
            	   http.csrf().disable().authorizeHttprequests().anyRequest().authenticated().and().formLogin(); //httpBasic();
                    return http.build();
             }}
             
}
