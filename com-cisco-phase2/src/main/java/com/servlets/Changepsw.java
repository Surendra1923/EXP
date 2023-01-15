package com.servlets;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import com.dao.Changepswdao;

/**
 * Servlet implementation class Changepsw
 */
public class Changepsw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Changepsw() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String psw=request.getParameter("passOne").toString();
		Changepswdao ch=new Changepswdao();
		ch.changepsw(psw);
		HttpSession session=request.getSession();
		session.setAttribute("change", true);
		response.sendRedirect("changepsw.jsp");
	}

} 
