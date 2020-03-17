package com.lightning.action.base;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {
	public String target;
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public Map getRequest(){
		return  (Map) ActionContext.getContext().get("request");
	}
	public Map<String,Object> getSession(){
		return ActionContext.getContext().getSession();
	}
	public Map getAppliction(){
		return ActionContext.getContext().getApplication();
	}
	public HttpServletResponse getResponse(){
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		return response;
	}
	public void print(String content){
		HttpServletResponse resp=getResponse();
		PrintWriter out=null;
		try {
			out=resp.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print(content);
		out.flush();
		out.close();
	}
}
