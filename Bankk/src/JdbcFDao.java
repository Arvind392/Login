import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcFDao {
	Model m;
	

	public boolean display(String cid, String password) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "123456");
		PreparedStatement psmt = con.prepareStatement("select * from demo.bankdata where custid=? and password=?");
		psmt.setString(1, cid);
		psmt.setString(2, password);
		ResultSet res = psmt.executeQuery();
		res.next();
		String name = res.getString(2);
		m.setName(name);

		return true;

	}

	{

	}

}
