package com.lightning.bean.wangjia;

public class Worker {
	private int worker_id;//员工编号
	private int worker_password;//员工密码
	private String worker_name;//员工名字
	private String worker_idcard;//员工身份证
	private int worker_sex;//性别
	private long worker_phone;//手机号
	private int worker_post;//职位员工表外联
	private int worker_station;//所属网点
	private int worker_status;//员工状态
	
	
	public int getWorker_id() {
		return worker_id;
	}
	public void setWorker_id(int worker_id) {
		this.worker_id = worker_id;
	}
	public int getWorker_password() {
		return worker_password;
	}
	public void setWorker_password(int worker_password) {
		this.worker_password = worker_password;
	}
	public String getWorker_name() {
		return worker_name;
	}
	public void setWorker_name(String worker_name) {
		this.worker_name = worker_name;
	}
	public String getWorker_idcard() {
		return worker_idcard;
	}
	public void setWorker_idcard(String worker_idcard) {
		this.worker_idcard = worker_idcard;
	}
	public int getWorker_sex() {
		return worker_sex;
	}
	public void setWorker_sex(int worker_sex) {
		this.worker_sex = worker_sex;
	}
	public long getWorker_phone() {
		return worker_phone;
	}
	public void setWorker_phone(long worker_phone) {
		this.worker_phone = worker_phone;
	}
	public int getWorker_post() {
		return worker_post;
	}
	public void setWorker_post(int worker_post) {
		this.worker_post = worker_post;
	}
	public int getWorker_station() {
		return worker_station;
	}
	public void setWorker_station(int worker_station) {
		this.worker_station = worker_station;
	}
	public int getWorker_status() {
		return worker_status;
	}
	public void setWorker_status(int worker_status) {
		this.worker_status = worker_status;
	}
	public Worker() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Worker(int worker_id, int worker_password, String worker_name,
			String worker_idcard, int worker_sex, long worker_phone,
			int worker_post, int worker_station, int worker_status) {
		super();
		this.worker_id = worker_id;
		this.worker_password = worker_password;
		this.worker_name = worker_name;
		this.worker_idcard = worker_idcard;
		this.worker_sex = worker_sex;
		this.worker_phone = worker_phone;
		this.worker_post = worker_post;
		this.worker_station = worker_station;
		this.worker_status = worker_status;
	}
	public Worker(int worker_password, String worker_name,
			String worker_idcard, int worker_sex, long worker_phone,
			int worker_post, int worker_station, int worker_status) {
		super();
		this.worker_password = worker_password;
		this.worker_name = worker_name;
		this.worker_idcard = worker_idcard;
		this.worker_sex = worker_sex;
		this.worker_phone = worker_phone;
		this.worker_post = worker_post;
		this.worker_station = worker_station;
		this.worker_status = worker_status;
	}
	
}
