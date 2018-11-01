package ExamplePackage;
import java.sql.*;
import java.util.*;


public class ConnectionManager {

   static Connection con;
   static String url;
         
   public static Connection getConnection()
   {
     
      try
      {
         //String url = "jdbc:odbc:" + "DataSource"; 
         // assuming "DataSource" is your DataSource name
    	  String driverName = "com.mysql.cj.jdbc.Driver";
         Class.forName(driverName);
         
         try
         {            	
            con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/project2", "root","Kaushambi123"); 
         }
         
         catch (SQLException ex)
         {
            ex.printStackTrace();
         }
      }

      catch(ClassNotFoundException e)
      {
         System.out.println(e);
      }

   return con;
}
}