package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.UrlData;

public interface UrlDataRepo extends JpaRepository<UrlData, String>{

}
