<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Display Images</title>
</head>
<body>
    <h1>Images from Database</h1>
    <table border="1">
        <tr>
             <th>Name</th>        
           
            <th>Aadhar NO.</th>        
            <th>Image 1</th>
            <th>Image 2</th>
        </tr>
        <%
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql:///Minor", "root", "1234");
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM image");

                while (rs.next()) {
                    String imageFileName1 = rs.getString("imageFN1");
                    String imageFileName2 = rs.getString("imageFN2");

                    // Assuming your image files are stored in a specific directory
                    String imageFilePath1 = "C:/Users/lucky/Documents/NetBeansProjects/Minor/web/images/" + imageFileName1;
                    String imageFilePath2 = "C:/Users/lucky/Documents/NetBeansProjects/Minor/web/images/" + imageFileName2;

        %>
          
        <tr> 
            
           <td><%=rs.getString(4)%></td>
           <td><%=rs.getString(5)%></td>
           
                <td><a href="<%= imageFilePath1 %>" target="_blank"><img src="<%= imageFilePath1 %>" width="200" height="200"/></a></td>
                <td><a href="<%= imageFilePath2 %>" target="_blank"><img src="<%= imageFilePath2 %>" width="200" height="200"/></a></td>
            </tr>
        <%
            }
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
        %>
    </table>
</body>
</html>
