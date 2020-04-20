package filter;


import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("过滤器初始化");
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		//设置编码为UTF-8
		servletRequest.setCharacterEncoding("utf-8");
		servletResponse.setContentType("text/html;charest=utf-8");
		filterChain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void destroy() {
		System.out.println("过滤器销毁");
	}
}
