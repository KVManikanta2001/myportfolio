package p1;
import java.sql.*;
import javax.servlet.http.*;
public class LoginDao
{
	public RegisterBean rb = null;
	public RegisterBean login(HttpServletRequest req)
	{
		try
		{
			Connection con =DBConnection.getcon();
			PreparedStatement ps = con.prepareStatement
			("select * from register where email=? AND password=?");
			ps.setString(1,req.getParameter("uname"));
			ps.setString(2 ,req.getParameter("pword"));
			ResultSet rs =ps.executeQuery();
			if(rs.next())
			{
				rb = new RegisterBean();
				rb.setFirstname(rs.getString(1));
				rb.setLastname(rs.getString(2));
				rb.setEmail(rs.getString(3));
				rb.setPassword(rs.getString(4));
				
			}
		}
		catch(Exception e) {e.printStackTrace();}
		return rb;
	}
}
