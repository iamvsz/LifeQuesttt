import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class Forgot extends HttpServlet
{
 protected void doPost
 (HttpServletRequest req,HttpServletResponse res)
 throws ServletException,IOException
 {
  PrintWriter pw=res.getWriter();
  res.setContentType("text/html");
  String birthplace=req.getParameter("birthplace");
  String firstschool=req.getParameter("firstschool");
  String favmeal=req.getParameter("favmeal");
  String favsport=req.getParameter("favsport");
  try
   {
    Class.forName("oracle.jdbc.driver.OracleDriver");
    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##swapnil","Swapnil");
    PreparedStatement ps=con.prepareStatement("select * from question where birthplace=? and firstschool=? and favmeal=? and favsport=?");
 ps.setString(1,birthplace);
  ps.setString(2,firstschool);
 ps.setString(3,favmeal);
  ps.setString(4,favsport);
ResultSet rs=ps.executeQuery();
  if(rs.next())
  {
   pw.println("You are Username is=="+rs.getString(1)+"\t\t And Your Password is=="+rs.getString(2));
  }
 
else
  {
   pw.println("Invalid Information");
   RequestDispatcher rd=req.getRequestDispatcher("bloodbank_login.html");
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
