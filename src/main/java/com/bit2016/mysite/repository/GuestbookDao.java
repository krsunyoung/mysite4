package com.bit2016.mysite.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StopWatch;

import com.bit2016.mysite.vo.GuestbookVo;

@Repository
public class GuestbookDao {
	@Autowired
	private SqlSession sqlSession;
	
	public int delete(GuestbookVo vo) {
		return sqlSession.delete( "guestbook.delete", vo );
	}
	
	public Long insert(GuestbookVo vo ) {
		sqlSession.insert( "guestbook.insert", vo );
		return vo.getNo();
	}
	
	public GuestbookVo get( Long no ) {
		return sqlSession.selectOne( "guestbook.getByNo", no ); 
	}
	
	public List<GuestbookVo> getList() {
		return sqlSession.selectList( "guestbook.getList" );
	}
	
	public List<GuestbookVo> getList( Integer page ) {
		return sqlSession.selectList( "guestbook.getListByPage", page );
	}
	
}
