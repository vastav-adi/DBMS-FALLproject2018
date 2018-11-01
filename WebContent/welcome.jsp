<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome page</title>
</head>
<body>
<center>
Welcome <%= session.getAttribute("currentSessionUserName") %>
<br>
registration number <%= session.getAttribute("currentSessionUser") %>
</center>
<br>
<center>
 encryption type is <%= session.getAttribute("currentEncryptionType") %>
<br>
encrypted password is <%= session.getAttribute("encp") %>
<br>
decrypted password is <%= session.getAttribute("decp") %>


</center>

<br>
<br>
time taken by <%= session.getAttribute("currentEncryptionType") %> to encrypt "<%= session.getAttribute("decp") %>" is <%=session.getAttribute("time") %> ms.
</body>
</html>