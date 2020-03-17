package com.lightning.dao.base;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;


public class JSONWang {
	
	private String dateType="yyyy-MM-dd";
	
	/**
	 * 
	 * @param obj 传入的对象
	 * @return 返回格式化后的JSON字符串
	 */
	public String fromObject(Object obj,int storey,String[] excludeFields){
		//obj.getClass().
		//if(storey==-1) return "";
		Field[] fields=obj.getClass().getDeclaredFields();
		StringBuffer sb=new StringBuffer("{");
		SimpleDateFormat sdf=new SimpleDateFormat(dateType);
		String dateStr="";
		for(int i=0;i<fields.length;i++){
			System.out.println(obj.getClass().getName()+"--getName()=="+fields[i].getName());
			if(contains(excludeFields,fields[i].getName())){
				continue;
			}
			try {			
				int typ=flag(obj,fields[i]);
				//fields[i].setAccessible(true);
				sb.append("\"");			
				sb.append(fields[i].getName());
				sb.append("\":");
				
				switch(typ){
				case 0:
					sb.append(fields[i].get(obj));
					break;
				case 1:
					sb.append("\"");					
					sb.append(fields[i].get(obj)==null?"":fields[i].get(obj));
					sb.append("\"");
					break;
				case 2://如果是关联的其他对象
					Object ob=fields[i].get(obj);
					System.out.println(storey+"--ob=="+ob);
					
					if(ob!=null&&storey>0){
						storey--;
						sb.append(fromObject(ob,storey,excludeFields));				
					}else{
						sb.append("{}");//如果是空对象则输出{}
					}
					break;
				case 3://如果是java.util.Date日期对象
					sb.append("\"");
					dateStr=sdf.format(fields[i].get(obj));
					sb.append(dateStr);
					sb.append("\"");
				}
				
				sb.append(",");
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}					
		}
		return sb.substring(0, sb.length()-1)+"}";
		
	}
	
	public String fromCollection(Collection collect,int storey,String[] excludeFields){
		if(collect==null||collect.size()==0){
			return "[]";
		}
		StringBuffer sb=new StringBuffer("[");
		for(Object obj:collect){
			sb.append(fromObject(obj,--storey,excludeFields));
			sb.append(",");			
		}
		sb.replace(sb.length()-1, sb.length(), "]");		
		return sb.toString();		
	}
	/**
	*从表数据的列表中拼接json字符串
	*
	*/
	public String fromList(List<List> list){
		StringBuffer sb=new StringBuffer();
		if(list.size()>0){
			sb.append("[");
			for(List row:list){
				sb.append("[");
				for(Object obj:row){
					sb.append("'");
					sb.append(obj);
					sb.append("'");
					sb.append(",");
				}
				sb.delete( sb.length()-1,sb.length());
				sb.append("],");
			}
			sb.delete( sb.length()-1,sb.length());
			sb.append("]");
			return sb.toString();
		}
		return"[]";
	}
	
	/**
	 * 
	 * @param fieldNames
	 * @param name
	 * @return
	 */
	private boolean contains(String[] fieldNames,String name){
		if(fieldNames==null)return false;
		for(int i=0;i<fieldNames.length;i++){
			if(fieldNames[i].equals(name))
				return true;
		}
		return false;
	}
	
	/**
	 * 判断获得的值是否应该加引号，
	 * @param field
	 * @return 1 应该加；0：数字不应该加；2返回的是Object对象，；3返回的是java.util.Date类型
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	private int flag(Object object,Field field) throws Exception {
		if (field == null )	return 1;
		field.setAccessible(true);
		Object obj= field.get(object);// 获得要转换的数据类型名称
		if(obj==null) return 1;
		String type=obj.getClass().getName();//获得对象类型的名�?
		
		//字符串和日期类型的加引号
		if (type.equals("java.lang.String")
				||type.equals("java.sql.Date")||type.equals("java.sql.Timestamp")
				||type.equals("java.lang.Char")){
			
			return 1;
		}
		//数字型的不用加引号
		if (type.equals("java.lang.Integer")||type.equals("java.lang.Boolean")
				||type.equals("java.lang.Double")||type.equals("java.lang.float")
				||type.equals("java.lang.Short")||type.equals("java.lang.Byte")
				||type.equals("java.lang.Long")||type.equals("java.emth.BigDecimal")){
			
			return 0;
		}
		//util.Date类型的需要转换格�?
		if(type.equals("java.util.Date"))	return 3;
		return 2;//其他的是Object类型
		
				
	}
	
	
	
	public String getDateType() {
		return dateType;
	}

	public void setDateType(String dateType) {
		this.dateType = dateType;
	}

	/*public static void main(String[] ss) throws Exception{
		Booktype type=new Booktype(1,"文艺类","文艺小说散文");
		Book book=new Book(1,type,"红楼梦","曹雪琴",56.8,"好看的书");
		Book book1=new Book(3,type,"西游记","吴承恩",56.8,"好看的书");
		Book book2=new Book(2,type,"三国演义","罗贯中",56.8,"好看的书");
		Book book3=new Book(4,type,"聊斋志异","蒲松龄",56.8,"好看的书");
		List list=new ArrayList();
		list.add(book);
		list.add(book1);
		list.add(book2);
		list.add(book3);
		book.setAuthor(null);
		//System.out.println(JSONObject.fromObject(book));
		JSONWang json=new JSONWang();
		//Field field=type.getClass().getDeclaredField("bookId");
		
		System.out.println("bookjson="+json.fromObject(book,2,new String[]{"books"}));
		System.out.println(json.fromCollection(list,2, new String[]{"books"}));
	}*/

}
