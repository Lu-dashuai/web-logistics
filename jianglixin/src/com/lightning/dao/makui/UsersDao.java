package com.lightning.dao.makui;

import java.util.List;
import com.lightning.bean.makui.Users;
public interface UsersDao {
	public List findUsers();
	public void insertUsers(Users users);
	public void deleteUsers(Users users);
	public List findOneUsers(Users users);
	public void updateUsers(Users users);
	public boolean frontlogin(Users users);
	public void updatepass(String pass,String users_id) ;
	public List insertIndent(int indentid);
	public List selectUsers(Users users);
}
