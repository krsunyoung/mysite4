package com.bit2016.mysite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit2016.mysite.repository.GuestbookDao;
import com.bit2016.mysite.vo.GuestbookVo;

@Controller
@RequestMapping( "/guestbook" )
public class GuestbookController {
	
	@Autowired
	private GuestbookDao guestbookDao;
	
	@RequestMapping( "" )
	public String index( Model model ){
		List<GuestbookVo> list = guestbookDao.getList();
		model.addAttribute( "list", list );
		return "guestbook/index";
	}
	
	@RequestMapping( "/deleteform/{no}" )
	public String deleteform( @PathVariable( "no" ) Long no, Model model ){
		model.addAttribute( "no", no );
		return "guestbook/deleteform";
	}
	
	@RequestMapping( value="/delete", method=RequestMethod.POST )
	public String delete( @ModelAttribute GuestbookVo vo ){
		guestbookDao.delete( vo );
		return "redirect:/guestbook";
	}
	
	@RequestMapping( value="/add", method=RequestMethod.POST )
	public String add( @ModelAttribute GuestbookVo vo ) {
		guestbookDao.insert(vo);
		return "redirect:/guestbook";
	}
}
