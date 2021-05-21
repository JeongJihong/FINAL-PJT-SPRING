package com.ssafy.repository;

import java.util.List;
import java.util.Map;

import com.ssafy.dto.MemberDTO;

public interface MemberMapper {
	//회원 가입
	public void insertMember(MemberDTO member);
	
	//회원 조회
	public List<MemberDTO> searchAll(Map<String, Integer> map);
	public List<MemberDTO> searchAll();
	
	//로그인
	public MemberDTO login(Map<String, String> map);
	
	//회원정보 수정
	public void update(MemberDTO member);
	
	//회원 탈퇴
	public void delete(MemberDTO member);
	
	//회원 검색
	public MemberDTO searchId(String id);
	
	//비밀번호 검색
	public MemberDTO findPassword(MemberDTO member);
}
