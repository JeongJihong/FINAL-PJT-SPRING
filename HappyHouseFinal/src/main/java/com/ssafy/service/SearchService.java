package com.ssafy.service;

import java.util.List;

import com.ssafy.dto.HouseInfoDTO;
import com.ssafy.dto.InterestDTO;
import com.ssafy.dto.SidoGugunCodeDTO;

public interface SearchService {
//	// 동으로 전체 목록 검색
//	public List<EnvCheckDTO> searchAllEnvCheck(String dong);
	
//	// 동 내 병원 조회
//	public List<HospitalDTO> searchAllHospital(String dong);
	
//	// 검색
//	public List<HouseDeal> searchAllHouseDeal(HousePageBean housepagebean); 
//	public List<HouseDeal> searchHouseDealByAptName(HouseDeal houseDeal);
//	public List<HouseDeal> searchHouseDealByAptNameDong(HouseDeal houseDeal);
//	public HouseDeal searchHouseDeal(int no);
	
	//시군구 선택 
	List<SidoGugunCodeDTO> getSido();
	List<SidoGugunCodeDTO> getGugunInSido(String sido);
	List<HouseInfoDTO> getDongInGugun(String gugun);
	
	// 관심지역 추가
	public void insertInterest(InterestDTO interestDTO);
	
	// 관심지역 제거
	public void deleteInterest(InterestDTO interestDTO);
	
	// 관심지역 목록 조회
	public List<InterestDTO> searchAllInterest(String id);
}
