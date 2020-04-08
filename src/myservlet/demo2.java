package myservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

@WebServlet(name = "demo2")
public class demo2 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String referer = request.getHeader("Referer");
//		if(referer == null || !referer.contains("localhost:8080/index.jsp")){
//			response.sendRedirect("/index.jsp");
//			return;
//		}
//		response.setContentType("text/html;charset=UTF-8");
//		response.getWriter().write("从首页进来的");
		response.setContentType("text/html;charset=UTF-8");

		//创建Cookie对象，指定名称和值
/*
		Cookie cookie = new Cookie("country", "武汉");
		cookie.setMaxAge(1000);
		//发送Cookie给浏览器是需要设置Cookie的时间的。在给浏览器之前，设置一下Cookie的时间
		//设置Cookie的时间

		//向浏览器给一个Cookie
		response.addCookie(cookie);

		response.getWriter().write("我已经向浏览器发送了一个Cookie");
		//浏览器本身没有任何Cookie
		String username = (String) request.getAttribute(username");
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write(username);*/


		Cookie[] cookies = request.getCookies();
		for (int i = 0; i < cookies.length; i++){
			String name = cookies[i].getName();
			String value = cookies[i].getValue();
			response.getWriter().write(value);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
}
