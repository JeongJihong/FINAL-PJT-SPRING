package com.ssafy.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.dto.ArticleDTO;

public interface ArticleService {
//	글작성
	void registerArticle(ArticleDTO articleDto) throws SQLException;
	
//	글 검색
	List<ArticleDTO> listArticle(Map<String, String> map) throws SQLException;

// 	글 목록
	List<ArticleDTO> allArticle(int currentPage, int sizePerPage) throws SQLException;	
	
//	글수정을 위한 글얻기
	ArticleDTO getArticle(int articleno) throws SQLException;
	
//	글수정
	void modifyArticle(ArticleDTO articleDto) throws SQLException;
	
//	글삭제
	void deleteArticle(String articleno) throws SQLException;
}
