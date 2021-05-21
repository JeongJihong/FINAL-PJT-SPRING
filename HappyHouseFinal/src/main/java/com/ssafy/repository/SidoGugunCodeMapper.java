package com.ssafy.repository;

import java.util.List;

import com.ssafy.dto.HouseInfoDTO;
import com.ssafy.dto.SidoGugunCodeDTO;

public interface SidoGugunCodeMapper {
	
	public List<SidoGugunCodeDTO> getSido();
	
	public List<SidoGugunCodeDTO> getGugunInSido(String sido);
	
	public List<HouseInfoDTO> getDongInGugun(String gugun);
}
