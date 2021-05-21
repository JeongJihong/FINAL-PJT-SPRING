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

import com.ssafy.dto.QnADTO;
import com.ssafy.repository.QnAMapper;

@Service
public class QnAServiceImpl implements QnAService{

	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void registerQnA(QnADTO qnaDto) throws SQLException {
		sqlSession.getMapper(QnAMapper.class).registerQnA(qnaDto);
	}

	@Override
	public List<QnADTO> allQnA() throws SQLException {
		return sqlSession.getMapper(QnAMapper.class).allQnA();
	}

	@Override
	public List<QnADTO> listQnA(Map<String, String> map) throws SQLException {
		return sqlSession.getMapper(QnAMapper.class).listQnA(map);
	}

	@Override
	public QnADTO getQnA(int qnano) throws SQLException {
		return sqlSession.getMapper(QnAMapper.class).getQnA(qnano);
	}

	@Override
	public void modifyQnA(QnADTO qnaDto) throws SQLException {
		sqlSession.getMapper(QnAMapper.class).modifyQnA(qnaDto);
	}

	@Override
	public void deleteQnA(String qnano) throws SQLException {
		sqlSession.getMapper(QnAMapper.class).deleteQnA(qnano);
	}

	@Override
	public void modifyAnswer(QnADTO qnaDto) throws SQLException {
		sqlSession.getMapper(QnAMapper.class).modifyQnA(qnaDto);
	}
	
}
