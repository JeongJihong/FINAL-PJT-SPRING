package com.ssafy.repository;

import java.util.List;

import com.ssafy.dto.HouseDeal;
import com.ssafy.dto.HousePageBean;

public interface HouseMapper {
	public void loadData();
	//개별 아파트 검색
	public HouseDeal search(int no); 
	//범위 검색
	public List<HouseDeal> searchAll(HousePageBean housepagebean); 
	//아파트 이름으로 검색
	public List<HouseDeal> searchByAptName(HouseDeal houseDeal);
	//아파트 이름과 동으로 검색
	public List<HouseDeal> searchByAptNameDong(HouseDeal houseDeal);
	
}
