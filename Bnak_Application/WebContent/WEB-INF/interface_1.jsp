<%@page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ACCOUNTS</title>
</head>
<body>


<div style="text-align:center"> 
<h3>Bank Application</h3>
</div>
<div style="text-align:center"> 
<form action="create.jsp"  method="post" style="display:inline-block">
<input type="submit" name="create" value="Create" >
</form>

<%--<form  action="update.jsp"  method="post" style="display:inline-block">
<input type="submit" name="update" value="Update" >
</form>--%>

<%-- form  action="delete.jsp"  method="post" style="display:inline-block">
<input type="submit" name="delete" value="Delete" >
</form>--%>


<form  action="search.jsp"  method="post" style="display:inline-block">
<input type="submit" name="Search" value="Search" >
</form>




<% Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_application", "root", "");
//out.println("welcome 2");

Statement st=con.createStatement();
 //PreparedStatement pst=con.prepareStatement(");
ResultSet rs1=st.executeQuery("select * from customer_details;");
%>


<br>
<h3>----------------------------------------------------------------------------------------------------------------------------------</h3>
<h3>List Of Accounts</h3>
<h3>----------------------------------------------------------------------------------------------------------------------------------</h3>

<h3>For Updating</h3>
<table border='1' align="center">
<tr><th>Click Here</th><th>Account no</th><th>Name</th><th>Phone number</th><th>Address</th><th>Type Of Account</th><th>Balance</th><th>Documents_Submittedd</th></tr>

<form action = "Del_Up" method = "get">
	
	
<% while(rs1.next()){ %>
 	<%int n=rs1.getInt(1);  %>
 	<tr>
    <td><%out.println("<input type='radio' name='id' value="+n+" required");%></td>
  	<td><%=  rs1.getInt(1) %></td>
  	
  	<td><%=  rs1.getString(2) %></td>
    <td><%=  rs1.getInt(3) %></td>
    <td><%=  rs1.getString(4) %></td>
   <td><%=  rs1.getString(5) %></td>
    <td><%=  rs1.getInt(6) %></td>
   <td><%=  rs1.getString(7) %></td>
    </tr>
<% }%>

<%

Statement st1=con.createStatement();
//PreparedStatement pst=con.prepareStatement(");
ResultSet rs2=st1.executeQuery("select * from customer_details;");

%>	
</table>
<br>
<input type="submit" value="Update" name="act">
<input type="submit" value="Delete" name="act">
 
</form>
<%--
<h3>----------------------------------------------------------------------------------------------------------------------------------</h3>
<h3>For Deleting</h3>
<table border='1' align="center">
<tr><th>Click Here</th><th>Account no</th><th>Name</th><th>Phone number</th><th>Address</th><th>Type Of Account</th><th>Balance</th><th>Documents_Submittedd</th></tr>
<form action="Delete" method="get">
	
<% while(rs2.next()){ %>
 	<%int n=rs2.getInt(1);  %>
 	<tr>
    <td><%	 out.println("<input type='radio' name='id' value="+n+" required");%></td>
  	<td><%=  rs2.getInt(1) %></td>
  	<td><%=  rs2.getString(2) %></td>
    <td><%=  rs2.getInt(3) %></td>
    <td><%=  rs2.getString(4) %></td>
   <td><%=  rs2.getString(5) %></td>
    <td><%=  rs2.getInt(6) %></td>
   <td><%=  rs2.getString(7) %></td>
    </tr>
<% }%>
	
</table>
<br>
<input type="submit" value="Delete" >
<input type="submit" value="Update">
</form>




</div>--%>
<br>
<br>


</body>
</html>