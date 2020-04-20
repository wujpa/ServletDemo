package com.servlet;

import com.longrise.DBUser;
import com.longrise.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "servletdemo4")
public class servletdemo4 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		String value = (String) session.getAttribute("name");
//		System.out.println(session.getMaxInactiveInterval());
//		System.out.println(value);
		HttpSession session = request.getSession();
		if(session.getAttribute("user") != null){
			response.sendRedirect(response.encodeURL("/index.jsp"));
			return;
		}
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Users user = DBUser.find(username,password);
		if(user == null){
			response.getWriter().write("you can't login");
			return;
		}


		session.setAttribute("user",user);
		Cookie cookie = new Cookie("JSESSIONID",session.getId());//添加session的id，在浏览器关闭后还能获取到session
		cookie.setMaxAge(10000);
		response.addCookie(cookie);
		response.sendRedirect(response.encodeURL("/index.jsp"));
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
}
