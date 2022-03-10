import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class ViewCamp extends HttpServlet
{
 protected void doGet
 (HttpServletRequest req,HttpServletResponse res)
 throws ServletException,IOException
 {
  PrintWriter pw=res.getWriter();
  res.setContentType("text/html");
   try
   {
    Class.forName("oracle.jdbc.driver.OracleDriver");
    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##swapnil","Swapnil");
    PreparedStatement ps=con.prepareStatement("select * from camp");
ResultSet rs=ps.executeQuery();

pw.println("<html>");
pw.println("<head>");
pw.println("<meta name='viewport' content='width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;' />");
pw.println("<link href='ci.css' rel='stylesheet' type='text/css'>");
pw.println("</head>");
pw.println("<body>");
pw.println("<div class='h'><h1>LIFE QUESTTT</h1></div><br>");

pw.println("<br>");
pw.println("<nav>");
pw.println("<ul>");
pw.println("<li><a href='proj.html'>Home</a></li><br><br><br>");
while(rs.next())
{
 String name=rs.getString(1);
   String date=rs.getString(2);
   String address=rs.getString(4);
String contact=rs.getString(3);
pw.println("<center><h2><b><p style='margin-left:25%;margin-right:25%; color: black; border:solid 2px black; padding: 20px; border-radius:2em'>The Blood Donation Camp is organized by"+name+"on date"+date+"The location for the Camp will be"+address+".For further details contact"+contact+    "</p></b></h2></center>");
pw.println("</ul>");
pw.println("</nav>");
pw.println("</body>");
pw.println("</html>");
}
}catch(Exception ex){System.out.println(ex);}
 
 }
}
 