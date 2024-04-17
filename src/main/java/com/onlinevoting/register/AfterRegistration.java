package com.onlinevoting.register;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

@MultipartConfig
@WebServlet("/afterregister")
public class AfterRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String name = request.getParameter("name");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		int age = Integer.parseInt(request.getParameter("age"));
		String mobile = request.getParameter("mobile");

		Part file = request.getPart("myfile");
		String imagefile = file.getSubmittedFileName();
		String uploadpath = "C:/Users/apras/OnlineVotingSystem/images/" + imagefile;
		HttpSession session = request.getSession();
		session.setAttribute("imagefile", imagefile);
		session.setAttribute("imagepath", "C:/Users/apras/OnlineVotingSystem/images/");
		try {
			FileOutputStream fos = new FileOutputStream(uploadpath);
			InputStream is = file.getInputStream();
			byte[] data = new byte[is.available()];
			is.read(data);
			fos.write(data);
			fos.close();

			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/voter", "root", "........");
			PreparedStatement st = con.prepareStatement("insert into vote(location) values(?)");
			st.setString(1, imagefile);
			st.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (password1.equalsIgnoreCase(password2)) {
			try {

				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Voter", "root", "........");				
				PreparedStatement st = con
						.prepareStatement("insert into vote(name,password,age,mobile,location) values (?,?,?,?,?)");
				st.setString(1, name);
				st.setString(2, password1);
				st.setInt(3, age);
				st.setString(4, mobile);
				st.setString(5, imagefile);
				st.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			response.sendRedirect("passwordsunmatch.jsp");
		}
		
		response.sendRedirect("registrationsuccesful.jsp");
		
	}
}
