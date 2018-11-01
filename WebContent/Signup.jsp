<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>signup</title>
</head>
<body>
<form method="get" action="SignupServlet">
First Name:<br>
<input type="text" name="FName">
<br>
Last Name:<br>
<input type="text" name="LName">
<br>
Register number:<br>
<input type="text" name="regno">
<br>
Password:<br>
<input type="text" name="password">
<br>
Encryption type :<br>
<input type="radio" name="encryptiontype" value="aes"> Aes<br>
  <input type="radio" name="encryptiontype" value="bf"> Blowfish<br>
  <input type="radio" name="encryptiontype" value="tdes"> Three DES<br>
<br>

<br>
<input type="submit" value="submit">
</form>

</body>
</html>