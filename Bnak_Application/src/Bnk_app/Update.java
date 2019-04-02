package Bnk_app;

import java.io.PrintWriter;
import java.sql.*;
import java.sql.DriverManager;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Update extends HttpServlet
{ 
	public void doGet(HttpServletRequest req,HttpServletResponse resp)
	{
		System.out.println("welcome1");
		try {
			//	out.println("welcome1");
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_application", "root", "");
				Statement  st=con.createStatement();
				PrintWriter out=resp.getWriter();
				//out.println("1");
				int Account_no=Integer.parseInt(req.getParameter("acc")); 
				//out.println("2");
				String Name=req.getParameter("nam");
				
				int Phone_num=Integer.parseInt(req.getParameter("phno"));
				String Address=req.getParameter("add"); 
				String Type_of_account=req.getParameter("toa"); 
				 int Balance=Integer.parseInt(req.getParameter("bal"));
				 String Documents_Submitted=req.getParameter("doc");
				 //out.println("3");
					System.out.println("welcome1");

				 PreparedStatement ps=con.prepareStatement("update customer_details set Name=?, Phone_num=?, Address=?, Type_Of_Account=?, Balance=?, Documents_Submitted=? where Account_no=?");
				 //out.println("4");
					System.out.println("welcome1");

				 ps.setString(1, Name);
				 ps.setInt(2, Phone_num);
				 ps.setString(3, Address);
				 ps.setString(4, Type_of_account);
				 //out.println(Type_of_account);
				 ps.setInt(5, Balance);
				 ps.setInt(6,Account_no);
				 ps.setString(7, Documents_Submitted);
				 //out.println("5");
					System.out.println("welcome1");

				 int rs=ps.executeUpdate();
				 //out.println("6");
				    
					if(rs>=0)
					{
					    resp.sendRedirect("Message.jsp");
					//out.println("successfully Updated");
					}
					else
					{
						out.println("not Updated");
					}
					
				
				
		
		
		}
		catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
			
	}

}
