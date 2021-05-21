package com.ssafy.repository;

import java.util.List;
import java.util.Map;

import com.ssafy.dto.InterestDTO;

public interface InterestMapper {
	// 관심지역 추가
	public void insertInterest(InterestDTO interrestDTO);
	
	// 관심지역 제거
	public void deleteInterest(InterestDTO interrestDTO);
	
	// 관심지역 목록 조회
	public List<InterestDTO> searchAll(String id);
}
