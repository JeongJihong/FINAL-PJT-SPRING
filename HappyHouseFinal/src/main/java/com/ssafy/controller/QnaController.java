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
import com.ssafy.dto.QnaDTO;
import com.ssafy.service.QnaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//http://localhost/vue/swagger-ui.html
@CrossOrigin("*")
@RestController
@RequestMapping("/qna")
@Api("HappyHouse QnA 컨트롤러 API V1")
public class QnaController {

	private static final Logger logger = LoggerFactory.getLogger(QnaController.class);

	@Autowired
	QnaService qnaService;
	
	@ApiOperation(value = "모든 Q&A목록의 정보를 반환한다.", response = Map.class)
	@GetMapping(value = "/list")
	private ResponseEntity<Map<String, Object>> allListQna() {
		logger.debug("all list qna");
		Map<String, Object> mapRtn = new HashMap<String, Object>();

		try {
			mapRtn.put("list", qnaService.allQna() );
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(mapRtn, HttpStatus.OK);
	}

	@ApiOperation(value = "Q&A목록의 정보를 수정한다.", response = Map.class)
	@PutMapping("{qnano}")
	private ResponseEntity<String> modifyQna(@PathVariable String qnano, @RequestBody Map<String, String> map) {
		int no = Integer.parseInt(qnano);
		
		logger.debug("modify no: " + no);
		
		if(no != 0) {
			try {
				QnaDTO qnaDTO = qnaService.getQna(no);
				qnaDTO.setSubject(map.get("subject"));
				qnaDTO.setContent(map.get("content"));
				qnaDTO.setAnswer(map.get("answer"));
				qnaService.modifyQna(qnaDTO);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return new ResponseEntity<>("success", HttpStatus.OK);
	}

	@ApiOperation(value = "Q&A목록의 정보를 삭제한다.", response = String.class)
	@DeleteMapping("{qnano}")
	private ResponseEntity<String> deleteQna(@PathVariable String qnano) {
		logger.debug("delete qna");

		try {
			qnaService.deleteQna(qnano);
			return new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("fail", HttpStatus.NO_CONTENT);
		}
	}

	@ApiOperation(value = "Q&A을 등록한다.", response = String.class)
	@PostMapping(value = "/register")
	private ResponseEntity<String> registerQna(@RequestBody Map<String, String> map) {
		logger.debug("register qna");
		
		QnaDTO qnaDto = new QnaDTO();
		//qnaDto.setId((String) session.getAttribute("id"));
		qnaDto.setId("ssafy");
		qnaDto.setSubject(map.get("subject"));		
		qnaDto.setContent(map.get("content"));
		qnaDto.setAnswer(map.get("answer"));
		
		try {
			qnaService.deleteQna(Integer.toString(qnaDto.getQnano()));
			qnaService.registerQna(qnaDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}

	@ApiOperation(value = "해당 Q&A목록의 정보를 반환한다.", response = List.class)
	@GetMapping(value = "/search")
	private ResponseEntity<Map<String, Object>> searchQna(@RequestParam Map<String, String> map) {
		logger.debug("qna search");
		System.out.println(map.get("key") + "|" + map.get("word"));
		Map<String, Object> mapRtn = new HashMap<String, Object>();
		try {
			mapRtn.put("list", qnaService.listQna(map));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(mapRtn, HttpStatus.OK);
	}
	
	@ApiOperation(value = "해당 번호의 Q&A목록 정보를 반환한다.", response = List.class)
	@GetMapping("{qnano}")
	private ResponseEntity<QnaDTO> searchQna(@PathVariable String qnano, @RequestParam Map<String, String> map) {
		logger.debug("search");
		
		int no = Integer.parseInt(qnano);
		try {
			return new ResponseEntity<>(qnaService.getQna(no), HttpStatus.OK);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}