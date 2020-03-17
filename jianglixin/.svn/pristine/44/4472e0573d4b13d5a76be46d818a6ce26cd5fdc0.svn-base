package com.lightning.dao.impl.wangjia;

import java.util.List;

import com.lightning.bean.wangjia.Post;
import com.lightning.dao.base.BaseDao;
import com.lightning.dao.wangjia.PostDao;

public class PostDaoImpl implements PostDao{

	//添加职位---
	@Override
	public int insertPost(Post post) {
		String sql="insert into Post(post_id,post_name) values(?,?)";
		return BaseDao.update(sql, new Object[]{post.getPost_id(),post.getPost_name()});
		
	}

	//删除职位
	@Override
	public int deletePost(Post post) {
		int count=0;
		String delworker="select worker_post from worker left join role on role_worker=worker_id left join post on role_post=post_id where post_id=?";
		List<List> workerpostList=BaseDao.query(delworker, new Object[] {post.getPost_id()});
		for(List row:workerpostList) {
			for(Object obj : row) {
				if(obj.equals(post.getPost_id())) {
					count++;
					
				}
			}
		}
		if(count==0) {
			
			String sql="delete from post where post_id=?";
			return BaseDao.update(sql, new Object[] {post.getPost_id()});
		}else {
			System.out.println(count);
			return count;
		}
	}
	
	//修改职位
	@Override
	public void updatePost(Post post) {
		String sql="update post set post_name=? where post_id=?";
		BaseDao.update(sql, new Object[] {post.getPost_name(),post.getPost_id()});
	}
	//查询一条
	@Override
	public List findOnePost(Post post) {
		String sql="select * from post where post_id=?";
		return BaseDao.query(sql, new Object[] {post.getPost_id()});
	}
	
	//查询所有
	@Override
	public List findPost() {
		String sql="select post_id,post_name from post";
		return BaseDao.queryMap(sql, null);
	}

	public List findShowPost() {
		String sql="select post_id,post_name from post";
		return BaseDao.query(sql, null);
	}
}
