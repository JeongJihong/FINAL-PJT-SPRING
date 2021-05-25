package com.ssafy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.dto.HouseInfoDTO;
import com.ssafy.dto.InterestDTO;
import com.ssafy.dto.SidoGugunCodeDTO;
import com.ssafy.service.SearchService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api("HappyHouse HouseMap 컨트롤러 API V1")
@RequestMapping("/map")
public class HouseMapController {
	private static final long serialVersionUID = 1L;
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	SearchService searchService;
	
	@ApiOperation(value = "시도 목록을 반환한다.", response = List.class)
	@GetMapping("/sido")
	private ResponseEntity<List<Map<String, String>>> searchSido() {
		List<Map<String, String>> result = new ArrayList<Map<String, String>>();
		List<SidoGugunCodeDTO> list = null;
		try {
			list = searchService.getSido();
			for(SidoGugunCodeDTO dto : list) {
				Map<String, String> obj = new HashMap<String, String>();
				obj.put("sido_code", dto.getSidoCode());
				obj.put("sido_name", dto.getSidoName());
				result.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@ApiOperation(value = "시도 코드를 받아 구군 목록을 반환한다.", response = List.class)
	@GetMapping("/gugun/{text}")
	private ResponseEntity<List<Map<String, String>>> searchGugun(@PathVariable String text) {
		List<Map<String, String>> result = new ArrayList<Map<String, String>>();
		List<SidoGugunCodeDTO> list = null;
		try {
			list = searchService.getGugunInSido(text);
			for(SidoGugunCodeDTO dto : list) {
				Map<String, String> obj = new HashMap<String, String>();
				obj.put("gugun_code", dto.getGugunCode());
				obj.put("gugun_name", dto.getGugunName());
				result.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@ApiOperation(value = "구군 코드를 받아 동 목록을 반환한다.", response = List.class)
	@GetMapping("/dong/{text}")
	private ResponseEntity<List<Map<String, String>>> searchDong(@PathVariable String text) {
		List<Map<String, String>> result = new ArrayList<Map<String, String>>();
		List<HouseInfoDTO> list = null;
		try {
			list = searchService.getDongInGugun(text);
			for(HouseInfoDTO dto : list) {
				Map<String, String> obj = new HashMap<String, String>();
				obj.put("code", dto.getCode());
				obj.put("dong", dto.getDong());
				result.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@ApiOperation(value = "id를 받아 관심 정보 목록(동 이름)을 반환한다.", response = List.class)
	@GetMapping("/interest/{id}")
	private ResponseEntity<List<Map<String, String>>> searchInterest(@PathVariable String id) {
		List<Map<String, String>> result = new ArrayList<Map<String, String>>();
		List<InterestDTO> list = null;
		try {
			list = searchService.searchAllInterest(id);
			for(InterestDTO dto : list) {
				Map<String, String> obj = new HashMap<String, String>();
				obj.put("dong", dto.getDong());
				result.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@ApiOperation(value = "새로운 관심 정보(동 이름)를 추가한다.", response = String.class)
	@PostMapping("/interest")
	private ResponseEntity<List<InterestDTO>> insertInterest(@RequestBody InterestDTO interest) {
		System.out.println(interest.getId() + " : " + interest.getDong());
		searchService.insertInterest(interest);
		List<InterestDTO> result = searchService.searchAllInterest(interest.getId());
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@ApiOperation(value = "관심 정보(동 이름)를 받아 삭제한다.", response = String.class)
	@DeleteMapping("/interest")
	private ResponseEntity<List<InterestDTO>> deleteInterest(@RequestBody InterestDTO interest) {
		System.out.println(interest.getId() + " : " + interest.getDong());
		searchService.deleteInterest(interest);
		List<InterestDTO> result = searchService.searchAllInterest(interest.getId());
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}