package com.ssafy.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.dto.ShopDataDTO;
import com.ssafy.service.ShopDataService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//http://localhost/vue/swagger-ui.html
@CrossOrigin("*")
@RestController
@RequestMapping("/shop")
@Api("HappyHouse ShopData 컨트롤러 API V1")
public class ShopDataController {

	private static final Logger logger = LoggerFactory.getLogger(ShopDataController.class);

	@Autowired
	ShopDataService shopDataService;

	@ApiOperation(value = "구군 코드, 동 이름을 받아 상권 정보 데이터를 반환한다.", response = List.class)
	@GetMapping(value = "/data")
	private ResponseEntity<List<ShopDataDTO>> getShopData(@RequestParam Map<String, String> map) {
		logger.debug("shop data");
		return new ResponseEntity<>(shopDataService.getShopData(map), HttpStatus.OK);
	}
	
	@ApiOperation(value = "구군 코드를 받아 상권 정보 데이터의 평균을 반환한다.", response = List.class)
	@GetMapping(value ="/avg")
	private ResponseEntity<List<ShopDataDTO>> getShopDataAvg(@RequestParam Map<String, String> map) {
		logger.debug("shop data avg");
		// System.out.println(map);
		return new ResponseEntity<>(shopDataService.getShopDataAvg(map), HttpStatus.OK);
	}
}