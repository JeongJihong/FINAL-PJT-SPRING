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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
	
	@ApiOperation(value = "모든 글목록의 정보를 반환한다.", response = Model.class)
	@GetMapping(value = "/list")
	private ResponseEntity<Model> allListArticle(@RequestParam Map<String, String> map, Model model) {
		logger.debug("all list article");
		Map<String, Object> mapRtn = new HashMap<String, Object>();
		String pg = map.containsKey("pg") ? map.get("pg") : null;
		String spp = map.containsKey("spp") ? map.get("spp") : null;
		
		int currentPage = pg == null? 1 : Integer.parseInt(pg);
		currentPage = currentPage == 0 ? 1 : currentPage; 
		int sizePerPage = spp == null ? 10 : Integer.parseInt(spp);//sizePerPage
		
		try {
			model.addAttribute("list", articleService.allArticle(currentPage, sizePerPage) );
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(model, HttpStatus.OK);
	}

	@ApiOperation(value = "글목록의 정보를 수정한다.", response = Map.class)
	@PutMapping("{articleno}")
	private ResponseEntity<Map<String, Object>> modifyArticle(@PathVariable String articleno) {
		int no = Integer.parseInt(articleno);
		Map<String, Object> map = new HashMap<String, Object>();
		
		logger.debug("modify no: " + no);
		
		if(no != 0) {
			try {
				ArticleDTO articleDTO = articleService.getArticle(no);
				map.put("artdto", articleDTO);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

	@ApiOperation(value = "글목록의 정보를 삭제한다.", response = String.class)
	@DeleteMapping("{articleno}")
	private ResponseEntity<String> deleteArticle(@PathVariable String articleno) {
		logger.debug("delete article");

		try {
			articleService.deleteArticle(articleno);
			return new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("fail", HttpStatus.NO_CONTENT);
		}
	}

	@ApiOperation(value = "글을 등록한다.", response = String.class)
	@PostMapping(value = "/register")
	private ResponseEntity<String> registerArticle(@RequestBody String subject, @RequestBody String content, HttpSession session) {
		logger.debug("register article");
		
		ArticleDTO articleDto = new ArticleDTO();
		articleDto.setUserId((String) session.getAttribute("id"));
		articleDto.setSubject(subject);		
		articleDto.setContent(content);
		
		try {
			articleService.deleteArticle(Integer.toString(articleDto.getArticleno()));
			articleService.registerArticle(articleDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>("success", HttpStatus.OK);
	}

	@ApiOperation(value = "해당 글목록의 정보를 반환한다.", response = List.class)
	@GetMapping(value = "/search")
	private ResponseEntity<List<ArticleDTO>> searchArticle(@RequestParam Map<String, String> map, Model model) {
		logger.debug("search");
		//Map<String, Object> mapRtn = new HashMap<String, Object>();
		try {
			model.addAttribute("list", articleService.listArticle(map));
			return new ResponseEntity<>(articleService.listArticle(map), HttpStatus.OK);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}