package com.lightning.dao.makui;

import java.util.List;

import com.lightning.bean.makui.Company;

public interface CompanyDao {
	public List findCompany();
	public void insertCompany(Company company);
	public void deleteCompany(Company company);
	public List findOneCompany(Company company);
	public void updateCompany(Company company);
}
