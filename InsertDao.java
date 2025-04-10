package p1;
import java.sql.*;
public class InsertDao 
{
	public int k=0;
	public int insert(RegisterBean rb)
	{
		try
		{
			Connection con = DBConnection.getcon();
			PreparedStatement ps =con.prepareStatement
			("insert into register values(?,?,?,?)");
			
			ps.setString(1, rb.getFirstname());
			ps.setString(2, rb.getLastname());
			ps.setString(3, rb.getEmail());
			ps.setString(4, rb.getPassword());
			
			k = ps.executeUpdate();
		}
		catch(Exception e) {e.printStackTrace();}
		return k;
	}
}
