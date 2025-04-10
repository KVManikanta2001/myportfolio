package p1;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@WebServlet("/login")
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet
{
	public void service(HttpServletRequest req , HttpServletResponse res)
	throws ServletException,IOException
	{
		RegisterBean rb = new LoginDao().login(req);
		if(rb==null)
		{
			req.setAttribute("msg","invalid Login Process...</br>");
			req.getRequestDispatcher("invalid.jsp").forward(req, res);
		}
		else
		{
			HttpSession hs = req.getSession();
			hs.setAttribute("rb",rb);
			req.getRequestDispatcher("Home.html").forward(req, res);
		}
	}
}
