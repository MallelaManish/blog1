package net.java.nlmp.blog.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordGeneratorEncode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PasswordEncoder passowordEncoder = new BCryptPasswordEncoder();
		System.out.println(passowordEncoder.encode("laxmi"));
	}

}
