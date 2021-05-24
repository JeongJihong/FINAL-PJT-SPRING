package com.ssafy.service;

import java.util.List;
import java.util.Map;

import com.ssafy.dto.ShopDataDTO;

public interface ShopDataService {
	public List<ShopDataDTO> getShopData(Map<String, String> map);
	
	public List<ShopDataDTO> getShopDataAvg(Map<String, String> map);
}
