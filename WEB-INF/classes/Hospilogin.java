import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class Hospilogin extends HttpServlet
{
 protected void doPost
 (HttpServletRequest req,HttpServletResponse res)
 throws ServletException,IOException
 {
  PrintWriter pw=res.getWriter();
  res.setContentType("text/html");
  String username=req.getParameter("username");
  String password=req.getParameter("password");
  try
   {
    Class.forName("oracle.jdbc.driver.OracleDriver");
    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##swapnil","Swapnil");
    PreparedStatement ps=con.prepareStatement("select * from hospital where username=? and password=?");
 ps.setString(1,username);
  ps.setString(2,password);
ResultSet rs=ps.executeQuery();
  if(rs.next())
  {
   pw.println("You are succesfully Login");
  }
 
else
  {
   pw.println("Invalid Username and Password");
   RequestDispatcher rd=req.getRequestDispatcher("hospital_login.html");
   rd.include(req,res);
   }
 }
  catch(Exception e)
 {
   pw.println(e);
  }
  pw.close();
 }
}
