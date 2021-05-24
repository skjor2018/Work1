package com.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AdminDao;
import com.model.Admin;

public class LoginServlet extends HttpServlet {

	/**
	 * 登陆》LoginServlet
	 */
	private static final long serialVersionUID = 1L;
	
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String name = request.getParameter("account");
		String password = request.getParameter("password");
		int type = Integer.parseInt(request.getParameter("type"));
		//?  
		response.getWriter().write("loginSuccess");
		
		//对比用户名和密码正确
		AdminDao adminDao = new AdminDao();
		Admin admin = adminDao.login(name, password);
		adminDao.closeCon();
		if(admin == null){
			response.getWriter().write("loginError");
			return;
		}
	}
}

