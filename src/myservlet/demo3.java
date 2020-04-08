package myservlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "demo3")
public class demo3 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		ServletContext servletContext = this.getServletContext();
//		String ts = servletContext.getInitParameter("name");
//		String value = (String) servletContext.getAttribute("myname");
//		System.out.println(value);
//		System.out.println(ts);
//		//获取到ServletContext对象
//
//		//调用ServletContext方法获取到读取文件的流
//		InputStream inputStream = servletContext.getResourceAsStream("image/1.jpg");
//		response.getWriter().write(String.valueOf(inputStream));

		//获取到requestDispatcher对象，跳转到index.jsp
		request.setAttribute("username","吴佳琦");
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/demo2");

		//调用requestDispatcher对象的forward()实现转发，传入request,response
		requestDispatcher.forward(request,response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
}
