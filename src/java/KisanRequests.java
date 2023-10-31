import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class KisanRequests extends HttpServlet
{
public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException
{
	
	PrintWriter out=response.getWriter();
	
	out.println("<html>");
	out.println("<head>");
	out.println("<link rel='stylesheet' href='abc.css'>");
	out.println("</head>");
	out.println("<body>");
	
	
	
	try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql:///Minor","root","1234");
  Statement st=con.createStatement();
  ResultSet rs=st.executeQuery("select * from kisandetail");
 out.println("<center>");
 out.println("<table cellpadding='12' border=1>" );
	

 out.println("<tr>");
 out.println("<th>Kisan ID</th>");
 out.println("<th>Type Of Crop</th>");
 out.println("<th>Area Of Crop</th>");
 
 out.println("</tr>");
 while(rs.next()){
	 out.println("<tr>");
	 out.println("<td>"+rs.getString(1)+"</td>");
	 out.println("<td>"+rs.getString(2)+"</td>");
	 out.println("<td>"+rs.getString(3)+"</td>");
	 
	 out.println("</tr>");
  }
   
	out.println("</table>");
	out.println("</center>");
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