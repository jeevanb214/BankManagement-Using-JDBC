<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action=Update>
<table align="center">
<tr>
<td>Account number:</td><td>${acc}<input type="hidden" name="acc"   maxlength="5"  value=${acc}></td></tr>

<tr>
<td>Name:</td><td><input type="text" name="nam"    maxlength="15"  value=${nam}></td></tr>
<tr>
<td>Phone number:</td><td><input type="text" name="phno"    maxlength="10"  value=${phno}></td></tr>
<tr>
<td>Address:</td><td><input type="text" name="add"   maxlength="30"   value=${add}></td></tr>
<tr>
<td>Type of account:</td><td>
<input type="text" name="toa"   maxlength="10"   value=${toa}>
</td></tr>
<tr>
<td>Balance:</td><td><input type="text" name="bal"    maxlength="10"  value=${bal}></td></tr>
<tr><td>Documents Submitted:</td><td><input type="text" name="doc"   maxlength="10"   value=${doc}></td></tr>
</table>
<p align=center>
<input type="submit" value="Update">
</p>
</form>

</body>
</html>