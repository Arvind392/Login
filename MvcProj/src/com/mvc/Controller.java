package com.mvc;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Controller")
public class Controller extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String id = req.getParameter("id");
		try {
			Model m = new Model();
			m.setId(id);
			m.display();
			String sid = m.getId();
			String name = m.getName();
			int marks = m.getMarks();

			HttpSession session = req.getSession(true);
			session.setAttribute("sid1", sid);
			session.setAttribute("name1", name);
			session.setAttribute("marks1", marks);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		res.sendRedirect("View.jsp");
		

	}
}
