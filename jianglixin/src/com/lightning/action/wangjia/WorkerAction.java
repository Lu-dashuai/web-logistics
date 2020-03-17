package com.lightning.action.wangjia;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.alibaba.fastjson.JSON;
import com.lightning.action.base.BaseAction;
import com.lightning.bean.wangjia.Post;
import com.lightning.bean.wangjia.Role;
import com.lightning.bean.wangjia.Status;
import com.lightning.bean.wangjia.Worker;
import com.lightning.dao.base.JSONWang;
import com.lightning.dao.impl.wangjia.PostDaoImpl;
import com.lightning.dao.impl.wangjia.RoleDaoImpl;
import com.lightning.dao.impl.wangjia.StatusDaoImpl;
import com.lightning.dao.impl.wangjia.WorkerDaoImpl;
import com.lightning.dao.wangjia.PostDao;
import com.lightning.dao.wangjia.RoleDao;
import com.lightning.dao.wangjia.StatusDao;
import com.lightning.dao.wangjia.WorkerDao;

@Namespace("/Worker")
public class WorkerAction extends BaseAction{
	private Worker worker;
	private List tabWorker;
	private List rowWorker;
	private WorkerDao workerdao=new WorkerDaoImpl();
	
	//--
	private int workerid;
	//--
	
	private Role role=new Role();
	private RoleDao roledao=new RoleDaoImpl();
	
	private Post post;
	private PostDao postdao=new PostDaoImpl();
	
	@Action(value="insertWorker",results= {@Result(location="/before/wangjia/showWorker.jsp")})
	public String insertWorker(){
		workerdao.insertWoker(worker);
		//print("ok");
		role.setRole_worker(worker.getWorker_id());
		role.setRole_post(worker.getWorker_post());
		roledao.insertRole(role);	
		return "success";
	}
	
	@Action(value="deleteWorker")
	public String deleteWorker() {
		workerdao.deleteWorker(worker);
		return findWorker();	
	}
	
	@Action(value="findOneWorker",results= {@Result(name="updateWorker",location="/before/wangjia/updateWorker.jsp")})
	public String findOneWorker() {
		tabWorker=workerdao.findOneWorker(worker);
		rowWorker=(List) tabWorker.get(0);
		//System.out.println(rowWorker);
		return "updateWorker";
	}
	
	@Action(value="updateWorker",results={@Result(location="/before/wangjia/showWorker.jsp")})
	public String updateWorker() {
		workerdao.updateWorker(worker);
		role.setRole_worker(worker.getWorker_id());
		role.setRole_post(worker.getWorker_post());
		roledao.updateRole(role);
		return "success";
	}
	
	@Action(value="findAllWorker")
	public String findALlworker() {
		tabWorker = workerdao.findWorker();
		String jsonStr=JSON.toJSONString(tabWorker);
		print(jsonStr);
		return null;
	}
	
	@Action(value="findWorker",results={@Result(location="http://localhost:8080/lightning3/later/wangjia/index.jsp")})
	public String findWorker() {
		tabWorker=workerdao.findWorker();
		return "success";
	}
	
	
	//---------------登录验证--------------------
	@Action(value="workerlogin",results= {@Result(name="success",type="redirect",location="/${target}")})
	public String workerlogin() {
		if(workerdao.frontlogin(worker)) {
			target="later/wangjia/index.jsp";
			List<List> tab = new ArrayList();
			tab=workerdao.findOneWorker(worker);
			for(List row:tab) {
				worker.setWorker_name(row.get(2).toString());
				worker.setWorker_idcard(row.get(3).toString());
				worker.setWorker_sex(Integer.parseInt((row.get(4).toString())));
				worker.setWorker_phone(Long.parseLong(row.get(5).toString()));
				worker.setWorker_post(Integer.parseInt(row.get(6).toString()));
				worker.setWorker_station(Integer.parseInt(row.get(7).toString()));
				worker.setWorker_status(Integer.parseInt(row.get(8).toString()));
			}
			getSession().put("worker", worker);
			//在此处判断他的职位  跳转不同的 页面
			return "success";
		}else {
			target="later/wangjia/laterdenglu/index.jsp";//输入错误转到登录页面
			return "success";
		}	
	}
	
	//-------------验证权限---------------------
	@Action(value="checkquanxian")
	public String checkquanxian() {
		List<List> quanxianList=workerdao.checkeddenglu(worker);
		String jsonStr=JSON.toJSONString(quanxianList);
		print(jsonStr);
		return null;
	}
	
	//---------------登录验证--------------------
	@Action(value="checkWorker")
	public String checkWorker() {
		boolean flag=true;
		List list=workerdao.selectWorker(worker);
		if(list!=null&&list.size()>0) {
			flag=false;
		}
		print(flag+"");
		return null;	
	}
	
	
	
	
	public Worker getWorker() {
		return worker;
	}

	public void setWorker(Worker worker) {
		this.worker = worker;
	}

	public List getTabWorker() {
		return tabWorker;
	}

	public void setTabWorker(List tabWorker) {
		this.tabWorker = tabWorker;
	}

	public List getRowWorker() {
		return rowWorker;
	}

	public void setRowWorker(List rowWorker) {
		this.rowWorker = rowWorker;
	}

	public WorkerDao getWorkerdao() {
		return workerdao;
	}

	public void setWorkerdao(WorkerDao workerdao) {
		this.workerdao = workerdao;
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
	
}
