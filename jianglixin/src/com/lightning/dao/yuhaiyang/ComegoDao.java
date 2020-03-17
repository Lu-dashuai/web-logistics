package com.lightning.dao.yuhaiyang;

import java.util.List;

import com.lightning.bean.yuhaiyang.Comego;
import com.lightning.bean.yuhaiyang.Comein;

public interface ComegoDao {
	
	public List findComego();
	public void insertComego(Comego comego);
	public void deleteComngo(Comego comego);
	public void updateComego(Comego comego);
	public List findByIdComego(Comego comego);
	public List findAllComego();
	public void insertCome(Comego comego);
	public void insertComegoCar(Comego comego);
	public List  findComeinIndent(Comego comego);
}
