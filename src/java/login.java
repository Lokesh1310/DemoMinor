import javax.servlet.*;
import javax.servlet.http.*;
//import javax.servlet.http.Cookie;

import java.io.*;
import java.sql.*;
public class login extends HttpServlet
{
public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException
{
	
	PrintWriter out=response.getWriter();
	
	out.println("<html>");
	out.println("<body>");
	
	String s1=request.getParameter("u1");
	String s2=request.getParameter("u2");
	
	
	
	try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql:///Minor","root","1234");
  Statement st=con.createStatement();
  ResultSet rs=st.executeQuery("select * from login where UNAME='"+s1+"' AND UPASS='"+s2+"'");
  if(rs.next()){
      
  out.println("WellCome");
       
  }
  else{
  out.println("INVALID USER NAME AND PASSWORLD");
  }  
con.close();
  
	
	}
	catch(Exception e){
	out.println(e);
	}
	
	
	
	
	
	out.println("<body>");
	
	out.println("</html>");
	out.close();
}


}