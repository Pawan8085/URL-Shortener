package com.app.service;

import com.app.entity.UrlData;

public interface AppService {
	
	
	/**
	 * 
	 * @param url -> original url link to make shorter
	 * @return -> shorter url link
	 */
	String saveUrl(String url)throws Exception;
	
	/**
	 * 
	 * @param shortUrl -> shorter url link to find original url
	 * @return -> original url link
	 */
	UrlData getOriginalUrl(String shortUrl)throws Exception;
	
}
