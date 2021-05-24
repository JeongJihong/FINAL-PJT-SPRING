package com.ssafy.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.dto.ShopDataDTO;
import com.ssafy.repository.ShopDataMapper;

@Service
public class ShopDataServiceImpl implements ShopDataService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<ShopDataDTO> getShopData(Map<String, String> map) {
		return sqlSession.getMapper(ShopDataMapper.class).getShopData(map);
	}

	@Override
	public List<ShopDataDTO> getShopDataAvg(Map<String, String> map) {
		return sqlSession.getMapper(ShopDataMapper.class).getShopDataAvg(map);
	}

}
