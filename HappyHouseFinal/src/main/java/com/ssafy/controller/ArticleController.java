package com.ssafy.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.ssafy.service.ArticleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//http://localhost/vue/swagger-ui.html
@CrossOrigin("*")
@RestController
@RequestMapping("/article")
@Api("HappyHouse Article 컨트롤러 API V1")
public class ArticleController {

	private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);

	@Autowired
	ArticleService articleService;
	
//	@ApiOperation(value = "모든 글목록의 정보를 반환한다.", response = Model.class)
//	@GetMapping(value = "/list")
//	private ResponseEntity<Model> allListArticle(@RequestParam Map<String, String> map, Model model) {
//		logger.debug("all list article");
//		Map<String, Object> mapRtn = new HashMap<String, Object>();
//		String pg = map.containsKey("pg") ? map.get("pg") : null;
//		String spp = map.containsKey("spp") ? map.get("spp") : null;
//		
//		int currentPage = pg == null? 1 : Integer.parseInt(pg);
//		currentPage = currentPage == 0 ? 1 : currentPage; 
//		int sizePerPage = spp == null ? 10 : Integer.parseInt(spp);//sizePerPage
//		
//		try {
//			model.addAttribute("list", articleService.allArticle(currentPage, sizePerPage) );
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return new ResponseEntity<>(model, HttpStatus.OK);
//	}

	@ApiOperation(value = "모든  글목록의 정보를 반환한다.", response = Map.class)
	@GetMapping(value = "/list")
	private ResponseEntity<Map<String, Object>> allListQna() {
		logger.debug("all list article");
		Map<String, Object> mapRtn = new HashMap<String, Object>();

		try {
			mapRtn.put("list", articleService.allArticle() );
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(mapRtn, HttpStatus.OK);
	}

	@ApiOperation(value = "글목록의 정보를 수정한다.", response = Map.class)
	@PutMapping("{articleno}")
	private ResponseEntity<Map<String, Object>> modifyArticle(@PathVariable String articleno, @RequestBody Map<String, String> map) {
		int no = Integer.parseInt(articleno);
		Map<String, Object> mapRtn = new HashMap<String, Object>();
		
		logger.debug("modify no: " + no);
		
		if(no != 0) {
			try {
				ArticleDTO articleDTO = articleService.getArticle(no);
				articleDTO.setSubject(map.get("subject"));
				articleDTO.setContent(map.get("content"));
				articleService.modifyArticle(articleDTO);
				mapRtn.put("list", articleService.allArticle() );
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return new ResponseEntity<>(mapRtn, HttpStatus.OK);
	}

	@ApiOperation(value = "글목록의 정보를 삭제한다.", response = String.class)
	@DeleteMapping("{articleno}")
	private ResponseEntity<Map<String, Object>> deleteArticle(@PathVariable String articleno) {
		logger.debug("delete article");
		Map<String, Object> mapRtn = new HashMap<String, Object>();

		try {
			articleService.deleteArticle(articleno);
			mapRtn.put("list", articleService.allArticle() );
			mapRtn.put("msg", "success");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(mapRtn, HttpStatus.OK);
	}

//	@ApiOperation(value = "글을 등록한다.", response = String.class)
//	@PostMapping(value = "/register")
//	private ResponseEntity<String> registerArticle(@RequestBody String subject, @RequestBody String content, HttpSession session) {
//		logger.debug("register article");
//		
//		ArticleDTO articleDto = new ArticleDTO();
//		articleDto.setUserId((String) session.getAttribute("id"));
//		articleDto.setSubject(subject);		
//		articleDto.setContent(content);
//		
//		try {
//			articleService.deleteArticle(Integer.toString(articleDto.getArticleno()));
//			articleService.registerArticle(articleDto);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return new ResponseEntity<String>("success", HttpStatus.OK);
//	}
	
	@ApiOperation(value = "글을 등록한다.", response = Map.class)
	@PostMapping(value = "/register")
	private ResponseEntity<Map<String, Object>> registerArticle(@RequestBody Map<String, String> map) {
		logger.debug("register article");
		Map<String, Object> mapRtn = new HashMap<String, Object>();
		
		ArticleDTO articleDto = new ArticleDTO();
		articleDto.setUserId(map.get("id"));
		articleDto.setSubject(map.get("subject"));		
		articleDto.setContent(map.get("content"));
		
		try {
			articleService.deleteArticle(Integer.toString(articleDto.getArticleno()));
			articleService.registerArticle(articleDto);
			mapRtn.put("list", articleService.allArticle() );
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(mapRtn, HttpStatus.OK);
	}

//	@ApiOperation(value = "해당 글목록의 정보를 반환한다.", response = List.class)
//	@GetMapping(value = "/search")
//	private ResponseEntity<List<ArticleDTO>> searchArticle(@RequestParam Map<String, String> map, Model model) {
//		logger.debug("search");
//		//Map<String, Object> mapRtn = new HashMap<String, Object>();
//		try {
//			model.addAttribute("list", articleService.listArticle(map));
//			return new ResponseEntity<>(articleService.listArticle(map), HttpStatus.OK);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
	
	@ApiOperation(value = "해당 글목록의 정보를 반환한다.", response = List.class)
	@GetMapping(value = "/search")
	private ResponseEntity<Map<String, Object>> searchArticle(@RequestParam Map<String, String> map) {
		logger.debug("article search");
		System.out.println(map.get("key") + "|" + map.get("word"));
		Map<String, Object> mapRtn = new HashMap<String, Object>();
		try {
			mapRtn.put("list", articleService.listArticle(map));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(mapRtn, HttpStatus.OK);
	}
	
	@ApiOperation(value = "해당 번호의 글목록 정보를 반환한다.", response = List.class)
	@GetMapping("{articleno}")
	private ResponseEntity<ArticleDTO> searchQna(@PathVariable String articleno, @RequestParam Map<String, String> map) {
		logger.debug("search");
		
		int no = Integer.parseInt(articleno);
		try {
			return new ResponseEntity<>(articleService.getArticle(no), HttpStatus.OK);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}