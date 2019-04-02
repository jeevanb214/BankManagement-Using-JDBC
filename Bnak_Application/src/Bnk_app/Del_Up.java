package Bnk_app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Del_Up extends HttpServlet
{
   
	public void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		String act = req.getParameter("act");
	//	String button2 = req.getParameter("Update");
	
		
			
		//String act = req.getParameter("act");
		if (act.equals("Delete"))
		{
			//RequestDispatcher rd = req.getRequestDispatcher("Delete");
			//rd.forward(req,resp);
			
			Delete ob=new Delete();
	        ob.doGet(req, resp);
			
			
		} 
		else if (act.equals("Update")) 
		{
			//RequestDispatcher rd = req.getRequestDispatcher("Update");
			//rd.forward(req,resp);
			For_getting ob1=new For_getting();
	        ob1.doGet(req, resp);
		} 
		
	
	
	 
	}
	
	
}
