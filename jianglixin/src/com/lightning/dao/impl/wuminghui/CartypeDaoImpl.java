package com.lightning.dao.impl.wuminghui;

import java.util.List;

import com.lightning.bean.wuminghui.Cartype;
import com.lightning.dao.base.BaseDao;
import com.lightning.dao.wuminghui.CartypeDao;

/**   
*    
* 项目名称：lightning3   
* 类名称：CartypeDaoImpl   
* 类描述：   
* 创建人：Administrator   
* 创建时间：2018年1月31日 上午8:30:07   
* @version        
*/
public class CartypeDaoImpl implements CartypeDao{

	/* (non-Javadoc)
	 * @see com.lightning.dao.wuminghui.CartypeDao#findCartype()
	 * 查询全表
	 */
	@Override
	public List findCartype() {
		String sql="select cartype_id,cartype_name from cartype";
		return BaseDao.query(sql, null);
	}

	/* (non-Javadoc)
	 * @see com.lightning.dao.wuminghui.CartypeDao#insertCartype(com.lightning.bean.wuminghui.Cartype)
	 * 增加一种车型
	 */
	@Override
	public void insertCartype(Cartype cartype) {
		String sql="insert into cartype(cartype_id,cartype_name) values(?,?)";
		BaseDao.update(sql, new Object[]{cartype.getCartype_id(),cartype.getCartype_name()});
	}

	/* (non-Javadoc)
	 * @see com.lightning.dao.wuminghui.CartypeDao#findAllCartype()
	 */
	@Override
	public List findAllCartype() {
		String sql="select cartype_id,cartype_name from cartype";
		return BaseDao.query(sql, null);
	}
	
}
