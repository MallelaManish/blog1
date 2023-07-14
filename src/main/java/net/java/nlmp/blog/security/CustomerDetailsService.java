package net.java.nlmp.blog.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import net.java.nlmp.blog.exception.ResourceNotFoundException;
import net.java.nlmp.blog.model.User;
import net.java.nlmp.blog.repository.UserRepository;

@Service
public class CustomerDetailsService implements UserDetailsService {

	private UserRepository userRepository;

	public CustomerDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String usernameOremail) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepository.findByUsernameOrEmail(usernameOremail, usernameOremail).orElseThrow(
				() -> new UsernameNotFoundException("User not found with username or email: " + usernameOremail));

		Set<SimpleGrantedAuthority> authorities = user.getRoles().stream()
				.map((role) -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toSet());
		
		return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassowrd(),authorities);

	}

}
