package com.lightning.action.wangjia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;

import com.alibaba.fastjson.JSON;
import com.lightning.action.base.BaseAction;
import com.lightning.bean.wangjia.Allow;
import com.lightning.bean.wangjia.Post;
import com.lightning.bean.wangjia.Power;
import com.lightning.bean.wangjia.Worker;
import com.lightning.dao.impl.wangjia.AllowDaoImpl;
import com.lightning.dao.impl.wangjia.PostDaoImpl;
import com.lightning.dao.impl.wangjia.PowerDaoImpl;
import com.lightning.dao.wangjia.AllowDao;
import com.lightning.dao.wangjia.PostDao;
import com.lightning.dao.wangjia.PowerDao;
@Namespace("/Admin")
public class AdminAction extends BaseAction{
	private Post post=new Post();
	private PostDao postdao=new PostDaoImpl();
	private Power power=new Power();
	private PowerDao powerdao=new PowerDaoImpl();
	private Allow allow=new Allow();
	private AllowDao allowdao=new AllowDaoImpl();
	private String params;
	@Action(value="showPost")
	public String showPost() {
		print(JSON.toJSONString(postdao.findPost()));
		return null;
	}
	@Action(value="showPower")
	public String showPower() {
		List tabPower=powerdao.findPower();
		List tab=new ArrayList();
		for(int i=0;i<tabPower.size();i++) {
			Map map=new HashMap();
			map=(Map) tabPower.get(i);
			map.put("parentId",map.get("power_parent"));
			tab.add(map);
		}
		print(JSON.toJSONString(tab));
		return null;
	}
	@Action(value="allotAllow")
	public String allotAllow() {
		String[] posts=params.split(",");
		allow.setAllow_post(Integer.parseInt(posts[0]));
		allowdao.deleteAllow(allow);
		for(int i=1;i<posts.length;i++) {
			allow.setAllow_power(Integer.parseInt(posts[i]));
			allowdao.insertAllow(allow);
		}
		print("分配成功");
		return null;
	}
	@Action(value="getAllPower")
	public String getAllPower() {
		allow.setAllow_post(post.getPost_id());
		print(JSON.toJSONString(allowdao.findOneAllow(allow)));
		return null;
	}
	@Action(value="showHavePower")
	public String showHavePower() {
		Worker worker=null;
		worker= (Worker) getSession().get("worker");
		if(worker!=null) {
			print(JSON.toJSONString(powerdao.findWorkerPower(worker.getWorker_id())));
		}
		return null;
	}
	
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public PostDao getPostdao() {
		return postdao;
	}
	public void setPostdao(PostDao postdao) {
		this.postdao = postdao;
	}
	public Power getPower() {
		return power;
	}
	public void setPower(Power power) {
		this.power = power;
	}
	public PowerDao getPowerdao() {
		return powerdao;
	}
	public void setPowerdao(PowerDao powerdao) {
		this.powerdao = powerdao;
	}
	public Allow getAllow() {
		return allow;
	}
	public void setAllow(Allow allow) {
		this.allow = allow;
	}
	public AllowDao getAllowdao() {
		return allowdao;
	}
	public void setAllowdao(AllowDao allowdao) {
		this.allowdao = allowdao;
	}
	public String getParams() {
		return params;
	}
	public void setParams(String params) {
		this.params = params;
	}
	
}
