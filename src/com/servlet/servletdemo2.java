package com.servlet;

import com.longrise.Book;
import com.longrise.DB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "servletdemo2")
public class servletdemo2 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String id = request.getParameter("id");
		Book book = (Book) DB.getAll().get(id);
		PrintWriter printWriter = response.getWriter();
		Cookie[] cookies = request.getCookies();
		if(cookies.length == 0){
			Cookie cookie = new Cookie("bookhistory",book.getName());
			cookie.setMaxAge(1000);
			response.addCookie(cookie);
		}else{
			int b = 0;
			for(int i = 0; i < cookies.length; i++){
				if(cookies[i].getName().equals("bookhistory")){
					b = 1;
					if(cookies[i].getValue().isEmpty()){
						Cookie cookie = new Cookie("bookhistory",book.getName());
						response.addCookie(cookie);
					}else {
						cookies[i].setValue(cookies[i].getValue() + "_" + book.getName());
						response.addCookie(cookies[i]);
					}
				}
			}
			if(b == 0){
				Cookie cookie = new Cookie("bookhistory",book.getName());
				cookie.setMaxAge(1000);
				response.addCookie(cookie);
			}
		}

		printWriter.write("书籍的编号："+book.getId() + "<br>");
		printWriter.write("书的名称："+book.getName() + "<br>");
		printWriter.write("书的作者："+book.getAuthor() + "<br>");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
}
