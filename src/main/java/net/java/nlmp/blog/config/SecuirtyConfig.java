package net.java.nlmp.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecuirtyConfig {
	
	private UserDetailsService userDetailsService;
	
	public SecuirtyConfig(UserDetailsService userDetailsService) {
		// TODO Auto-generated constructor stub
		this.userDetailsService = userDetailsService;
	}
	
	@Bean
	public static PasswordEncoder password() {
		return new BCryptPasswordEncoder();
	}


	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http.csrf().disable().authorizeHttpRequests(
//				(authorize) -> authorize.anyRequest().authenticated())
//				.httpBasic(Customizer.withDefaults());
		// enabling basic authentication and turning off form a
		
		http.csrf().disable().authorizeHttpRequests(
				(authorize) -> authorize.requestMatchers(HttpMethod.GET, "/api/**").permitAll()
				.anyRequest().authenticated())
				.httpBasic(Customizer.withDefaults());

		return http.build();
	}

	//in memory authentication
//	@Bean
//	public UserDetailsService userDetailsService() {
//		UserDetails manish = User.builder().username("Manish").password(password().encode("laxmi")).roles("ADMIN").build();
//		UserDetails laxmi = User.builder().username("laxmi").password(password().encode("laxmi")).roles("ADMIN").build();
//		UserDetails priya = User.builder().username("priya").password(password().encode("priya")).roles("USER").build();
//		return new InMemoryUserDetailsManager(manish, laxmi, priya);
//
//	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception{
		return configuration.getAuthenticationManager();
	}
	
	
	


}
