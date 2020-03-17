package com.lightning.action.wangjia;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.alibaba.fastjson.JSON;
import com.lightning.action.base.BaseAction;
import com.lightning.bean.wangjia.Allow;
import com.lightning.bean.wangjia.Post;
import com.lightning.bean.wangjia.Role;
import com.lightning.dao.base.JSONWang;
import com.lightning.dao.impl.wangjia.AllowDaoImpl;
import com.lightning.dao.impl.wangjia.PostDaoImpl;
import com.lightning.dao.impl.wangjia.RoleDaoImpl;
import com.lightning.dao.wangjia.AllowDao;
import com.lightning.dao.wangjia.PostDao;
import com.lightning.dao.wangjia.RoleDao;

@Namespace("/Post")
public class PostAction extends BaseAction{
	private Post post;
	private List tabPost;
	private List rowPost;
	private PostDao postdao=new PostDaoImpl();
	private AllowDao allowdao=new AllowDaoImpl();
	private Allow allow=new Allow();
	
	private Role role=new Role();
	private RoleDao roledao=new RoleDaoImpl();
	
	@Action(value="insertPost")
	public String insertPost(){
		postdao.insertPost(post);
		print("ok");
		return null;
	}
	
	@Action(value="findOnePost",results= {@Result(name="updatePost",location="/before/wangjia/updatePost.jsp")})
	public String findOnePost() {
		tabPost=postdao.findOnePost(post);
		rowPost=(List) tabPost.get(0);
		return "updatePost";
	}
	
	@Action(value="updatePost",results= {@Result(location="/before/wangjia/showPost.jsp")})
	public String updatePost() {
		postdao.updatePost(post);
		return findShowPost();
	}
	
	@Action(value="findPost")
	public String findPost(){
		List<List> tabPost=postdao.findPost();
		print(JSON.toJSONString(tabPost));
		//System.out.println(JSON.toJSONString(tabPost));
		return null;
	}
	
	@Action(value="findAllPost")
	public String findAllPost() {
		tabPost = postdao.findPost();
		String jsonStr=JSON.toJSONString(tabPost);
		print(jsonStr);
		return null;
		
	}
	
//	@Action(value="deletePost")
//	public String deletePost() {
//		postdao.deletePost(post);
//		String jsonStr=JSON.toJSONString(tabPost);
//		print(jsonStr);
//		return null;
//	}
	
	@Action(value="deletePost",results= {@Result(location="/before/wangjia/showPost.jsp")})
	public String deletePost() {
//		System.out.println(post.getPost_id());
		postdao.deletePost(post);
		allow.setAllow_post(post.getPost_id());
		allowdao.deleteAllow(allow);
		role.setRole_post(post.getPost_id());
		roledao.deleteRole(role);
		return findShowPost();
	}
	
	
	//http://localhost:8080/lightning3/Post/findShowPost.action
	@Action(value="findShowPost",results= {@Result(location="/before/wangjia/showPost.jsp")})
	public String findShowPost() {
		tabPost=postdao.findShowPost();
		return "success";
	}
	
	public Post getPost() {
		return post;
	}

	public List getTabPost() {
		return tabPost;
	}

	public void setTabPost(List tabPost) {
		this.tabPost = tabPost;
	}

	public List getRowPost() {
		return rowPost;
	}

	public void setRowPost(List rowPost) {
		this.rowPost = rowPost;
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

	public AllowDao getAllowdao() {
		return allowdao;
	}

	public void setAllowdao(AllowDao allowdao) {
		this.allowdao = allowdao;
	}

	public Allow getAllow() {
		return allow;
	}

	public void setAllow(Allow allow) {
		this.allow = allow;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public RoleDao getRoledao() {
		return roledao;
	}

	public void setRoledao(RoleDao roledao) {
		this.roledao = roledao;
	}
	
}
