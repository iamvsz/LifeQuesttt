import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class Camp extends HttpServlet
{
 protected void doPost
(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
 {
  PrintWriter pw=res.getWriter();
  res.setContentType("text/html");

  String oraganiser=req.getParameter("oraganiser");
  String dat=req.getParameter("dat");
  String contact1=req.getParameter("contact1");  
  String address=req.getParameter("address");

   try
   {
    Class.forName("oracle.jdbc.driver.OracleDriver");
    Connection con=DriverManager.getConnection    ("jdbc:oracle:thin:@localhost:1521:orcl","c##swapnil","Swapnil");

    PreparedStatement ps=con.prepareStatement("insert into camp values(?,?,?,?)");

    ps.setString(1,oraganiser);
    ps.setString(2,dat);
    ps.setString(3,contact1);
    ps.setString(4,address);

    ResultSet rs=ps.executeQuery();

     while(rs.next())
    {
      PreparedStatement ps2=con.prepareStatement("select * from donor");
      ResultSet rs1=ps2.executeQuery();

      while(rs1.next())
      {
         String donorName = rs1.getString(1);
         String mobile=rs1.getString(9);

         SmsService.sendSms(mobile,"Dear " + donorName + ", There will be Blood camp organized by "+ oraganiser + " at "+address + " on "+dat);
       }

    pw.println("You are succesfully Enrolled");
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