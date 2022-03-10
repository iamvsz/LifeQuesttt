import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class Medical extends HttpServlet
{
 protected void doPost
 (HttpServletRequest req,HttpServletResponse res)
 throws ServletException,IOException
 {
  PrintWriter pw=res.getWriter();
  res.setContentType("text/html");
  String name=req.getParameter("name");
 try
   {
    Class.forName("oracle.jdbc.driver.OracleDriver");
    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##swapnil","Swapnil");
    PreparedStatement ps=con.prepareStatement("select * from history where name=?");
 ps.setString(1,name);
 ResultSet rs=ps.executeQuery();
  if(rs.next())
  {
pw.println("<html>");
pw.println("<head>");
pw.println("<link href='med.css' rel='stylesheet' type='text/css'>");
pw.println("</head>");
pw.println("<body>");
pw.println("<a href='logout'><input type='submit' name='logout' value='logout'></a>");

pw.println("<div class='login-box'>");
pw.println("<img src='drop.jpg' class='drop'>");
pw.println("<br><br><br><h2>Donor History</h2>");
pw.println("<form action='medhistory' method='post'>");
pw.println("<p>Name of donor</p>");
pw.println("<input type='text' name='name'  value='"+rs.getString(1)+"'/><br>");
pw.println("<p>Have the donor donated blood previously?</p>");
pw.println("<input type='text' name='donate'  value='"+rs.getString(2)+"'/><br>");
pw.println("<p>Did the donor had any of these in the last 6 months?</p>");
pw.println("<p>body piercing,tatoo,dental extraction</p>");
pw.println("<input type='text' name='disease1'  value='"+rs.getString(3)+"'/>");
pw.println("<p>Does the Donor suffer from or have suffered from any diseases?</p><br>");
pw.println("<input type ='text' name='disease2'  value='"+rs.getString(4)+"'/>");
pw.println("<p>weight</p>");
pw.println("<input type='number' name='weight'  value='"+rs.getString(5)+"'/><br>");
pw.println("<input type='submit' name='submit' value='Update'>");
pw.println("</form>");
pw.println("</div>");
pw.println("</body>");
pw.println("</html>");
  }
  }
  catch(Exception e)
 {
   pw.println(e);
  }
  pw.close();
 }
}
