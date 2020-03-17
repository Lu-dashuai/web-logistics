package com.aaa.mvc.service;

import java.util.List;
import java.util.Map;

public interface CarService {

	int getPageCount(Map paramMap);

	Object getPage(Map paramMap);

	int carAdd(Map paramMap);

	int carDel(String id);

	int carUpdate(Map paramMap);

	List<Map<String, Object>> select();

}
