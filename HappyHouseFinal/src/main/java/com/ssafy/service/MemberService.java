package com.ssafy.service;

import java.util.List;
import java.util.Map;

import com.ssafy.dto.MemberDTO;

public interface MemberService {
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
	
	//비밀번호 찾기
	public MemberDTO findPassword(MemberDTO member);
}
