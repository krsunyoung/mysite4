package com.bit2016.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2016.mysite.repository.GuestbookDao;
import com.bit2016.mysite.vo.GuestbookVo;

@Service
public class GuestbookService {
	
	@Autowired
	private GuestbookDao guestbookDao;
	
	public List<GuestbookVo> getMessageList() {
		return guestbookDao.getList();
	}

	public List<GuestbookVo> getMessageList( int page ) {
		return guestbookDao.getList( page );
	}
	
	public boolean deleteMessage( GuestbookVo vo ){
		int count = guestbookDao.delete( vo );
		return count == 1;
	}
	
	public GuestbookVo writeMessage( GuestbookVo vo, boolean fetch ) {
		GuestbookVo guestbookVo = null;
		
		Long no = guestbookDao.insert(vo);
		if( fetch ) {
			guestbookVo = guestbookDao.get( no );
		}
		
		return guestbookVo;
	}
}