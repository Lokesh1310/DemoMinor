import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/KisanIdG")
@MultipartConfig(maxFileSize = 16177215) // upload file's size up to 16MB
public class KisanIdG extends HttpServlet {

    public KisanIdG() {
        super();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Part file1 = request.getPart("aadharCard");
        Part file2 = request.getPart("LandKhasara");
	
	String s1=request.getParameter("KN");
	String s2=request.getParameter("ACN");

        String imageFileName1 = file1.getSubmittedFileName();
        String imageFileName2 = file2.getSubmittedFileName();
      
        String uploadPath1 = "C:/Users/lucky/Documents/NetBeansProjects/Minor/web/images" + imageFileName1;
        String uploadPath2 = "C:/Users/lucky/Documents/NetBeansProjects/Minor/web/images" + imageFileName2;

        try (FileOutputStream fos1 = new FileOutputStream(uploadPath1);
             FileOutputStream fos2 = new FileOutputStream(uploadPath2);
             InputStream is1 = file1.getInputStream();
             InputStream is2 = file2.getInputStream()) {

            byte[] data1 = new byte[1024];
            int bytesRead1;
            while ((bytesRead1 = is1.read(data1)) != -1) {
                fos1.write(data1, 0, bytesRead1);
            }

            byte[] data2 = new byte[1024];
            int bytesRead2;
            while ((bytesRead2 = is2.read(data2)) != -1) {
                fos2.write(data2, 0, bytesRead2);
            }

        
        	try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql:///Minor","root","1234");
  Statement st=con.createStatement();
    st.executeUpdate("insert into image( imageFN1,imageFN2,name,adharno) values('"+imageFileName1+"','"+imageFileName2+"','"+s1+"','"+s2+"');");
   
    
    
    response.sendRedirect("KisanIdG.html");
con.close();
  
	
	}
	catch(Exception e){
	}

      
        }}}