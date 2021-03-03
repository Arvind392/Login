

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


 
@WebFilter("/Login")
public class MyFilter implements Filter {

 


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req =((HttpServletRequest)(request));
	String cid=	request.getParameter("cid");
	String password=request.getParameter("password");
	if(cid!=null && password.length()>=5)
	{
		chain.doFilter(request, response);
	}
			
	else
	{
		HttpServletResponse res=((HttpServletResponse)(response));
		res.sendRedirect("LoginFailed.jsp");
		
	}

		
	}


}
