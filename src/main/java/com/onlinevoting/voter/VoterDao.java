package com.onlinevoting.voter;

import java.io.IOException;
import java.sql.SQLException;

import com.onlinevoting.jdbc.VoterData;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/voterdao")
public class VoterDao extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		HttpSession session = request.getSession();
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		VoterData voterData = new VoterData();
		if(voterData.checkName(name, password))
		{
			try {
				String biodata = voterData.getDetails(name, password);
				String[] arr = biodata.split(",");
				session.setAttribute("name", arr[0]);
				session.setAttribute("age", arr[1]);
				session.setAttribute("mobile", arr[2]);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			//System.out.println(voterData.getName() + " "+voterData.getAge());
//			session.setAttribute("name", voterDetails.getName());
//			session.setAttribute("password", voterDetails.getPassword());
//			session.setAttribute("age", voterDetails.getAge());
//			session.setAttribute("mobile", voterDetails.getMobile());
			try {
				if(voterData.getstatus(name))
				{
					response.sendRedirect("alreadyvoted.jsp");
				}
				else
				{
					response.sendRedirect("afterLogin.jsp");
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		else
		{	
			response.sendRedirect("errorpage.jsp");
		}
	} 
}
