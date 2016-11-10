package com.bit2016.mysite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2016.mysite.repository.GalleryDao;

@Service
public class GalleryService {
	
	@Autowired
	private GalleryDao galleryDao;
}
