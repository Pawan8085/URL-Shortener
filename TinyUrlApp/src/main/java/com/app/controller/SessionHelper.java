package com.app.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


import jakarta.servlet.http.HttpSession;

@Component
public class SessionHelper {
	
		
	public void removeURLFromSession() {
		try {
			
			HttpSession session = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
			session.removeAttribute("url");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void removeOriginalURLFromSession() {
		try {
			
			HttpSession session = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
			session.removeAttribute("originalUrl");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void removeErrorFromSession() {
		try {
			
			HttpSession session = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
			session.removeAttribute("error");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
