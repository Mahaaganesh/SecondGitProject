package com.test.readsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Report extends HttpServlet {
	
    public Report() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession seobj = request.getSession(true);
		PrintWriter out = response.getWriter();

		
		try {
			Connection con;
			CallableStatement cstmt = null;
			ResultSet rs;
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/sample", "root", "root");
		
		String SQL = "{call getRecords()}";
		cstmt = con.prepareCall (SQL);
		
		 /*System.out.println("Case 1: Without Fetch Size ->" );
		rs = cstmt.executeQuery();
		 long t1 = System.currentTimeMillis();
         System.out.println(System.currentTimeMillis());
		while (rs.next()) {
			System.out.println("Employee Id : "+rs.getString("user_id") + " , " +"Employee Name : " +rs.getString("username"));
			
		}
		System.out.println(System.currentTimeMillis());
           System.out.println(t1);
		   System.out.println("Time to iterate ResultSet of Without Fetch Size -> " + (System.currentTimeMillis() - t1));*/
		   
		   int fetchSize = 1000;
		   cstmt.setFetchSize(fetchSize);
           System.out.println("Case 2: With Setting Fetch Size value ->" + fetchSize);
           rs = cstmt.executeQuery();
           long t1 = System.currentTimeMillis();

           System.out.println(System.currentTimeMillis());

           
           while (rs.next()) {
   			System.out.println("Employee Id : "+rs.getString("user_id") + " , " +"Employee Name : " +rs.getString("username"));
   			
   		}
           System.out.println(System.currentTimeMillis());
           System.out.println(t1);
   		   System.out.println("Time to iterate ResultSet -> " + (System.currentTimeMillis() - t1));

		}
		catch(Exception ex)
		{
			
		}
	}

}
