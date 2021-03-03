

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	String name=request.getParameter("cid");
	String password=request.getParameter("password");
	Model m=new Model();
	String name1=m.getName();
	JdbcFDao dao=new JdbcFDao();
	
	try {
		boolean value=dao.display(name, password);
		if(value==true)
		{
			HttpSession session=request.getSession(true);
			session.setAttribute(name, name1);
			response.sendRedirect("loginSuccessful.jsp");
		}
		else
		{
			response.sendRedirect("loginFailed.jsp");
		}
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

}
