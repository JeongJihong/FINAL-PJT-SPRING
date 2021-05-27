package com.ssafy.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.dto.ArticleDTO;
import com.ssafy.repository.ArticleMapper;

@Service
public class ArticleServiceImpl implements ArticleService{

	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void registerArticle(ArticleDTO articleDto) throws SQLException {
		sqlSession.getMapper(ArticleMapper.class).registerArticle(articleDto);
	}

	@Override
	public List<ArticleDTO> allArticle() throws SQLException {
		return sqlSession.getMapper(ArticleMapper.class).allArticle();
	}

	@Override
	public List<ArticleDTO> listArticle(Map<String, String> map) throws SQLException {
		return sqlSession.getMapper(ArticleMapper.class).listArticle(map);
	}

	@Override
	public ArticleDTO getArticle(int articleno) throws SQLException {
		return sqlSession.getMapper(ArticleMapper.class).getArticle(articleno);
	}

	@Override
	public void modifyArticle(ArticleDTO articleDto) throws SQLException {
		sqlSession.getMapper(ArticleMapper.class).modifyArticle(articleDto);
	}

	@Override
	public void deleteArticle(String articleno) throws SQLException {
		sqlSession.getMapper(ArticleMapper.class).deleteArticle(articleno);
	}
	
}
