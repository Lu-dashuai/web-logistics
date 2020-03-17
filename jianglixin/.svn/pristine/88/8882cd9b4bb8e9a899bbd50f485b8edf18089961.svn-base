package com.lightning.dao.impl.makui;

import java.util.List;

import com.lightning.bean.makui.Company;
import com.lightning.dao.base.BaseDao;
import com.lightning.dao.makui.CompanyDao;

public class CompanyDaoImpl implements CompanyDao{
	//查询所有的公司信息
	@Override
	public List findCompany() {
		String sql="select company_name,company_introduce,company_phone from company";
		return BaseDao.query(sql, null);
	}
	//添加一条公司信息
	@Override
	public void insertCompany(Company company) {
		String sql="insert into company values(?,?,?)";
		BaseDao.update(sql, new Object[]{company.getCompany_name(),company.getCompany_introduce(),company.getCompany_phone()});
	}
	//删除一条公司信息
	@Override
	public void deleteCompany(Company company) {
		String sql="delete from company where company_name=?";
		BaseDao.update(sql, new Object[]{company.getCompany_name()});
	}
	//查询一条公司信息
	@Override
	public List findOneCompany(Company company) {
		String sql="select company_name,company_introduce,company_phone from company where company_name=?";
		return BaseDao.query(sql,new Object[]{company.getCompany_name()});
	}
	//修改一条公司信息啥
	@Override
	public void updateCompany(Company company) {
		String sql="update company set company_introduce=?,company_phone=? where company_name=?";
		BaseDao.update(sql, new Object[]{company.getCompany_introduce(),company.getCompany_phone(), company.getCompany_name()});
	}

}
