package com.onlinevoting.admin;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/adminlogin")
public class AdminloggingIn extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	{
		String name = request.getParameter("admin");
		String password = request.getParameter("adminpassword");
		AdminAccess access = new AdminAccess();
		try {
			if(access.checkadmin(name, password))
			{
				response.sendRedirect("adminpage.jsp");
			}
			else
				response.sendRedirect("adminerrorpage.jsp");
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
	}
}
