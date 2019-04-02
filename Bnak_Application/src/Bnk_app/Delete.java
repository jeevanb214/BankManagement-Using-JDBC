package Bnk_app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Delete extends HttpServlet
{
  public void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		PrintWriter out=resp.getWriter();
		//out.println("welcome\n");
		try {
			//out.println("welcome1");
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_application", "root", "");
			int Account_no=Integer.parseInt(req.getParameter("id"));  
			//out.println(Account_no);
		    PreparedStatement pst=con.prepareStatement("delete from customer_details where Account_no = ?;");
		    pst.setInt(1,Account_no);
		    int rs=pst.executeUpdate();
		    if(rs>0)
		    {
			    resp.sendRedirect("Message.jsp");
				//out.println("Account number "+Account_no+" successfully deleted");
		    	//sleep(200);
				//
		    }
				else
				{
					 resp.sendRedirect("Error_msg.jsp");

					/*out.println("-------------------------------------------------");
					out.println("--------------------->|Account number not existed|");
					out.println("-------------------------------------------------");*/

				}
		    //Thread.sleep(2000);
		   /// java.util.concurrent.TimeUnit.SECONDS.sleep(3);


		}		
		catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
  
   }
}
