import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class Edit extends HttpServlet
{
 protected void doPost
 (HttpServletRequest req,HttpServletResponse res)
 throws ServletException,IOException
 {
  PrintWriter pw=res.getWriter();
  res.setContentType("text/html");
  String password=req.getParameter("password");
  try
   {
    Class.forName("oracle.jdbc.driver.OracleDriver");
    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##swapnil","Swapnil");
    PreparedStatement ps=con.prepareStatement("select * from bloodbank where password=?");
  ps.setString(1,password);
ResultSet rs=ps.executeQuery();
  if(rs.next())
  {
pw.println("<html>");
pw.println("<head>");
pw.println("<link href='bloodbank_signup.css' rel='stylesheet' type='text/css'>");
pw.println("</head>");
pw.println("<body>");
pw.println("<a href='logout'><input type='submit' name='logout' value='logout'></a>");
pw.println("<div class='login-box'>");
pw.println("<img src='drop.jpg' class='drop'>");
pw.println("<br><br><br><h2>Blood Bank Profile</h2>");
pw.println("<form action='Editbank' method='post'>");
pw.println("<p>Blood Bank name</p>");
pw.println("<input type='text' name='name' value='"+rs.getString(1)+"'/>");
pw.println("<p>username</p>");
pw.println("<input type='text' name='username' value='"+rs.getString(2)+"'/>");
pw.println("<p>password</p>");
pw.println("<input type='password' name='password' value='"+rs.getString(3)+"'/>");
pw.println("<p>E-mail</p>");
pw.println("<input type='email' name='email' value='"+rs.getString(4)+"'/>");
pw.println("<p>city</p>");
pw.println("<input type='text' name='city' value='"+rs.getString(5)+"'/>");
pw.println("<p>contact number</p>");
pw.println("<input type='number' name='contact' value='"+rs.getString(6)+"'/><br>");
pw.println("<input type='submit' name='logout' value='Update'>");
pw.println("</form>");
pw.println("</div>");
pw.println("</body>");
pw.println("</html>");
  }
 else
  {
   pw.println("Invalid Username and Password");
  }


 }
  catch(Exception e)
 {
   pw.println(e);
  }
  pw.close();
 }
}
