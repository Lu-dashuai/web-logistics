package com.bds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName:     	Test2.java
 * @Description:  
 * @author : 		jack.Lu
 * @version : 		V1.0  
 * @Date : 			2019年11月8日 下午5:20:46 
 */
public class Test2 {
	public static void main(String[] args) {
		String groupList_str = getGroupList();
		JSONArray groupList = JSONObject.parseArray(groupList_str);
		System.out.println(groupList);
		
		List<List<JSONObject>> list = new  ArrayList<>();
		
		//获取到每行每列
		if (groupList!=null) {
			int size = groupList.size();//决定行数
			for (int i = 0; i < size; i++) {
				JSONObject ele = groupList.getJSONObject(i);//每行
				JSONArray groupDeatil = ele.getJSONArray("groupDeatil");
				List<JSONObject> temp_list = new  ArrayList<>();
				if (groupDeatil!=null) {
					int size2 = groupDeatil.size();//决定列数
					for (int j = 0; j < size2; j++) {
						JSONObject deatil = groupDeatil.getJSONObject(j);//每列
						temp_list.add(deatil);
					}
				}
				list.add(temp_list);
			}
		}

        List<List<JSONObject>> result = new ArrayList<List<JSONObject>>();

        List<List<JSONObject>> descartes = descartes(list, result, 0, new ArrayList<JSONObject>());
		System.out.println(result);
	}
	
	private static List<List<JSONObject>> descartes(List<List<JSONObject>> dimvalue, List<List<JSONObject>> result, int layer, List<JSONObject> curList) {
        if (layer < dimvalue.size() - 1) {
            if (dimvalue.get(layer).size() == 0) {
                descartes(dimvalue, result, layer + 1, curList);
            } else {
                for (int i = 0; i < dimvalue.get(layer).size(); i++) {
                    List<JSONObject> list = new ArrayList<JSONObject>(curList);
                    list.add(dimvalue.get(layer).get(i));
                    descartes(dimvalue, result, layer + 1, list);
                }
            }
        } else if (layer == dimvalue.size() - 1) {
            if (dimvalue.get(layer).size() == 0) {
                result.add(curList);
            } else {
                for (int i = 0; i < dimvalue.get(layer).size(); i++) {
                    List<JSONObject> list = new ArrayList<JSONObject>(curList);
                    list.add(dimvalue.get(layer).get(i));
                    result.add(list);
                }
            }
        }
        return result;
    }

	
	
	
	private static List<List<JSONObject>> caoList(List<JSONObject> list1 ,List<JSONObject> list2) {
		 List<List<JSONObject>> list = new ArrayList<>();
		 List<JSONObject> list_json = null;
		 int size1 = list1.size();
		 int size2 = list2.size();
		 for (int i = 0; i < size1; i++) {
			 for (int j = 0; j < size2; j++) {
				list_json = new ArrayList<>();
				JSONObject json1 = list1.get(i);
				JSONObject json2 = list2.get(j);
				list_json.add(json1);
				list_json.add(json2);
				list.add(list_json);
			}
		}
		return list;
	}

	

	
	
	
	private static String getGroupList() {
		String groupList ="[\r\n" + 
				"        {\r\n" + 
				"          \"groupId\": \"17404\",\r\n" + 
				"          \"name\": \"1\",\r\n" + 
				"          \"groupDeatil\": [\r\n" + 
				"            {\r\n" + 
				"              \"sequence\": 0,\r\n" + 
				"              \"price\": 0,\r\n" + 
				"              \"name\": \"安格斯厚牛培根堡\",\r\n" + 
				"              \"id\": \"123470098\",\r\n" + 
				"              \"pic\": \"http://img0.sandload.cn/freemud_mall_1566456140.png\",\r\n" + 
				"              \"stock\": 0,\r\n" + 
				"              \"dishCode\": \"900156\"\r\n" + 
				"            }\r\n" + 
				"          ],\r\n" + 
				"          \"remark\": \"1\",\r\n" + 
				"          \"type\": 0\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"groupId\": \"17405\",\r\n" + 
				"          \"name\": \"10000315_9001\",\r\n" + 
				"          \"groupDeatil\": [\r\n" + 
				"            {\r\n" + 
				"              \"sequence\": 0,\r\n" + 
				"              \"price\": 0,\r\n" + 
				"              \"name\": \"中薯条\",\r\n" + 
				"              \"id\": \"123457833\",\r\n" + 
				"              \"pic\": \"https://picture.sandload.cn/shutiao-zhong.png\",\r\n" + 
				"              \"stock\": 0,\r\n" + 
				"              \"dishCode\": \"3552\"\r\n" + 
				"            },\r\n" + 
				"            {\r\n" + 
				"              \"sequence\": 0,\r\n" + 
				"              \"price\": 200,\r\n" + 
				"              \"name\": \"金黄脆薯格\",\r\n" + 
				"              \"id\": \"123468537\",\r\n" + 
				"              \"pic\": \"https://picture.sandload.cn/shuge.png\",\r\n" + 
				"              \"stock\": 0,\r\n" + 
				"              \"dishCode\": \"503202\"\r\n" + 
				"            },\r\n" + 
				"            {\r\n" + 
				"              \"sequence\": 0,\r\n" + 
				"              \"price\": 0,\r\n" + 
				"              \"name\": \"小玉米杯\",\r\n" + 
				"              \"id\": \"123457834\",\r\n" + 
				"              \"pic\": \"https://picture.sandload.cn/L-YuMibei.png\",\r\n" + 
				"              \"stock\": 0,\r\n" + 
				"              \"dishCode\": \"3553\"\r\n" + 
				"            }\r\n" + 
				"          ],\r\n" + 
				"          \"remark\": \"2\",\r\n" + 
				"          \"type\": 0\r\n" + 
				"        },\r\n" + 
				"        {\r\n" + 
				"          \"groupId\": \"17406\",\r\n" + 
				"          \"name\": \"10000002_9001\",\r\n" + 
				"          \"groupDeatil\": [\r\n" + 
				"            {\r\n" + 
				"              \"sequence\": 0,\r\n" + 
				"              \"price\": 0,\r\n" + 
				"              \"name\": \"中杯可口可乐\",\r\n" + 
				"              \"id\": \"123457820\",\r\n" + 
				"              \"pic\": \"https://picture.sandload.cn/CoCa-Cola-M.png\",\r\n" + 
				"              \"stock\": 0,\r\n" + 
				"              \"dishCode\": \"3050\"\r\n" + 
				"            },\r\n" + 
				"            {\r\n" + 
				"              \"sequence\": 0,\r\n" + 
				"              \"price\": 200,\r\n" + 
				"              \"name\": \"大杯可乐\",\r\n" + 
				"              \"id\": \"123457826\",\r\n" + 
				"              \"pic\": \"https://picture.sandload.cn/CoCa-Cola-L.png\",\r\n" + 
				"              \"stock\": 0,\r\n" + 
				"              \"dishCode\": \"3100\"\r\n" + 
				"            },\r\n" + 
				"            {\r\n" + 
				"              \"sequence\": 0,\r\n" + 
				"              \"price\": 200,\r\n" + 
				"              \"name\": \"ZICO椰子水饮\",\r\n" + 
				"              \"id\": \"123470232\",\r\n" + 
				"              \"pic\": \"https://picture.sandload.cn/YeZi-Drink.png\",\r\n" + 
				"              \"stock\": 0,\r\n" + 
				"              \"dishCode\": \"900222\"\r\n" + 
				"            },\r\n" + 
				"            {\r\n" + 
				"              \"sequence\": 0,\r\n" + 
				"              \"price\": 450,\r\n" + 
				"              \"name\": \"黑糖珍珠奶茶(暖)\",\r\n" + 
				"              \"id\": \"123471711\",\r\n" + 
				"              \"pic\": \"http://img0.sandload.cn/freemud_mall_1571815310.png\",\r\n" + 
				"              \"stock\": 0,\r\n" + 
				"              \"dishCode\": \"900659\"\r\n" + 
				"            },\r\n" + 
				"            {\r\n" + 
				"              \"sequence\": 0,\r\n" + 
				"              \"price\": 350,\r\n" + 
				"              \"name\": \"原味珍珠奶茶(暖)\",\r\n" + 
				"              \"id\": \"123471713\",\r\n" + 
				"              \"pic\": \"http://img0.sandload.cn/freemud_mall_1571815510.png\",\r\n" + 
				"              \"stock\": 0,\r\n" + 
				"              \"dishCode\": \"900655\"\r\n" + 
				"            },\r\n" + 
				"            {\r\n" + 
				"              \"sequence\": 0,\r\n" + 
				"              \"price\": 200,\r\n" + 
				"              \"name\": \"中杯FUZE tea低糖绿茶饮料\",\r\n" + 
				"              \"id\": \"123470633\",\r\n" + 
				"              \"pic\": \"https://picture.sandload.cn/DiTang-GreenTea-M.png\",\r\n" + 
				"              \"stock\": 0,\r\n" + 
				"              \"dishCode\": \"900367\"\r\n" + 
				"            },\r\n" + 
				"            {\r\n" + 
				"              \"sequence\": 0,\r\n" + 
				"              \"price\": 400,\r\n" + 
				"              \"name\": \"大杯FUZE tea低糖绿茶饮料\",\r\n" + 
				"              \"id\": \"123470634\",\r\n" + 
				"              \"pic\": \"https://picture.sandload.cn/DiTang-GreenTea-L.png\",\r\n" + 
				"              \"stock\": 0,\r\n" + 
				"              \"dishCode\": \"900368\"\r\n" + 
				"            },\r\n" + 
				"            {\r\n" + 
				"              \"sequence\": 0,\r\n" + 
				"              \"price\": 450,\r\n" + 
				"              \"name\": \"黑糖珍珠奶茶(冷)\",\r\n" + 
				"              \"id\": \"123471712\",\r\n" + 
				"              \"pic\": \"http://img0.sandload.cn/freemud_mall_1571815492.png\",\r\n" + 
				"              \"stock\": 0,\r\n" + 
				"              \"dishCode\": \"900661\"\r\n" + 
				"            },\r\n" + 
				"            {\r\n" + 
				"              \"sequence\": 0,\r\n" + 
				"              \"price\": 350,\r\n" + 
				"              \"name\": \"原味珍珠奶茶(冷)\",\r\n" + 
				"              \"id\": \"123471714\",\r\n" + 
				"              \"pic\": \"http://img0.sandload.cn/freemud_mall_1571815531.png\",\r\n" + 
				"              \"stock\": 0,\r\n" + 
				"              \"dishCode\": \"900657\"\r\n" + 
				"            },\r\n" + 
				"            {\r\n" + 
				"              \"sequence\": 0,\r\n" + 
				"              \"price\": 800,\r\n" + 
				"              \"name\": \"大菠浪水果茶\",\r\n" + 
				"              \"id\": \"123467794\",\r\n" + 
				"              \"pic\": \"https://picture.sandload.cn/DaBoLang-FruitTea.png\",\r\n" + 
				"              \"stock\": 0,\r\n" + 
				"              \"dishCode\": \"502969\"\r\n" + 
				"            },\r\n" + 
				"            {\r\n" + 
				"              \"sequence\": 0,\r\n" + 
				"              \"price\": 800,\r\n" + 
				"              \"name\": \"香芒芒水果茶\",\r\n" + 
				"              \"id\": \"123467795\",\r\n" + 
				"              \"pic\": \"https://picture.sandload.cn/XiangMangMang-FruitTea.png\",\r\n" + 
				"              \"stock\": 0,\r\n" + 
				"              \"dishCode\": \"502971\"\r\n" + 
				"            },\r\n" + 
				"            {\r\n" + 
				"              \"sequence\": 0,\r\n" + 
				"              \"price\": 0,\r\n" + 
				"              \"name\": \"中杯零度可口可乐\",\r\n" + 
				"              \"id\": \"123459528\",\r\n" + 
				"              \"pic\": \"https://picture.sandload.cn/LingDu-Cola-M.png\",\r\n" + 
				"              \"stock\": 0,\r\n" + 
				"              \"dishCode\": \"3071\"\r\n" + 
				"            },\r\n" + 
				"            {\r\n" + 
				"              \"sequence\": 0,\r\n" + 
				"              \"price\": 200,\r\n" + 
				"              \"name\": \"大杯零度可口可乐\",\r\n" + 
				"              \"id\": \"123458826\",\r\n" + 
				"              \"pic\": \"https://picture.sandload.cn/LingDu-Cola-L.png\",\r\n" + 
				"              \"stock\": 0,\r\n" + 
				"              \"dishCode\": \"3111\"\r\n" + 
				"            },\r\n" + 
				"            {\r\n" + 
				"              \"sequence\": 0,\r\n" + 
				"              \"price\": 0,\r\n" + 
				"              \"name\": \"中杯雪碧\",\r\n" + 
				"              \"id\": \"123457821\",\r\n" + 
				"              \"pic\": \"https://picture.sandload.cn/M-XueBi.png\",\r\n" + 
				"              \"stock\": 0,\r\n" + 
				"              \"dishCode\": \"3060\"\r\n" + 
				"            },\r\n" + 
				"            {\r\n" + 
				"              \"sequence\": 0,\r\n" + 
				"              \"price\": 200,\r\n" + 
				"              \"name\": \"大杯雪碧\",\r\n" + 
				"              \"id\": \"123458566\",\r\n" + 
				"              \"pic\": \"https://picture.sandload.cn/L-XueBi.png\",\r\n" + 
				"              \"stock\": 0,\r\n" + 
				"              \"dishCode\": \"3110\"\r\n" + 
				"            },\r\n" + 
				"            {\r\n" + 
				"              \"sequence\": 0,\r\n" + 
				"              \"price\": 100,\r\n" + 
				"              \"name\": \"美汁源阳光橙\",\r\n" + 
				"              \"id\": \"123457827\",\r\n" + 
				"              \"pic\": \"https://picture.sandload.cn/MeiZhiYuan-YangGuangCheng.png\",\r\n" + 
				"              \"stock\": 0,\r\n" + 
				"              \"dishCode\": \"2430\"\r\n" + 
				"            },\r\n" + 
				"            {\r\n" + 
				"              \"sequence\": 0,\r\n" + 
				"              \"price\": 200,\r\n" + 
				"              \"name\": \"冰醇咖啡\",\r\n" + 
				"              \"id\": \"123470930\",\r\n" + 
				"              \"pic\": \"https://picture.sandload.cn/BingChun-Coffee.png\",\r\n" + 
				"              \"stock\": 0,\r\n" + 
				"              \"dishCode\": \"900491\"\r\n" + 
				"            },\r\n" + 
				"            {\r\n" + 
				"              \"sequence\": 0,\r\n" + 
				"              \"price\": 200,\r\n" + 
				"              \"name\": \"中杯FUZE tea柠檬红茶饮料\",\r\n" + 
				"              \"id\": \"123457765\",\r\n" + 
				"              \"pic\": \"https://picture.sandload.cn/Lemon-HongChawei-Drink-M.png\",\r\n" + 
				"              \"stock\": 0,\r\n" + 
				"              \"dishCode\": \"6098\"\r\n" + 
				"            },\r\n" + 
				"            {\r\n" + 
				"              \"sequence\": 0,\r\n" + 
				"              \"price\": 400,\r\n" + 
				"              \"name\": \"大杯FUZE tea柠檬红茶饮料\",\r\n" + 
				"              \"id\": \"123459479\",\r\n" + 
				"              \"pic\": \"https://picture.sandload.cn/Lemon-HongChawei-Drink-L.png\",\r\n" + 
				"              \"stock\": 0,\r\n" + 
				"              \"dishCode\": \"6099\"\r\n" + 
				"            },\r\n" + 
				"            {\r\n" + 
				"              \"sequence\": 0,\r\n" + 
				"              \"price\": 150,\r\n" + 
				"              \"name\": \"热朱古力\",\r\n" + 
				"              \"id\": \"123458590\",\r\n" + 
				"              \"pic\": \"https://picture.sandload.cn/Hot-ZhuGuLi.png\",\r\n" + 
				"              \"stock\": 0,\r\n" + 
				"              \"dishCode\": \"3605\"\r\n" + 
				"            },\r\n" + 
				"            {\r\n" + 
				"              \"sequence\": 0,\r\n" + 
				"              \"price\": 150,\r\n" + 
				"              \"name\": \"锡兰红茶\",\r\n" + 
				"              \"id\": \"123459895\",\r\n" + 
				"              \"pic\": \"https://picture.sandload.cn/XiLan-RedTea.png\",\r\n" + 
				"              \"stock\": 0,\r\n" + 
				"              \"dishCode\": \"3505\"\r\n" + 
				"            },\r\n" + 
				"            {\r\n" + 
				"              \"sequence\": 0,\r\n" + 
				"              \"price\": 0,\r\n" + 
				"              \"name\": \"小杯鲜煮咖啡\",\r\n" + 
				"              \"id\": \"123459347\",\r\n" + 
				"              \"pic\": \"https://picture.sandload.cn/XianZhu-Coffee-S.png\",\r\n" + 
				"              \"stock\": 0,\r\n" + 
				"              \"dishCode\": \"3518\"\r\n" + 
				"            },\r\n" + 
				"            {\r\n" + 
				"              \"sequence\": 0,\r\n" + 
				"              \"price\": -100,\r\n" + 
				"              \"name\": \"纯牛奶（盒装）\",\r\n" + 
				"              \"id\": \"123460185\",\r\n" + 
				"              \"pic\": \"https://picture.sandload.cn/niunai-hezhuang2.png\",\r\n" + 
				"              \"stock\": 0,\r\n" + 
				"              \"dishCode\": \"3755\"\r\n" + 
				"            }\r\n" + 
				"          ],\r\n" + 
				"          \"remark\": \"3\",\r\n" + 
				"          \"type\": 0\r\n" + 
				"        }\r\n" + 
				"      ]";
		return groupList;
	}
}


