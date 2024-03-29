package com.springexample.userRegandLoginSpringSecurity.security;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class SimpleAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		Collection <? extends GrantedAuthority> authorities = authentication.getAuthorities();
		
		logger.info(authorities.toString());
		
		authorities.forEach(authority -> {
			if(authority.getAuthority().equals("USER")) {
				try {
					redirectStrategy.sendRedirect(request, response, "/home/user/portal");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else if(authority.getAuthority().equals("ADMIN")) {
				try {
					redirectStrategy.sendRedirect(request, response, "/home/admin/portal");
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
	            throw new IllegalStateException();
	        }
		});
		
	}
}
