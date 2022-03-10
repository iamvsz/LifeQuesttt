import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class EditBank extends HttpServlet
{
 protected void doPost
 (HttpServletRequest req,HttpServletResponse res)
 throws ServletException,IOException
 {
  PrintWriter pw=res.getWriter();
  res.setContentType("text/html");
  String name=req.getParameter("name");
  String username=req.getParameter("username");
  String password=req.getParameter("password");  
  String email=req.getParameter("email");
  String city=req.getParameter("city");
  String contact=req.getParameter("contact");
    try
   {
    Class.forName("oracle.jdbc.driver.OracleDriver");
    Connection con=DriverManager.getConnection    ("jdbc:oracle:thin:@localhost:1521:orcl","c##swapnil","Swapnil");
    PreparedStatement ps=con.prepareStatement("update bloodbank set name=?,username=?,password=?,email=?,city=?,contact=?  ");
    ps.setString(1,name);
    ps.setString(2,username);
    ps.setString(3,password);
    ps.setString(4,email);
    ps.setString(5,city);
    ps.setString(6,contact);
    int k=0;
    k=ps.executeUpdate();
   RequestDispatcher rd=req.getRequestDispatcher("log.html");
    rd.forward(req,res); 
  }
  catch(Exception e)
  {
   pw.println(e);
  }
  pw.close();
 }
}