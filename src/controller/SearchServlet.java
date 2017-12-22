package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.EmployeeDAO;

/**
 * Servlet implementation class SearchServlet
 */
//@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ArrayList<Employee> list;   
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		list=new ArrayList<Employee>();
		
	    String criteria = request.getParameter("criteria");
	    String value = request.getParameter("searchvalue");
	    String incl = "no";
	    
	    if (request.getParameterValues("incl")!=null) {
	    	incl="ok";
	    }
	    
		EmployeeDAO edao = new EmployeeDAO();
		try {
			list=edao.getEmployee(criteria, value,incl);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		request.setAttribute("collectionOrArray", list);
        request.getRequestDispatcher("/searchres.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
