package com.webapp.jee;

public class LoginService {

	public boolean isUserValid(String name, String psd) {
		return name.equals("soujanya") && psd.equals("soujanya");
	}
}
