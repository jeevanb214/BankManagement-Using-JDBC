package Bnk_app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Search extends HttpServlet{
	
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException
	{
		PrintWriter out=resp.getWriter();
		//out.println("welcome\n");
		try {
		//	out.println("welcome1");
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_application", "root", "");
			int Account_no=Integer.parseInt(req.getParameter("ser_num")); 
			
			Servlet01 obj = new Servlet01(); 
			
		
		 
		
		//if(obj.arl.contains(Account_no)){
			Statement st=con.createStatement();
			
			 PreparedStatement pst=con.prepareStatement("select * from customer_details where Account_no = ?;");
			 pst.setInt(1,Account_no);
			ResultSet rs=pst.executeQuery();
			int i=1;
			while(rs.next())
			{	out.println("<center><table border='1'><tr><td>");
				out.println("\nACCOUNT NUMBER:</td><td>"+rs.getInt(1)+"</td></tr>");
				//out.println("--------------------------------");

				out.println("<tr><td>NAME          :</td><td>"+rs.getString(2)+"</td></tr>");
				//out.println("--------------------------------");

				out.println("<tr><td>PHONE NUMBER  :</td><td>"+rs.getInt(3)+"</td></tr>");
				//out.println("--------------------------------");


				out.println("<tr><td>ADDRESS        :</td><td>"+rs.getString(4)+"</td></tr>");
				//out.println("--------------------------------");

				out.println("<tr><td>TYPE OF ACCOUNT:</td><td>"+rs.getString(5)+"</td></tr>");
				//out.println("--------------------------------");

				out.println("<tr><td>BALANCE        :</td><td>"+rs.getInt(6)+"</td></tr>");
				//out.println("--------------------------------");
				out.println("</table></center>");	
				i=0;
				 //java.util.concurrent.TimeUnit.SECONDS.sleep(2);
				//resp.sendRedirect("Message.jsp");
			}
			if(i!=0)
			{
				 resp.sendRedirect("Error_msg.jsp");
				/*out.println("-------------------------------------------------");
				out.println("--------------------->|Account number not existed|");
				out.println("-------------------------------------------------");*/
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		
		
	}

}
