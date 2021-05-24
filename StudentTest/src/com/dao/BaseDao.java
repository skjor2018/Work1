package com.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;
import com.util.DbUtil;
//dao
public class BaseDao {
	private DbUtil dbUtil =new DbUtil(); 
	//关闭数据库
		public void closeCon() {
			dbUtil.closeCon();
		}
		public ResultSet query(String sql){
			try {
				PreparedStatement prepareStatement = dbUtil.getConnection().prepareStatement(sql);
				return prepareStatement.executeQuery();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		} 
	}


