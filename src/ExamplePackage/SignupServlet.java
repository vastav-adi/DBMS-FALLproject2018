package ExamplePackage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SignupServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			UserBean user = new UserBean();
			user.setregisterno(request.getParameter("regno"));
		    user.setPassword(request.getParameter("password"));
		    user.setFirstName(request.getParameter("FName"));
		    user.setLastName(request.getParameter("LName"));
		    user.setEnct(request.getParameter("encryptiontype"));
		    
		    user = createuser.signup(user);
		    HttpSession session = request.getSession(true);
		    session.setAttribute("currentSessionUser",user.getregisterno()); 
		    session.setAttribute("currentSessionUserName",user.getFirstName()); 
		    session.setAttribute("currentEncryptionType",user.getEnct()); 
		    session.setAttribute("encp", user.getencpassword());
		    session.setAttribute("decp", user.getPassword());
		    session.setAttribute("time", user.gettime());
		    
		    response.sendRedirect("welcome.jsp");
		    //if(user.iscreated())
		}
		catch (Throwable theException) 	    
		{
		     System.out.println(theException); 
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
