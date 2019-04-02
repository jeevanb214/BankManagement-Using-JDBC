<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create</title>
</head>
<body>

<h3 align="center">Enter Details</h3>

<table align="center">
<form action="Servlet01" method="post">
<tr><td>
Account number:</td><td>
<input type="number" name="acc_num" placeholder="ACCOUNT NUMBER"  maxlength="5" required="required"></td></tr>
<tr><td>
Name:</td><td>
<input type="text" name="name" placeholder="NAME" maxlength="15" required="required"></td></tr>
<tr><td>
Phone number:</td><td>
<input type="text" name="ph_num" placeholder="PHONE NUMBER" maxlength="9" required="required"></td></tr>
<tr><td>
Address:</td><td>
<input type="text" name="address" placeholder="ADDRESS" maxlength="30" required="required"></td></tr>
<tr><td>
Type Of Account:</td><td>
<%-- input type="text" name="type_acc" placeholder="TYPE OF ACCOUNT">--%>
<select name="type_acc">
		<option>Other</option>
        <option>SAVINGS</option>
        <option>CURRENT</option>
        <option>BUSINESS</option>
        
    </select><br></td></tr>
    
    
    
<tr><td>
Balance:</td><td>
<input type="text" name="balance" placeholder="BALANCE" maxlength="10" required="required"><br><br>

<tr><td>    
Document Submitted:</td><td>
			 <input type="checkbox" name="doc" value="Aadhaar">Aadhaar<br>
			<input type="checkbox" name="doc" value="PanCard">Pan Card<br>
			<input type="checkbox" name="doc" value="VoterId" >Voter Id<br> 
    </td>
    </tr>
</table>
<p align="center">


<input type="submit" name="save" value="save">
</p> 
</form>
</body>
</html>