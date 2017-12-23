package controller;
import model.*;		
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.*;
import controller.*;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

 

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // Set a cookie for the user, so that the counter does not increase
        // every time the user press refresh
        HttpSession session = request.getSession(false);
    
        RequestDispatcher rd = null;
        if(session.getAttribute("remember")==null ) session.setAttribute("remember", request.getParameter("remember"));
      if(((String)request.getParameter("remember"))!=null) {
        session.setAttribute("user", request.getParameter("user"));
        session.setAttribute("pass",request.getParameter("pass"));
      }

      else{
          session.setAttribute("user", null);
          session.setAttribute("pass",null);
        }
      
		String username = ((String)session.getAttribute("user")==null)?request.getParameter("user"):((String)session.getAttribute("user"));
		String password =((String)session.getAttribute("pass")==null)?request.getParameter("pass"):((String)session.getAttribute("pass"));
		UserDAO userDAO=new UserDAO();
		String pagename = null;
		try {
			if (userDAO.validateLogin(username,password))  {
				pagename="Landing.jsp";
				}
			else{
				pagename="Home.jsp";
				
			}
		} catch (SQLException e) {
			pagename="Home.jsp";
			e.printStackTrace();
		}
		finally {
			
		rd=request.getRequestDispatcher(pagename);
		rd.forward(request, response);
			
       }
    
    }
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    	request.getRequestDispatcher("Home.jsp").forward(request, response);
    }
//{}{}{}{}{}{}{}{}{}
/*
 * 
    @Override
    public void init() throws ServletException {
        dao = new FileDao();
        try {
            count = dao.getCount();
        } catch (Exception e) {
            getServletContext().log("An exception occurred in FileCounter", e);
            throw new ServletException("An exception occurred in FileCounter"
                    + e.getMessage());
        }
    }

    public void destroy() {
        super.destroy();
        try {
            dao.save(count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
*/
}
