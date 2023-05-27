package servelt_login_validation.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servelt_login_validation.dao.Employeedao;
import servelt_login_validation.dto.EmployeeDto1;



@WebServlet("/signup")
public class Employeecontroller extends HttpServlet {
 @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	//super.doPost(req, resp);
	 
	 String name=req.getParameter("name");
	 String email=req.getParameter("email");
	 String password=req.getParameter("pwd");
	 
	 
	 
	 EmployeeDto1 dto=new  EmployeeDto1();
	 dto.setName(name);
	 dto.setEmail(email);
	 dto.setPassword(password);
	 
	 
	 
	 Employeedao dao=new Employeedao();
	 String msg=dao.create(dto);
	 resp.getWriter().print(msg);
	 
}
}
