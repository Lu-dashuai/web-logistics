package com.lightning.dao.wangzelong;

import java.util.List;

import com.lightning.bean.wangzelong.Account;

public interface AccountDao {
	//account类的接口
	List findAccount();
	List findOneAccount(Account account);
	void insertAccount(Account account);
}
