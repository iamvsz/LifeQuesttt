import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class Logout extends HttpServlet
{
 public void doGet(HttpServletRequest req,HttpServletResponse res)
 throws ServletException,IOException
  {
   res.setContentType("text/html");
   PrintWriter pw=res.getWriter();
   RequestDispatcher rd=req.getRequestDispatcher("proj.html");
    rd.forward(req,res);
   Cookie ck=new Cookie ("username","");
   ck.setMaxAge(0);
   res.addCookie(ck);
   pw.println("You are Succesfully Logout");
  }
}