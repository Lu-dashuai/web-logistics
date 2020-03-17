/**
 * 
 */
package com.lightning.dao.wuminghui;

import java.util.List;

import com.lightning.bean.wuminghui.Cartype;

/**   
*    
* 项目名称：lightning3   
* 类名称：CartypeDao   
* 类描述：   
* 创建人：Administrator   
* 创建时间：2018年1月31日 上午8:33:33   
* @version        
*/
public interface CartypeDao {
	List findCartype();
	List findAllCartype();
	void insertCartype(Cartype cartype);
}
