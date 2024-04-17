package com.onlinevoting.votestatus;

import java.io.IOException;
import java.sql.SQLException;

import com.onlinevoting.jdbc.VoterData;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/votestatus")
public class VoteStatus extends HttpServlet{

	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	{
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
		VoterData data = new VoterData();
		try {
			if(data.checkStatus(name))
			{
				response.sendRedirect("votesucces.jsp");	
			}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
	}
}
