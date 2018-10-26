package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@WebFilter("/*")
public class AuthenticationFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest)arg0;
	    if(request.getRequestURI().startsWith("/COMP3095_CRAP/login_Servlet") ||
	    		          request.getRequestURI().startsWith("/COMP3095_CRAP/dashboard.jsp")) {
	    HttpSession session = request.getSession();
	    if(session.getAttribute("username")==null) {
	    	request.getRequestDispatcher("login.jsp").forward(request, arg1);
	    }
	    }
	    
	    arg2.doFilter(request, arg1);
	    
	    // post.processing
	}

	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
