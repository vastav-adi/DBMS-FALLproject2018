<%@ page language="java" 
         contentType="text/html; charset=windows-1256"
         pageEncoding="windows-1256"%>
      <%@ page import="ExamplePackage.UserBean" %>
<!DOCTYPE html>
<html>

      <head>
         <meta http-equiv="Content-Type" 
            content="text/html; charset=windows-1256">
         <title>   User Logged Successfully   </title>
      </head>
	
      <body>

         <center>
            			
            Welcome <%= session.getAttribute("currentSessionUser") %>
         </center>

      </body>
	
   </html>
