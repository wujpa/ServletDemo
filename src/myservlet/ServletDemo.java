package myservlet;

import javax.servlet.*;
import java.io.IOException;

public class ServletDemo implements Servlet {

	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		System.out.println("servlet初始化");
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
		System.out.println("我被调用了");
		servletResponse.getWriter().write("helloworld");
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void destroy() {
		System.out.println("我被销毁了");
	}
}
