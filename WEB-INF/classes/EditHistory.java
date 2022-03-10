import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class EditHistory extends HttpServlet
{
 protected void doPost
 (HttpServletRequest req,HttpServletResponse res)
 throws ServletException,IOException
 {
  PrintWriter pw=res.getWriter();
  res.setContentType("text/html");
 String name=req.getParameter("name");
  String donate=req.getParameter("donate");
  String disease1=req.getParameter("disease1");
  String disease2=req.getParameter("disease2");  
  String weight=req.getParameter("weight");

     try
   {
    Class.forName("oracle.jdbc.driver.OracleDriver");
    Connection con=DriverManager.getConnection    ("jdbc:oracle:thin:@localhost:1521:orcl","c##swapnil","Swapnil");
    PreparedStatement ps=con.prepareStatement("update history set name=?,donate=?,disease1=?, disease2=?,weight=? where name=?");
    ps.setString(1,name);
    ps.setString(2,donate);
    ps.setString(3,disease1);
    ps.setString(4,disease2);
    ps.setString(5,weight);
    ps.setString(6,name);
   int k=0;
    k=ps.executeUpdate();
    RequestDispatcher rd=req.getRequestDispatcher("proj.html");
    rd.forward(req,res); 
  }
  catch(Exception e)
  {
   pw.println(e);
  }
  pw.close();
 }
}