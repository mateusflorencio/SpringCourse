package com.florencio.springcourse.services;

import org.springframework.security.core.context.SecurityContextHolder;

import com.florencio.springcourse.security.UserSS;

public class UserService {

	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal(); // método pradrão
		} catch (Exception e) {
			return null;
		}
	}
	

}
