package myservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet2")
public class Servlet2 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		response.setContentType("text/html;charset=UTF-8");
		/**
		 * cookie有不可跨名性，localhost域名，拿不到www.wujiaqi.com颁发给浏览器的cookie
		 * 在用www.image.wujiaqi.com域名访问，证明即使一级域名相同，二级域名不同也不能获取到cookie
		 */
		if(cookies.length == 0 || cookies == null){
			response.getWriter().write("获取不到cookie");
			return;
		}else{
			for(int i = 0; i < cookies.length; i++){
				Cookie cookie = cookies[i];
				response.getWriter().write(cookie.getName() +"------" + cookie.getValue() + "\n");
			}
		}
		response.getWriter().write("我的域名是：" + String.valueOf(request.getRequestURL()));
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
}
