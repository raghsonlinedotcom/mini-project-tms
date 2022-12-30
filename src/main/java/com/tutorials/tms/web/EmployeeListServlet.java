package com.tutorials.tms.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.tutorials.tms.bo.EmployeeBO;
import com.tutorials.tms.dao.EmployeeDAO;
import com.tutorials.tms.dao.EmployeeDAOImpl;


/**
 * Servlet implementation class EmployeeListServlet
 */
@WebServlet("/EmployeeListServlet")
public class EmployeeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(this.getClass());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeListServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		logger.info("ViewMyDetailsServlet - doGet() invoked");
		EmployeeDAO employeeDAO = null;

		employeeDAO = new EmployeeDAOImpl();
		List<EmployeeBO> employeeBOList = null;
		try 
		{
			employeeBOList = employeeDAO.employeeBOList();
		} 
		catch (Exception exception)
		{
			logger.error("Exception occurred while Obtaining the data from the Database Table");
			logger.error("Message" + exception);
		}
		request.setAttribute("employeeBOList", employeeBOList);

		request.getRequestDispatcher("list.jsp").forward(request, response);

	}

}
