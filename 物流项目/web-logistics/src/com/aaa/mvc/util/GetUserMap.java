package com.aaa.mvc.util;

import java.util.List;
import java.util.Map;

public class GetUserMap {
	public static Map<String, Object> getUserMap(Object username){
		List<Map<String, Object>> selectMap = BaseDao.selectMap("select * from tb_admin where username =?", new Object[]{username});
		return selectMap.get(0);
	}
}
