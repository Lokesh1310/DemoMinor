import javax.servlet.*;
import javax.servlet.http.*;
//import javax.servlet.http.Cookie;

import java.io.*;
import java.sql.*;
public class KisanDetail extends HttpServlet
{
public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException
{
	
	PrintWriter out=response.getWriter();
	
	out.println("<html>");
	out.println("<body>");
	
	String s1=request.getParameter("u1");
	String s2=request.getParameter("u2");
        String s3=request.getParameter("u3");
	
	
	
	
	try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql:///Minor","root","1234");
  Statement st=con.createStatement();
    st.executeUpdate("insert into kisandetail values('"+s1+"','"+s2+"','"+s3+"');");
   
    
    
    response.sendRedirect("KisanDetail.html");
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