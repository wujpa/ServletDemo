package myservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet1")
public class Servlet1 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 现在我希望一级域名相同的网页Cookie之间可以相互访问。也就是说www.image.wujiaqi.com
		 * 可以获取到www.wujiaqi.com的Cookie就需要使用到domain方法。
		 */
		Cookie cookie = new Cookie("dsdsds","哈哈");
		cookie.setPath("/Servlet2");//Cookie的path属性决定允许访问Cookie的路径,只有/Servlet2的才能访问这个cookie
//		cookie.setDomain("wujiaqi.com");
		cookie.setMaxAge(1000);
		response.addCookie(cookie);
		response.setContentType("text/html;charset=utf-8");
//		response.getWriter().write("www.wujiaqi.com这个域名添加一个cookie");
		response.getWriter().write("为Servlet2这个路径添加一个cookie");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
}
