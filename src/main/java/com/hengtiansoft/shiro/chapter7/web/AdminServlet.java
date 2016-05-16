package com.hengtiansoft.shiro.chapter7.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

@WebServlet(name = "loginServlet", urlPatterns = "/login")
public class AdminServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("===========doGet=========URI:"+request.getRequestURI());
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,
				response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String error = null;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("username:"+username+"         password:"+password);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username,
				password);
		try {
			subject.login(token);
		} catch (UnknownAccountException e) {
			error = "用户名/密码错误";
		} catch (IncorrectCredentialsException e) {
			error = "用户名/密码错误";
		} catch (AuthenticationException e) {
			// 其他错误，比如锁定，如果想单独处理请单独catch 处理
			error = "其他错误：" + e.getMessage();
		}
		
		if (error!=null) {//出错了，返回登录页面
			request.setAttribute("error", error);
			request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		}else {
			//登录成功
			request.getRequestDispatcher("/WEB-INF/jsp/loginSuccess.jsp").forward(request, response);
		}
	}

}
