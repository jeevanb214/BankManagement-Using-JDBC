package Bnk_app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class For_getting  extends HttpServlet
{
	
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException
	{
		PrintWriter out=resp.getWriter();
	//	out.println("welcome\n");
		
		try {
		//out.println("welcome1");
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_application", "root", "");
			int Account_no =Integer.parseInt(req.getParameter("id"));
			out.print(Account_no);
			Statement st =con.createStatement();
			PreparedStatement pst=con.prepareStatement("select * from customer_details where Account_no = ?;");
			pst.setInt(1,Account_no);
			//		out.println("welcome2");

			
			HttpSession session=req.getSession();
			ResultSet rs=pst.executeQuery();
			//	out.println("welcome3");

			int i=1;
			while(rs.next())
			{
				//out.println("welcome5");

			session.setAttribute("acc", rs.getInt(1));
			//out.println("welcome6");

			session.setAttribute("nam", rs.getString(2));
			//out.println("welcome7");

			session.setAttribute("phno", rs.getInt(3));
			//out.println("welcome8");
			session.setAttribute("add", rs.getString(4));
			//		//out.println("welcome9");
			session.setAttribute("toa", rs.getString(5));
			//out.println("welcome10");
			session.setAttribute("bal", rs.getInt(6));
			//			out.println("welcome11");
			
		    session.setAttribute("doc", rs.getString(7));
		    //out.println("welcome11");

			//getServletContext().getRequestDispatcher("update1.jsp").forward(req, resp);
			RequestDispatcher rd=req.getRequestDispatcher("update1.jsp");
			rd.forward(req, resp);
			//out.println("welcome12");
			i=0;
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
			System.out.println(e.getMessage());
		}
}
}