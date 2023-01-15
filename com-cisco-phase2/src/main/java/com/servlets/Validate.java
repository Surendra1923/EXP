package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.Validatedao;

/**
 * Servlet implementation class Validate
 */
public class Validate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Validate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Validatedao vdao=new Validatedao();
		String uname=request.getParameter("uname").toString();
		String psw=request.getParameter("psw").toString();
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		boolean v=vdao.valid(uname, psw);
		if(v) {
			response.sendRedirect("adminop.jsp");
		}
		else
		{
			session.setAttribute("valid","notvalid");
			response.sendRedirect("login.jsp");
		}
			
	}

}
