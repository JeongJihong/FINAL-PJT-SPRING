package com.ssafy.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.dto.HospitalDTO;
import com.ssafy.dto.HouseDeal;
import com.ssafy.dto.HouseInfoDTO;
import com.ssafy.dto.HousePageBean;
import com.ssafy.dto.InterestDTO;
import com.ssafy.dto.SidoGugunCodeDTO;
import com.ssafy.repository.HospitalMapper;
import com.ssafy.repository.HouseMapper;
import com.ssafy.repository.InterestMapper;
import com.ssafy.repository.SidoGugunCodeMapper;

@Service
public class SearchServiceImpl implements SearchService{

	@Autowired
	private SqlSession sqlSession;
	
//	@Override
//	public List<EnvCheckDTO> searchAllEnvCheck(String dong) {
//		return sqlSession.getMapper(EnvCheckMapper.class).searchAll(dong);
//	}

	@Override
	public List<HospitalDTO> searchAllHospital(String dong) {
		return sqlSession.getMapper(HospitalMapper.class).searchAll(dong);
	}

//	@Override
//	public List<HouseDeal> searchAllHouseDeal(HousePageBean housepagebean) {
//		return sqlSession.getMapper(HouseMapper.class).searchAll(housepagebean);
//	}
//
//	@Override
//	public List<HouseDeal> searchHouseDealByAptName(HouseDeal houseDeal) {
//		return sqlSession.getMapper(HouseMapper.class).searchByAptName(houseDeal);
//	}
//
//	@Override
//	public List<HouseDeal> searchHouseDealByAptNameDong(HouseDeal houseDeal) {
//		return sqlSession.getMapper(HouseMapper.class).searchByAptNameDong(houseDeal);
//	}
//
//	@Override
//	public HouseDeal searchHouseDeal(int no) {
//		return sqlSession.getMapper(HouseMapper.class).search(no);
//	}

	@Override
	public List<SidoGugunCodeDTO> getSido() {
		return sqlSession.getMapper(SidoGugunCodeMapper.class).getSido();
	}

	@Override
	public List<SidoGugunCodeDTO> getGugunInSido(String sido) {
		return sqlSession.getMapper(SidoGugunCodeMapper.class).getGugunInSido(sido);
	}

	@Override
	public List<HouseInfoDTO> getDongInGugun(String gugun) {
		return sqlSession.getMapper(SidoGugunCodeMapper.class).getDongInGugun(gugun);
	}

	@Override
	public void insertInterest(InterestDTO interestDTO) {
		sqlSession.getMapper(InterestMapper.class).insertInterest(interestDTO);
	}

	@Override
	public void deleteInterest(InterestDTO interestDTO) {
		sqlSession.getMapper(InterestMapper.class).deleteInterest(interestDTO);
	}

	@Override
	public List<InterestDTO> searchAllInterest(String id) {
		return sqlSession.getMapper(InterestMapper.class).searchAll(id);
	}
}
