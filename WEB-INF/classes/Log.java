import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class Log extends HttpServlet
{
 protected void doPost
 (HttpServletRequest req,HttpServletResponse res)
 throws ServletException,IOException
 {
  PrintWriter pw=res.getWriter();
  res.setContentType("text/html");
  String Apos =req.getParameter("Apos");
  String Aneg =req.getParameter("Aneg");
  String Bpos =req.getParameter("Bpos");
  String Bneg =req.getParameter("Bneg");  
  String ABpos =req.getParameter("ABpos");
  String ABneg =req.getParameter("ABneg");
  String Opos =req.getParameter("Opos");
  String Oneg =req.getParameter("Oneg");
    try
   {
    Class.forName("oracle.jdbc.driver.OracleDriver");
    Connection con=DriverManager.getConnection    ("jdbc:oracle:thin:@localhost:1521:orcl","c##swapnil","Swapnil");
    PreparedStatement ps=con.prepareStatement("insert into log3 values(?,?,?,?,?,?,?,?)");
    ps.setString(1,Apos);
    ps.setString(2,Aneg);
    ps.setString(3,Bpos);
    ps.setString(4,Bneg);
    ps.setString(5,ABpos);
    ps.setString(6,ABneg);
    ps.setString(7,Opos);
    ps.setString(8,Oneg);
    ResultSet rs=ps.executeQuery();
     if(rs.next())
    {
    pw.println("Data Entered Succesfully");
    RequestDispatcher rd=req.getRequestDispatcher("log.html");
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