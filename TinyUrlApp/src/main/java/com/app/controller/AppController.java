package com.app.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.app.entity.UrlData;
import com.app.service.AppService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AppController {

	
	
	@Autowired
	private AppService appService;
	
	
	
	@GetMapping("/home/page")
	public String home() {
		
		return "index";
	}
	
	@PostMapping("/url-post-process")
    public String processUrl(@RequestParam("url") String url, HttpSession session) throws Exception {
        
      
		try {
			String shortUrl = appService.saveUrl(url);
			session.setAttribute("url", shortUrl);
			session.setAttribute("originalUrl", url);
		} catch (Exception e) {
			session.setAttribute("error", e.getMessage());
		}
        return "index";
	}
	
	
	@GetMapping("/error/{message}")
	public String error(@PathVariable String message, HttpSession session) {
		
		session.setAttribute("error", message);
		
		return "error";
	}
	
	
	@GetMapping("/tiny/{uniqueCode}")
    public RedirectView redirectToOriginalUrl(@PathVariable String uniqueCode) {
		
	      try {
	    	  UrlData data = appService.getOriginalUrl(uniqueCode);
	          String originalUrl = data.getOriginalUrl();

	          return new RedirectView(originalUrl);
		} catch (Exception e) {
			return new RedirectView("/error/"+e.getMessage());
		}
    }
    
	
    
}
