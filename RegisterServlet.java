package p1;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
@WebServlet("/Register")
public class RegisterServlet extends HttpServlet
{
	public void service(HttpServletRequest req ,HttpServletResponse res)
	throws ServletException,IOException
	{		
		
			RegisterBean rb = new RegisterBean();
			rb.setFirstname(req.getParameter("fname"));
			rb.setLastname(req.getParameter("lname"));
			rb.setEmail(req.getParameter("email"));
			rb.setPassword(req.getParameter("pword"));
			
			int k = new InsertDao().insert(rb);
			
			if(k>0)
			{
				
				req.getRequestDispatcher("response.jsp").forward(req, res);
			}
			else
			{
				PrintWriter pw =res.getWriter();
				pw.print("Something Error");
			}
			
	}
}
