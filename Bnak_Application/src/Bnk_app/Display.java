package Bnk_app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Display extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		PrintWriter out=resp.getWriter();
		out.println("List of Accounts");
		try {
			//out.println("welcome1");
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_application", "root", "");
			//out.println("welcome 2");
			
			Statement st=con.createStatement();
			 PreparedStatement pst=con.prepareStatement("select * from customer_details;");
			ResultSet rs=pst.executeQuery();
			int i=1;
			while(rs.next())
				{
				out.println("-------------------------------");
				out.println("Customer "+i+" Details ");
				out.println("-------------------------------");
				out.println("ACCOUNT NUMBER  :"+rs.getInt(1));

				out.println("NAME            :"+rs.getString(2));
				

				out.println("PHONE NUMBER    :"+rs.getInt(3));

				out.println("ADDRESS         :"+rs.getString(4));

				out.println("TYPE OF ACCOUNT :"+rs.getString(5));

				out.println("BALANCE         :"+rs.getInt(6));	
			
				
				i++;
				}
			
			
			

		
		
		}
		catch (Exception e) {
			// TODO: handle exception
		e.getMessage();
		}

}
}



