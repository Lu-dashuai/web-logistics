package com.lightning.dao.base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lightning.dao.factory.ConnectionFactory;

public class BaseDao {
	public static void setParams(PreparedStatement ps,Object[] params) throws SQLException{
		if(params!=null){
			for(int i=0;i<params.length;i++){
				ps.setObject(i+1,params[i]);
			}
		}
	}
	public static int update(String sql,Object[] params){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		int primaryKey=-1;
		try {
			conn = ConnectionFactory.getConn();
			ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			setParams(ps, params);
			ps.executeUpdate();
			rs=ps.getGeneratedKeys();
			while(rs.next()){
				primaryKey=rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionFactory.closeAll(null, ps, conn);
		}
		return primaryKey;
	}
	public static List query(String sql,Object[] params){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		List tab=new ArrayList();
		try {
			conn = ConnectionFactory.getConn();
			ps = conn.prepareStatement(sql);
			setParams(ps, params);
			rs=ps.executeQuery();
			int col=rs.getMetaData().getColumnCount();
			while(rs.next()){
				List row=new ArrayList();
				for(int i=1;i<=col;i++){
					
					row.add(rs.getObject(i));
				}
				tab.add(row);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionFactory.closeAll(rs, ps, conn);
		}
		return tab;
	}
	
	public static List queryMap(String sql,Object[] params){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		List tab=new ArrayList();
		try {
			conn = ConnectionFactory.getConn();
			ps = conn.prepareStatement(sql);
			setParams(ps, params);
			rs=ps.executeQuery();
			int col=rs.getMetaData().getColumnCount();
			while(rs.next()){
				Map map=new HashMap();
				for(int i=1;i<=col;i++){
					map.put(rs.getMetaData().getColumnName(i),rs.getObject(i));
				}
				tab.add(map);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionFactory.closeAll(rs, ps, conn);
		}
		return tab;
	}
}
