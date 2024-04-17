package com.onlinevoting.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/adminfunctions")
public class AdminFunctions extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminAccess access = new AdminAccess();

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String action = request.getParameter("submit");
		String name = request.getParameter("name");
		PrintWriter writer = response.getWriter();
		

		switch (action) {
		case "GetVoters":
			try {
				ArrayList<String> list1 = access.checkVotersList();
				System.out.println(list1);
				for(String i: list1)
				{
					writer.println(i+" ");
					
				}
				
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		case "Voted":
			try {
				ArrayList<String> list2 = access.getVoted();
				System.out.println(list2);

				for(String i:list2)
				{
					writer.println(i+"  ");
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		case "UnVoted":
			try {
				ArrayList<String> list3 = access.getUnVoted();
				System.out.println(list3);

				writer.println("something");
				for(String i:list3)
				{
					writer.println(i+"  ");
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		case "Remove Voter":
			try {
				if(access.remove(name))
				{
					writer.println("record deleted");
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
