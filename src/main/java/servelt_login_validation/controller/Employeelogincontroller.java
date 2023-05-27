package servelt_login_validation.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;import org.apache.tomcat.util.descriptor.web.LoginConfig;

import servelt_login_validation.dao.Employeedao;
import servelt_login_validation.dto.EmployeeDto1;



@WebServlet("/loginn")
public class Employeelogincontroller extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doGet(req, resp);

		String mail = req.getParameter("emaill");
		String password1 = req.getParameter("pwdd");
		
		Employeedao dao = new Employeedao();
		EmployeeDto1 d1 = dao.login(mail);

		if (d1 != null) {
			if (d1.getPassword().equals(password1)) {
				resp.getWriter().print("<h1>welcome to home page</h1>");
				
				//resp.sendRedirect("http://www.facebook.com");
			} else {
				resp.getWriter().print("<h1> enter proper password</h1>");
				RequestDispatcher dis=req.getRequestDispatcher("login.html");
				
				dis.include(req, resp);
				
			}
		} else {
			resp.getWriter().print("<h1> account not found,please signup</h1><a href='signup.html'>click here to signup</a>");

		}

	}
}
//what is the difference b/w doget and dopost
//what is the difference b/w reqdispacther and sendredirect
//what is the difference b/w forward and include
