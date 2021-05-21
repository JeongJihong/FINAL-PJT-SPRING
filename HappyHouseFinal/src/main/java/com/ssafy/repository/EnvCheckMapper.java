package com.ssafy.repository;

import java.util.List;

import com.ssafy.dto.EnvCheckDTO;

public interface EnvCheckMapper {
	// 동으로 전체 목록 검색
	public List<EnvCheckDTO> searchAll(String dong);
	
}
