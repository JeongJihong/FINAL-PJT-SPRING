package com.ssafy.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.dto.QnaDTO;
import com.ssafy.repository.QnaMapper;

@Service
public class QnaServiceImpl implements QnaService{

	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void registerQna(QnaDTO qnaDto) throws SQLException {
		sqlSession.getMapper(QnaMapper.class).registerQna(qnaDto);
	}

	@Override
	public List<QnaDTO> allQna() throws SQLException {
		return sqlSession.getMapper(QnaMapper.class).allQna();
	}

	@Override
	public List<QnaDTO> listQna(Map<String, String> map) throws SQLException {
		return sqlSession.getMapper(QnaMapper.class).listQna(map);
	}

	@Override
	public QnaDTO getQna(int qnano) throws SQLException {
		return sqlSession.getMapper(QnaMapper.class).getQna(qnano);
	}

	@Override
	public void modifyQna(QnaDTO qnaDto) throws SQLException {
		sqlSession.getMapper(QnaMapper.class).modifyQna(qnaDto);
	}

	@Override
	public void deleteQna(String qnano) throws SQLException {
		sqlSession.getMapper(QnaMapper.class).deleteQna(qnano);
	}

	@Override
	public void modifyAnswer(QnaDTO qnaDto) throws SQLException {
		sqlSession.getMapper(QnaMapper.class).modifyQna(qnaDto);
	}
	
}
