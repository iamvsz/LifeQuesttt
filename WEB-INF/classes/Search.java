import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class Search extends HttpServlet
{
 protected void doPost
 (HttpServletRequest req,HttpServletResponse res)
 throws ServletException,IOException
 {
  PrintWriter pw=res.getWriter();
  res.setContentType("text/html");
  String bloodgroup=req.getParameter("bloodgroup");
 String city=req.getParameter("city");
  try
   {
    Class.forName("oracle.jdbc.driver.OracleDriver");
    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##swapnil","Swapnil");
    PreparedStatement ps=con.prepareStatement("select * from donor where bloodgroup=? and city=?");
 ps.setString(1,bloodgroup);
 ps.setString(2,city);
ResultSet rs=ps.executeQuery();
pw.println("<html><body>");
   pw.println("<head>");
pw.println("<link rel='stylesheet' type= 'text/css' href='table.css'>");
pw.println("</head>");
pw.println("<div class='vs'>");
    pw.println("<table border=1px,align='center' id='customers'>");
    
    pw.println("<th>");
 pw.println("Name");
pw.println("</th>");
pw.println("<th>");
 pw.println("Email");
pw.println("</th>");
pw.println("<th>");
 pw.println("Contact");
pw.println("</th>");
pw.println("</tr>");
while(rs.next())
{
  String name=rs.getString(1);
   String email=rs.getString(6);
   String no=rs.getString(9);

pw.println("<tr>");
pw.println("<td>");
pw.println(name);
pw.println("</td>");
pw.println("<td>");
pw.println(email);
pw.println("</td>");
pw.println("<td>");
pw.println(no);
pw.println("</td>");
}

RequestDispatcher rd= req.getRequestDispatcher("ds.html");
     rd.include(req,res);
pw.println("</table>");
pw.println("</div>");
 pw.println("</body></html>");


 }


  catch(Exception e)
 {
   pw.println(e);
  }
  pw.close();
 }
}



















































