package com.servlets;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.dao.SaveFlightdao;

/**
 * Servlet implementation class Saveflight
 */
public class Saveflight extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Saveflight() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int fid=Integer.parseInt(request.getParameter("fid"));
		String src=request.getParameter("src").toString();
		String dest=request.getParameter("dest").toString();
		long price=Long.parseLong(request.getParameter("price"));
		
			String arr=request.getParameter("arr").toString();
			String dept=request.getParameter("dept").toString();
			SaveFlightdao sdao=new SaveFlightdao();
			sdao.saveflight(fid, src, dest, price, arr, dept);
			
		
		HttpSession session=request.getSession();
		session.setAttribute("save", "saved");
		response.sendRedirect("addflight.jsp");
	}

}
