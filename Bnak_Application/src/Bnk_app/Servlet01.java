package Bnk_app;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet01 extends HttpServlet{

	public ArrayList arl=new ArrayList();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		PrintWriter out=resp.getWriter();
		out.println("\n");
		try {
			//out.println("welcome1");
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_application", "root", "");
			//out.println("welcome 2");
			int Account_no=Integer.parseInt(req.getParameter("acc_num"));  
		  //out.println("welcome "+ Account_no);

	    String Name=req.getParameter("name");
	    //out.println("welcome  "+ Name);
	    
	    int  Phone_num=Integer.parseInt((req.getParameter("ph_num")));
	   // out.println("welcome "+ Phone_num);
	    
	    String Address=req.getParameter("address");
	   // out.println("welcome "+ Address);

	    
	    
	    String Type_Of_Account=req.getParameter("type_acc"); 
	   // out.println("welcome "+ Type_Of_Account);

	    int Balance=Integer.parseInt(req.getParameter("balance"));
	   // out.println("welcome "+ Balance);
    
	  String doc=req.getParameter("doc");
	   
		//arl.add(Account_no);
	    PreparedStatement pst=con.prepareStatement("insert into customer_details (Account_no,Name,Phone_num,Address,Type_of_account,Balance,Documents_Submitted) values(?,?,?,?,?,?,?)");

	    pst.setInt(1,Account_no);
	    pst.setString(2, Name);
	    pst.setInt(3,Phone_num);
	    pst.setString(4, Address);
	    pst.setString(5, Type_Of_Account);
	    pst.setInt(6,Balance);
	    pst.setString(7, doc);
	    int rs=pst.executeUpdate();
	    
		if(rs>=0)
			resp.sendRedirect("Message.jsp");
			else
			out.println("Something went Wrong");
		}
		catch(Exception e)
		{
			//out.println(e);
			out.println("-------------------------------------------------");
			out.println("--------------------->|Account number already existed|");
			out.println("-------------------------------------------------");
		}
			
}
}
	


