package com.ssafy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.ApiOperation;

@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ApiOperation(value = "index 페이지", notes = "메인 화면 <big>index</big>를 반환해 줍니다.")
	public @ResponseBody ResponseEntity<String> home() {
		logger.info("Welcome Happy House!");
		
		return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
	}
}
