package com.ssafy.repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.dto.QnaDTO;

public interface QnaMapper {
//	글작성
	void registerQna(QnaDTO QnaDTO) throws SQLException;
	
//	글 검색
	List<QnaDTO> listQna(Map<String, String> map) throws SQLException;

// 	글 목록
	List<QnaDTO> allQna() throws SQLException;
	
//	글수정을 위한 글얻기
	QnaDTO getQna(int qnano) throws SQLException;
	
//	글수정
	void modifyQna(QnaDTO QnaDTO) throws SQLException;
	
//	글삭제
	void deleteQna(String qnano) throws SQLException;

//	답변작성
	void modifyAnswer(QnaDTO QnaDTO) throws SQLException;
	
}