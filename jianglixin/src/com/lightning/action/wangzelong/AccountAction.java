package com.lightning.action.wangzelong;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.lightning.action.base.BaseAction;
import com.lightning.bean.makui.Users;
import com.lightning.bean.wangzelong.Account;
import com.lightning.bean.wangzelong.Bills;
import com.lightning.bean.wangzelong.Cargo;
import com.lightning.bean.yuhaiyang.Indent;
import com.lightning.dao.impl.wangzelong.AccountDaoImpl;
import com.lightning.dao.impl.wangzelong.BillsDaoImpl;
import com.lightning.dao.impl.wangzelong.CargoDaoImpl;
import com.lightning.dao.impl.yuhaiyang.IndentDaoImpl;
import com.lightning.dao.wangzelong.AccountDao;
import com.lightning.dao.wangzelong.BillsDao;
import com.lightning.dao.wangzelong.CargoDao;
import com.lightning.dao.yuhaiyang.IndentDao;
@Namespace("/Account")
public class AccountAction extends BaseAction{
	private Account account;
	private AccountDao accountdao=new AccountDaoImpl();
	private List tabAccount;
	private List rowAccount;
	private Indent indent=new Indent();
	private IndentDao indentdao=new IndentDaoImpl();
	private Cargo cargo=new Cargo();
	private CargoDao cargodao=new CargoDaoImpl();
	private String params;
	private String indent_ids;
	@Action(value="insertAccount")
	public String insertAccount(){
		accountdao.insertAccount(account);//付款后向account表中添加数据
		return null;
	}
	@Action(value="deleteAccount")
	public String deleteAccount() {
		int indent_id=account.getAccount_indent();//删除indent，bills，cargo，表中的的数据
		cargo.setCargo_indent(indent_id);
		indent.setIndent_id(indent_id);
		Bills bills=new Bills();
		bills.setBills_indent(indent_id);
		cargodao.deleteCargo(cargo);
		indentdao.deleteIndent(indent);
		BillsDao billsdao=new BillsDaoImpl();
		billsdao.deleteBills(bills);
		return null;
	}
	@Action(value="insertAccountAgain")
	public String insertAccountAgain() {//添加未付款的账单
		Account account=new Account();
		String[] indents=params.split(",");
		String[] indent_id=indent_ids.split(",");
		for(int i=0;i<indents.length;i++) {
			account.setAccount_money(Float.parseFloat(indents[i]));
			account.setAccount_indent(Integer.parseInt(indent_id[i]));
			accountdao.insertAccount(account);
		}
		print("付款成功");
		return null;
	}
	@Action(value="deleteAccountAgain")
	public String deleteAccountAgain() {//判断是否付款，并根据是否付款，来删除/改变账单
		String[] indents=params.split(",");
		Account deleteAccount=new Account();
		Cargo deletecargo=new Cargo();
		Bills deletebills=new Bills();
		Indent deleteindent=new Indent();
		BillsDao billsdao=new BillsDaoImpl();
		for(int i=0;i<indents.length;i++) {
			deleteAccount.setAccount_indent(Integer.parseInt(indents[i]));
			deletecargo.setCargo_indent(Integer.parseInt(indents[i]));
			deletebills.setBills_indent(Integer.parseInt(indents[i]));
			deleteindent.setIndent_id(Integer.parseInt(indents[i]));
			if(accountdao.findOneAccount(deleteAccount)!=null && accountdao.findOneAccount(deleteAccount).size()>0) {
				billsdao.updateBills(deletebills);
			}else {
				cargodao.deleteCargo(deletecargo);
				indentdao.deleteIndent(deleteindent);
				billsdao.deleteBills(deletebills);
			}
		}
		print("删除成功");
		return null;
	}
	
	
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public AccountDao getAccountdao() {
		return accountdao;
	}

	public void setAccountdao(AccountDao accountdao) {
		this.accountdao = accountdao;
	}

	public List getTabAccount() {
		return tabAccount;
	}

	public void setTabAccount(List tabAccount) {
		this.tabAccount = tabAccount;
	}

	public List getRowAccount() {
		return rowAccount;
	}

	public void setRowAccount(List rowAccount) {
		this.rowAccount = rowAccount;
	}
	public Indent getIndent() {
		return indent;
	}
	public void setIndent(Indent indent) {
		this.indent = indent;
	}
	public IndentDao getIndentdao() {
		return indentdao;
	}
	public void setIndentdao(IndentDao indentdao) {
		this.indentdao = indentdao;
	}
	public Cargo getCargo() {
		return cargo;
	}
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	public CargoDao getCargodao() {
		return cargodao;
	}
	public void setCargodao(CargoDao cargodao) {
		this.cargodao = cargodao;
	}
	public String getParams() {
		return params;
	}
	public void setParams(String params) {
		this.params = params;
	}
	public String getIndent_ids() {
		return indent_ids;
	}
	public void setIndent_ids(String indent_ids) {
		this.indent_ids = indent_ids;
	}
	
}
