package com.lightning.bean.yuhaiyang;

public class Keeper {
	private int keeper_worker;//仓库管理员ID
	private int keeper_warehose;//所属仓库ID
	public int getKeeper_worker() {
		return keeper_worker;
	}
	public void setKeeper_worker(int keeper_worker) {
		this.keeper_worker = keeper_worker;
	}
	public int getKeeper_warehose() {
		return keeper_warehose;
	}
	public void setKeeper_warehose(int keeper_warehose) {
		this.keeper_warehose = keeper_warehose;
	}
	public Keeper(int keeper_worker, int keeper_warehose) {
		super();
		this.keeper_worker = keeper_worker;
		this.keeper_warehose = keeper_warehose;
	}
	public Keeper() {
		super();
	}
	
}
