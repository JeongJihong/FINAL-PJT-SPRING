package com.ssafy.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.dto.ArticleDTO;
import com.ssafy.dto.QnADTO;
import com.ssafy.service.QnAService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//http://localhost/vue/swagger-ui.html
@CrossOrigin("*")
@RestController
@RequestMapping("/qna")
@Api("HappyHouse Article 컨트롤러 API V1")
public class QnAController {

	private static final Logger logger = LoggerFactory.getLogger(QnAController.class);

	@Autowired
	QnAService qnaService;
	
	@ApiOperation(value = "모든 글목록의 정보를 반환한다.", response = Map.class)
	@GetMapping(value = "/list")
	private ResponseEntity<Map<String, Object>> allListQnA() {
		logger.debug("all list article");
		Map<String, Object> mapRtn = new HashMap<String, Object>();

		try {
			mapRtn.put("list", qnaService.allQnA() );
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(mapRtn, HttpStatus.OK);
	}

	@ApiOperation(value = "글목록의 정보를 수정한다.", response = Map.class)
	@PutMapping("{qnano}")
	private ResponseEntity<String> modifyQnA(@PathVariable String qnano, @RequestBody Map<String, String> map) {
		int no = Integer.parseInt(qnano);
		
		logger.debug("modify no: " + no);
		
		if(no != 0) {
			try {
				QnADTO qnaDTO = qnaService.getQnA(no);
				qnaDTO.setSubject(map.get("subject"));
				qnaDTO.setContent(map.get("content"));
				qnaDTO.setAnswer(map.get("answer"));
				qnaService.modifyQnA(qnaDTO);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return new ResponseEntity<>("success", HttpStatus.OK);
	}

	@ApiOperation(value = "글목록의 정보를 삭제한다.", response = String.class)
	@DeleteMapping("{qnano}")
	private ResponseEntity<String> deleteQnA(@PathVariable String qnano) {
		logger.debug("delete article");

		try {
			qnaService.deleteQnA(qnano);
			return new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("fail", HttpStatus.NO_CONTENT);
		}
	}

	@ApiOperation(value = "글을 등록한다.", response = String.class)
	@PostMapping(value = "/register")
	private ResponseEntity<String> registerQnA(@RequestBody Map<String, String> map) {
		logger.debug("register article");
		
		QnADTO qnaDto = new QnADTO();
		//qnaDto.setId((String) session.getAttribute("id"));
		qnaDto.setId("ssafy");
		qnaDto.setSubject(map.get("subject"));		
		qnaDto.setContent(map.get("content"));
		qnaDto.setAnswer(map.get("answer"));
		
		try {
			qnaService.deleteQnA(Integer.toString(qnaDto.getQnAno()));
			qnaService.registerQnA(qnaDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}

	@ApiOperation(value = "해당 글목록의 정보를 반환한다.", response = List.class)
	@GetMapping(value = "/search")
	private ResponseEntity<Map<String, Object>> searchQnA(@RequestParam Map<String, String> map) {
		logger.debug("search");
		System.out.println(map.get("key") + "|" + map.get("word"));
		Map<String, Object> mapRtn = new HashMap<String, Object>();
		try {
			mapRtn.put("list", qnaService.listQnA(map));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(mapRtn, HttpStatus.OK);
	}
}