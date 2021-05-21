package com.ssafy.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.dto.MemberDTO;
import com.ssafy.repository.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insertMember(MemberDTO member) {
		sqlSession.getMapper(MemberMapper.class).insertMember(member);
		
	}

	@Override
	public List<MemberDTO> searchAll(Map<String, Integer> map) {
		Map<String, Integer> param = new HashMap<String, Integer>();
		int currentPage = map.get("pg");
		int sizePerPage = map.get("spp");
		int start = (currentPage - 1) * sizePerPage;
		param.put("start", start);
		param.put("spp", sizePerPage);
		return sqlSession.getMapper(MemberMapper.class).searchAll(map);
	}

	@Override
	public List<MemberDTO> searchAll() {
		return sqlSession.getMapper(MemberMapper.class).searchAll();
	}

	@Override
	public MemberDTO login(Map<String, String> map) {
		if(map.get("id") == null || map.get("password") == null)
			return null;
		
		return sqlSession.getMapper(MemberMapper.class).login(map);
	}

	@Override
	public void update(MemberDTO member) {
		sqlSession.getMapper(MemberMapper.class).update(member);

	}

	@Override
	public void delete(MemberDTO member) {
		sqlSession.getMapper(MemberMapper.class).delete(member);
		
	}
	
	@Override
	public MemberDTO searchId(String id) {
		return sqlSession.getMapper(MemberMapper.class).searchId(id);
		
	}
	
	@Override
	public MemberDTO findPassword(MemberDTO member) {
		return sqlSession.getMapper(MemberMapper.class).findPassword(member);
	}

}
