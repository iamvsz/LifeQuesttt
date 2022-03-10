import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class SearchBank extends HttpServlet
{
 protected void doPost
 (HttpServletRequest req,HttpServletResponse res)
 throws ServletException,IOException
 {
  PrintWriter pw=res.getWriter();
  res.setContentType("text/html");
  String city=req.getParameter("city");
  try
   {
    Class.forName("oracle.jdbc.driver.OracleDriver");
    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##swapnil","Swapnil");
    PreparedStatement ps=con.prepareStatement("select * from bloodbank where city=?");
 ps.setString(1,city);
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
   String email=rs.getString(4);
   String contact=rs.getString(6);

pw.println("<tr>");
pw.println("<td>");
pw.println(name);
pw.println("</td>");
pw.println("<td>");
pw.println(email);
pw.println("</td>");
pw.println("<td>");
pw.println(contact);
pw.println("</td>");
}

RequestDispatcher rd= req.getRequestDispatcher("searchinfo.html");
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



















































