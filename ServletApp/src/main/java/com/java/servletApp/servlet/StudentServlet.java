package com.java.servletApp.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/studentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	System.out.println("init method called");
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		System.out.println("do get");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("do post");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		String age = request.getParameter("age");
		String marks = request.getParameter("marks");
		
		System.out.println("Name: "+name+" City: "+city);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classwork?autoReconnect=true&useSSL=false", "root", "654321");
			PreparedStatement ps=con.prepareStatement("insert into student_table values(?,?,?,?,?)");
			ps.setInt(1,Integer.valueOf(id));
			ps.setString(2,name);
			ps.setInt(3,Integer.valueOf(marks));
			ps.setString(4, city);
			ps.setInt(5, Integer.valueOf(age));
			
			int k=ps.executeUpdate();
			System.out.println(k+" records updated");  
			if(k!=0) {
				
				//you can also use sendredirect()
				RequestDispatcher rd = request.getRequestDispatcher("Success.jsp");
				rd.forward(request, response);
			}
			
			con.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			RequestDispatcher rd = request.getRequestDispatcher("fail.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		
		System.out.println("destroy method called");
	}

}
