package com.ssafy.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.dto.QnADTO;

public interface QnAService {
//	글작성
	void registerQnA(QnADTO qnaDto) throws SQLException;
	
//	글 검색
	List<QnADTO> listQnA(Map<String, String> map) throws SQLException;

// 	글 목록
	List<QnADTO> allQnA() throws SQLException;	
	
//	글수정을 위한 글얻기
	QnADTO getQnA(int qnano) throws SQLException;
	
//	글수정
	void modifyQnA(QnADTO qnaDto) throws SQLException;
	
//	글삭제
	void deleteQnA(String qnano) throws SQLException;
	
//	답변작성
	void modifyAnswer(QnADTO qnaDto) throws SQLException;
	
}
