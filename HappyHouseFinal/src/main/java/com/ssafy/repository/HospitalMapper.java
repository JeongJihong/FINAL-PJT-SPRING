package com.ssafy.repository;
import java.util.List;

import com.ssafy.dto.HospitalDTO;

public interface HospitalMapper {
	//동 내 병원 조회
	public List<HospitalDTO> searchAll(String dong);
}