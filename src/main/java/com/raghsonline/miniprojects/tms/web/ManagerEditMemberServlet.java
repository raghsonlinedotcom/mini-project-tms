package com.raghsonline.miniprojects.tms.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.raghsonline.miniprojects.tms.bo.EmployeeBO;
import com.raghsonline.miniprojects.tms.dao.EmployeeDAO;
import com.raghsonline.miniprojects.tms.dao.EmployeeDAOImpl;
import com.raghsonline.miniprojects.tms.util.AppUtil;

/**
 * Servlet implementation class ManagerEditMemberServlet
 */
@WebServlet({ "/ManagerEditMemberServlet", "/ManagerEditMember" })

public class ManagerEditMemberServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	Logger logger = Logger.getLogger(this.getClass());
       
    public ManagerEditMemberServlet() 
    {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException,
	IOException 
	{
		System.out.println("ManagerEditMemberServlet - doGet() invoked");

		int empId = 0;
		String empIdStr = request.getParameter("empId");
		
		if(null!=empIdStr && empIdStr.trim().length()>0) 
		{
			empId = Integer.parseInt(empIdStr);
		}
		EmployeeBO employeeBO = new EmployeeBO();
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		try 
		{
			employeeBO = employeeDAO.getEmployeeByEmpId(empId);
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
		logger.info("EmployeeBO object from the database is " + employeeBO);
		
		// 2. Store it in a way where the data is accessible in the JSP
		request.setAttribute("employeeBO", employeeBO);

		// 3. Forward / Delegate the control/flow the required JSP Page
		request.getRequestDispatcher("/manager/managereditmember.jsp").forward(request, response);
	}

}
