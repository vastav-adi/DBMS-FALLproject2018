package ExamplePackage;
import java.io.IOException;
import java.sql.*;
import static java.lang.System.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.servlet.http.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class createuser {
	static Connection currentCon = null;
	   
	   
	   public static UserBean signup(UserBean bean) throws Exception
	   {
		       
			  Statement st = null;
			  Statement rt = null;
		      String registerno = bean.getregisterno();    
		      String password = bean.getPassword(); 
		      String Fname = bean.getFirstName();
		      String Lname = bean.getLastName();
		      String Encrtype = bean.getEnct();
		      
		      encdec.encrypt(bean);
		      String Encpassw = bean.getencpassword();
		      String Decpassw = bean.getdecpassword();
		      
		      //String insertQuery ="insert into users values('"+Fname+"','"+Lname+"','"+registerno+"','"+password+"','"+Encrtype+"')";
		      try 
		      {
		         //connect to DB 
		    	  Class.forName("com.mysql.jdbc.Driver");
		  		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project2", "root","Kaushambi123");
		  		st = conn.createStatement(); 
		         
		         st=conn.createStatement();
		         st.executeUpdate("insert into users values('"+Fname+"','"+Lname+"','"+registerno+"','"+password+"','"+Encrtype+"')");	
		         
		         st.close();
		      }
		      catch (Exception ex) 
		      {
		         System.out.println("Insertion failed " + ex);
		         System.out.println(ex.getMessage());
		      } 
		      
		      
		      try 
		      {
		         //connect to DB 
		    	  Class.forName("com.mysql.jdbc.Driver");
		  		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project2", "root","Kaushambi123");
		  		rt = conn.createStatement(); 
		         
		         rt=conn.createStatement();
		         rt.executeUpdate("insert into user values('"+Fname+"','"+Lname+"','"+registerno+"','"+password+"','"+Encpassw+"','"+Encrtype+"')");	
		         rt.close();
		      }
		      catch (Exception ex) 
		      {
		         System.out.println("Insertion failed " + ex);
		         System.out.println(ex.getMessage());
		      } 
		      return bean;
	   }
}
