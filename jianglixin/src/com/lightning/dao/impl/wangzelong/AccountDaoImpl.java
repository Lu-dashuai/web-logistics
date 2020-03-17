package com.lightning.dao.impl.wangzelong;

import java.util.List;

import com.lightning.bean.wangzelong.Account;
import com.lightning.dao.base.BaseDao;
import com.lightning.dao.wangzelong.AccountDao;

public class AccountDaoImpl implements AccountDao{

	@Override
	public List findAccount() {
		// 查询account表的所有信息
		String sql="select account_money from account";
		return BaseDao.query(sql, null);
	}

	@Override
	public List findOneAccount(Account account) {
		// 查询account表的单条信息
		String sql="select account_money from account where account_indent=?";
		return BaseDao.query(sql, new Object[] {account.getAccount_indent()});
	}

	@Override
	public void insertAccount(Account account) {
		//添加account表的单一信息
		String sql="insert into account values(?,?)";
		BaseDao.update(sql, new Object[]{account.getAccount_indent(),account.getAccount_money()});
	}

}
