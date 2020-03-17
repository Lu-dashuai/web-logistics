package com.aaa.mvc.service;

import java.util.List;
import java.util.Map;

public interface DistributeService {

	int getPageCount(Map paramMap);

	Object getPage(Map paramMap);

	int updateStatus(Map map);

	Object selectPeople();

	List<Map<String, Object>> getById(String id);

}
