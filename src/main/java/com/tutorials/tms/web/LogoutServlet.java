package com.tutorials.tms.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet({ "/LogoutServlet", "/Logout" })
public class LogoutServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	Logger logger = Logger.getLogger(LogoutServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		logger.info("LogoutServlet - doGet() invoked!");
		
		// ---------------------------------------------
		// We need to remove all the elements present in the session.
		// Two ways we can do this.
		// 1. We can call session.removeAttribute() by supplying the key of the 
		//    elements you had bound it in the Session
		//     ... But it would be tedious if you have bound many more elements
		
		// 2. Other best alternate and a simple way is to invalidate the session
		//    session.invalidate() - will take care of wiping off every element
		//     bound in the session, all at once. 
		// ---------------------------------------------
		request.getSession().invalidate();
		
		// Redirect the user to the login.jsp page with a message
		String message = "You have been logged out from the System";
		
		String url = "login.jsp";
		
		request.setAttribute("message", message);
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
