package ExamplePackage;

public class UserBean {
	
    private String registerno;
    private String password;
    private String firstName;
    private String lastName;
    private String enct;
    public boolean valid;
    private String encpassword;
    private String decpassword;
    private long time;
    
    //public boolean created;

    public long gettime() {
        return time;
 	}

     public void settime(long newtime) {
    	 time = newtime;
 	}

    
    public String getencpassword() {
        return encpassword;
 	}

     public void setencpassword(String newencpassword) {
    	 encpassword = newencpassword;
 	}
     public String getdecpassword() {
         return decpassword;
  	}

      public void setdecpassword(String newdecpassword) {
     	 decpassword = newdecpassword;
  	}
	
    public String getFirstName() {
       return firstName;
	}

    public void setFirstName(String newFirstName) {
       firstName = newFirstName;
	}
    
    public String getEnct() {
        return enct;
 	}

     public void setEnct(String newEnct) {
        enct = newEnct;
 	}
    
    
	
    public String getLastName() {
       return lastName;
			}

    public void setLastName(String newLastName) {
       lastName = newLastName;
			}
			

    public String getPassword() {
       return password;
	}

    public void setPassword(String newPassword) {
       password = newPassword;
	}
	
			
    public String getregisterno() {
       return registerno;
			}

    public void setregisterno(String newregisterno) {
    	registerno = newregisterno;
			}

				
    public boolean isValid() {
       return valid;
	}

    public void setValid(boolean newValid) {
       valid = newValid;
	}	
   /* public boolean iscreated() {
        return created;
 	}

     public void setcreated(boolean newcreated) {
    	 created = newcreated;
 	}	*/
}
