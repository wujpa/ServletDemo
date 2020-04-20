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
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "servletdemo1")
public class servletdemo1 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter printWriter = response.getWriter();

		printWriter.write("网页上所有的数籍：" + "<br>");
		LinkedHashMap<String, Book> linkedHashMap = DB.getAll();
		Set<Map.Entry<String, Book>> entry = linkedHashMap.entrySet();
		for (Map.Entry<String,Book> books : entry){
			Book book = books.getValue();
			printWriter.write("<a href='/servlet/servletdemo2?id="+book.getId() + "'target='_blank'>"  + book.getName() +"</a>"+ "<br>");
		}

		Cookie[] cookies = request.getCookies();
		request.getParameter("name");
		if(cookies.length == 0){
			Cookie cookie = new Cookie("bookhistory",null);
			cookie.setMaxAge(1000);
			response.addCookie(cookie);
		}else{
			int b = 0;
			for(int i = 0; i < cookies.length; i++){
				if(cookies[i].getName().equals("bookhistory")){
					if(cookies[i].getValue() != null){
						printWriter.write("你曾经浏览过的书籍：" + "<br>");
						String[] name = cookies[i].getValue().split("_");
						for (int j = 0; j < name.length; j++){
							printWriter.write(name[j] + "<br>");
						}
					}
					b = 1;
				}
			}
			if(b == 0){
				Cookie cookie = new Cookie("bookhistory",null);
				cookie.setMaxAge(1000);
				response.addCookie(cookie);
			}
		}
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
