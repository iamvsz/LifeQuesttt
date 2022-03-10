import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class Contact extends HttpServlet
{
 protected void doPost
 (HttpServletRequest req,HttpServletResponse res)
 throws ServletException,IOException
 {
  PrintWriter pw=res.getWriter();
  res.setContentType("text/html");
  String firstname=req.getParameter("firstname");
  String lastname=req.getParameter("lastname");
  String country=req.getParameter("country");  
  String subject=req.getParameter("subject");
    try
   {
    Class.forName("oracle.jdbc.driver.OracleDriver");
    Connection con=DriverManager.getConnection    ("jdbc:oracle:thin:@localhost:1521:orcl","c##swapnil","Swapnil");
    PreparedStatement ps=con.prepareStatement("insert into contact values(?,?,?,?)");
    ps.setString(1,firstname);
    ps.setString(2,lastname);
    ps.setString(3,country);
    ps.setString(4,subject);
    ResultSet rs=ps.executeQuery();
     if(rs.next())
    {
    pw.println("Thanks for your response");
    RequestDispatcher rd=req.getRequestDispatcher("proj.html");
    rd.forward(req,res); 
    }
  }
  catch(Exception e)
  {
   pw.println(e);
  }
  pw.close();
 }
}