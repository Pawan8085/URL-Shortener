package com.app.service;


import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.app.entity.UrlData;
import com.app.repo.UrlDataRepo;

@Service
public class AppServiceImpl implements AppService {
	
	@Autowired
	private UrlDataRepo urlDataRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public String saveUrl(String url)throws Exception {
		
		if(url.equals("")) throw new Exception("Empty link ! please enter any link");
		
		// add prefix https if it is not there in url
		if (!url.startsWith("https://")) {
			
			url = "https://" + url;
        }
		
		
		
		String unique = unique();
		
		Optional<UrlData> optUrlData = urlDataRepo.findById(unique);
		
		while(optUrlData.isPresent()) {
			unique = unique();
		}
		
		
		UrlData data = new UrlData();
		data.setShortUrl(unique);
		data.setOriginalUrl(url);
		
		urlDataRepo.save(data);
		
		
		return "localhost:8080/tiny/"+unique;
		
		
		
	}

	@Override
	public UrlData getOriginalUrl(String shortUrl) throws Exception {
		
		Optional<UrlData> optUrlData = urlDataRepo.findById(shortUrl);
		
		
		UrlData data = null;
		if(optUrlData.isPresent()) {
			data = optUrlData.get();
		}else {
			throw new Exception("Enter a valid url !");
		}
		
		
		
		return data;
		
			
	}
	
	// method to generate unique string 
	private String unique(){

        Random r = new Random();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<6; ++i){

            int choice = r.nextInt(2);
            if(choice == 0){
               choice = r.nextInt(2);
               int index = r.nextInt(26);
               if(choice == 0){
                   sb.append((char) ('a'+index));
               }else{
                  sb.append((char) ('A'+index));
               }
            }else{
                int num = r.nextInt(10);
                sb.append(num+"");
            }
        }
        
        return sb.toString();
    }
	
	


}
