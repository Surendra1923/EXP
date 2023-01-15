package com.servlets;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.PassDetailsdao;

/**
 * Servlet implementation class Storedetails
 */
public class StoredDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoredDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String uname=(req.getParameter("uname")).toString();
		int age = Integer.parseInt(req.getParameter("age"));
		String email=req.getParameter("email").toString();
		long phno=Long.parseLong(req.getParameter("phno"));
		long aadhar = Long.parseLong(req.getParameter("aadhar"));
		PassDetailsdao store=new PassDetailsdao();
		store.storedetails(uname, age, email, phno, aadhar);
		RequestDispatcher rd=req.getRequestDispatcher("payment.jsp");
		req.setAttribute("aadhar", aadhar);
		rd.forward(req, res);
	}

}
