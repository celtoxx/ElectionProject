package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try(PrintWriter pw=response.getWriter();){
			pw.print("<!DOCTYPE html>\r\n"
					+ "<html>\r\n"
					+ "<head>\r\n"
					+ "<meta charset=\"UTF-8\" />\r\n"
					+ "<title>Registration Form</title>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "	<form action=\"registration\" method=\"post\">\r\n"
					+ "		<table style=\"background-color: lightgrey; margin: auto\">\r\n"
					+ "			<tr>\r\n"
					+ "				<td>Enter First Name</td>\r\n"
					+ "				<td><input type=\"text\" name=\"fnm\" /></td>\r\n"
					+ "			</tr>\r\n"
					+ "			<tr>\r\n"
					+ "				<td>Enter Last Name</td>\r\n"
					+ "				<td><input type=\"text\" name=\"lnm\" /></td>\r\n"
					+ "			</tr>\r\n"
					+ "			<tr>\r\n"
					+ "				<td>Enter DOB</td>\r\n"
					+ "				<td><input type=\"text\" name=\"dob\" /></td>\r\n"
					+ "			</tr>\r\n"
					+ "			<tr>\r\n"
					+ "				<td>Enter User Email</td>\r\n"
					+ "				<td><input type=\"text\" name=\"em\" /></td>\r\n"
					+ "			</tr>\r\n"
					+ "			<tr>\r\n"
					+ "				<td>Enter Password</td>\r\n"
					+ "				<td><input type=\"password\" name=\"pass\" /></td>\r\n"
					+ "			</tr>\r\n"
					+ "			<tr>\r\n"
					+ "				<td><button type=\"submit\" id=\"btn\"  name=\"btn\" value=\"Add User\" >Add Voter</button></td>\r\n"
					+ "			</tr>\r\n"
					+ "		</table>\r\n"
					+ "	</form>\r\n"
					+ "</body>\r\n"
					+ "</html>");
		}
		
		
	}

}
