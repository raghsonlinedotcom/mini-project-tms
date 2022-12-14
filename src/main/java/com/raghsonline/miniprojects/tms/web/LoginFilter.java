package com.raghsonline.miniprojects.tms.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.raghsonline.miniprojects.tms.util.StringUtil;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(
		description = "A filter to determine the user in session", 
		urlPatterns = {  
				"/*"
		})
public class LoginFilter implements Filter 
{

	Logger logger = Logger.getLogger(LoginFilter.class);
	
	List<String> dataList = List.of(
			".css", "login", "Login",
			"Logout", "create", "Create"
		);
	
    /**
     * Default constructor. 
     */
    public LoginFilter() 
    {
        logger.info("LoginFilter() - invoked");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() 
	{
		logger.info("destroy() method invoked");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException 
	{
		logger.info("doFilter() - invoked");
		
		HttpServletRequest httpRequest = 
				(HttpServletRequest) request;
		
		HttpServletResponse httpResponse = 
				(HttpServletResponse) response;
		
		String pathInfo = httpRequest.getPathInfo();
		String query = httpRequest.getQueryString();
		String url = String.valueOf(httpRequest.getRequestURL());
		String uri = httpRequest.getRequestURI();
		
		logger.info("pathInfo : [" + pathInfo + "]");
		logger.info("query : [" + query + "]");
		logger.info("url : [" + url + "]");
		logger.info("uri : [" + uri + "]");
		logger.info("dataList : " + dataList);
		
		boolean isPresent = StringUtil.isPresent(uri, dataList);
		logger.info("uri matches with the dataList ? " + isPresent);
		
		if(isPresent)
		{
			logger.info("uri ends with .css or contains (c)Create/(l)Logout.. proceeding");
			
			// pass the request along the filter chain
			chain.doFilter(request, response);
			
			return;
		}
		
		Object obj = httpRequest.getSession().getAttribute("employeeBO");
		
		Object flagObj = httpRequest.getServletContext().getAttribute("userAvailable");
		boolean userAvailable = null!=flagObj ? Boolean.valueOf(String.valueOf(flagObj)) : false;
		logger.info("ServletContext - userAvailable ? " + userAvailable);
		
		if(null==obj) 
		{
			if(userAvailable) 
			{
				httpRequest.setAttribute("errorMessage", "Your session has expired. Please login");
			}
			System.err.println("User Object is NOT in session, redirecting to Login Page");
			logger.error("User Object is NOT in session, redirecting to Login Page");
			httpRequest.getRequestDispatcher("/login.jsp")
						.forward(httpRequest, httpResponse);
			return;
		} 
		else 
		{			
			logger.info("EmployeeBO is present in the Session : " + obj);
			
			logger.info("Proceeding with the rest of the filters if any in the chain");
			
			// pass the request along the filter chain
			chain.doFilter(request, response);	
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) 
			throws ServletException 
	{
		System.err.println("init() - invoked, fConfig : "+ fConfig);
	}

}
