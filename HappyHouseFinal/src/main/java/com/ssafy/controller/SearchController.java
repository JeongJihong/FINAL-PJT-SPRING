package com.ssafy.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.dto.HouseDeal;
import com.ssafy.dto.HouseInfoDTO;
import com.ssafy.service.SearchService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@Api("HappyHouse Search 컨트롤러 API V1")
@RequestMapping("/search")
public class SearchController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	SearchService searchService;
	
	@ApiOperation(value = "검색어(아파트 이름)를 받아 아파트 매매 정보를 반환한다.", response = Map.class)
	@GetMapping("/aptname/{text}")
	private ResponseEntity<Map<String, Object>> searchByAptName(@PathVariable String text) {
		logger.debug("search by aptName");
		HouseDeal deal = new HouseDeal();
		deal.setAptName(text);
		
		Map<String, Object> result = new HashMap<String, Object>();
		List<HouseDeal> list = searchService.searchHouseDealByAptName(deal);
		result.put("housedeal", list);
		result.put("envcheck", null);
		result.put("hospitaldata", null);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@ApiOperation(value = "동 이름을 받아 아파트 매매 정보 / 환경 점검 정보 / 병원 정보를 반환한다.", response = Map.class)
	@GetMapping("/dong/{text}")
	private ResponseEntity<Map<String, Object>> searchByDong(@PathVariable String text) {
		logger.debug("dong: " + text);
		List<HouseInfoDTO> infoList = null;
		List<HouseDeal> list = new ArrayList<HouseDeal>();
		Map<String, Object> result = new HashMap<String, Object>();
		
		try {
			infoList = searchService.getAptInDong(text);
			for(HouseInfoDTO item : infoList) {
				HouseDeal deal = new HouseDeal();
				deal.setAptName(item.getAptName());
				deal.setDong(item.getDong());
				
				List<HouseDeal> tmp = searchService.searchHouseDealByAptNameDong(deal);
				for(HouseDeal t : tmp) {
					list.add(t);
				}
			}
			
			result.put("houseinfo", infoList);
			result.put("housedeal", list);
			result.put("envcheck", searchService.searchAllEnvCheck(text));
			result.put("hospitaldata", searchService.searchAllHospital(text));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@ApiOperation(value = "관심 정보(동 이름)을 받아 아파트 매매 정보 / 환경 점검 정보 / 병원 정보를 반환한다.", response = Map.class)
	@GetMapping("/interest/{text}")
	private ResponseEntity<Map<String, Object>> searchByInterest(@PathVariable String text) {
		logger.debug("interest: " + text);
		List<HouseInfoDTO> infoList = null;
		List<HouseDeal> list = new ArrayList<HouseDeal>();
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			infoList = searchService.getAptInDong(text);
			for(HouseInfoDTO item : infoList) {
				HouseDeal deal = new HouseDeal();
				deal.setAptName(item.getAptName());
				deal.setDong(item.getDong());
				
				List<HouseDeal> tmp = searchService.searchHouseDealByAptNameDong(deal);
				for(HouseDeal t : tmp) {
					list.add(t);
				}
			}
			
			result.put("houseinfo", infoList);
			result.put("housedeal", list);
			result.put("envcheck", searchService.searchAllEnvCheck(text));
			result.put("hospitaldata", searchService.searchAllHospital(text));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
