package com.bit2016.mysite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit2016.mysite.service.GalleryService;

@Controller
@RequestMapping( "/gallery" )
public class GalleryController {
	
	@Autowired
	private GalleryService galleryService;  
	
	@RequestMapping( "" )
	public String index(){
		return "gallery/index";
	}
	
	@ResponseBody
	@RequestMapping( value="/upload", method=RequestMethod.POST )
	public String upload(){
		return "upload를 합니다.";
	}
	
}
