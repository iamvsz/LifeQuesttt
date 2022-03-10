import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class Question extends HttpServlet
{
 protected void doPost
 (HttpServletRequest req,HttpServletResponse res)
 throws ServletException,IOException
 {
  PrintWriter pw=res.getWriter();
  res.setContentType("text/html");
 String username=req.getParameter("username");
 String password=req.getParameter("password");

  String birthplace=req.getParameter("birthplace");
  String firstschool=req.getParameter("firstschool");
  String favmeal=req.getParameter("favmeal");
  String favsport=req.getParameter("favsport");
 
   try
   {
    Class.forName("oracle.jdbc.driver.OracleDriver");
    Connection con=DriverManager.getConnection    ("jdbc:oracle:thin:@localhost:1521:orcl","c##swapnil","Swapnil");
    PreparedStatement ps=con.prepareStatement("insert into question values(?,?,?,?,?,?)");
     ps.setString(1,username);
     ps.setString(2,password);
    ps.setString(3,birthplace);
    ps.setString(4,firstschool);
    ps.setString(5,favmeal);
    ps.setString(6,favsport);
    
    ResultSet rs=ps.executeQuery();

	if(rs.next())
	   {
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