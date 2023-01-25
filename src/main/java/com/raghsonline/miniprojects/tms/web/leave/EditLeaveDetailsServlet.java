package com.raghsonline.miniprojects.tms.web.leave;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.raghsonline.miniprojects.tms.bo.LeaveDetailBO;
import com.raghsonline.miniprojects.tms.dao.LeaveDetailsDAO;
import com.raghsonline.miniprojects.tms.dao.LeaveDetailsDAOImpl;
import com.raghsonline.miniprojects.tms.util.AppUtil;

/**
 * Servlet implementation class EditLeaveDetailsServlet
 */
@WebServlet({ "/EditLeaveDetailsServlet", "/EditLeave" })

public class EditLeaveDetailsServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	Logger logger = Logger.getLogger(this.getClass());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditLeaveDetailsServlet()
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException,
	IOException 
	{
		logger.info("EditLeaveDetailsServlet - doGet() invoked");
		
		int id = 0;
		String idStr = request.getParameter("id");
		
		if(null!=idStr && idStr.trim().length()>0)
		{
			id = Integer.parseInt(idStr);
		}
		
		LeaveDetailBO leaveDetailBO = (LeaveDetailBO)request.getAttribute("leaveDetailBO");
		LeaveDetailsDAO leaveDetailsDAO  = new LeaveDetailsDAOImpl();
		
		try 
		{
			leaveDetailBO = leaveDetailsDAO.getLeaveDetailsById(id);
		} 
		catch (Exception exception) 
		{
			logger.error("Exception occurred while reading the data from the Database Table");
			logger.error("Message : " + exception.getMessage());
			
			if (AppUtil.isAppDevMode) 
			{
				exception.printStackTrace();
			}
		}
		logger.info("LeaveDetailBO object from the database is " + leaveDetailBO);
		request.setAttribute("leaveDetailBO", leaveDetailBO);
		request.getRequestDispatcher("/member/leave/editleave.jsp").forward(request, response);
	}
}