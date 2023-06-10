package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDaoImpl;

/**
 * Servlet implementation class registration
 */
@WebServlet("/registration")
public class registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl userDao;
	
	
	
	
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init() throws ServletException {
		try {
			// create dao instance
			userDao = new UserDaoImpl();
		} catch (Exception e) {
			// re throw the exc to the caller (WC) , so that WC DOES NOT continue with the
			// rest of the servlet life cycle
			throw new ServletException("err in init of " + getClass(), e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		try(PrintWriter pw=response.getWriter();){
			
			String fname=request.getParameter("fnm");
			String lname=request.getParameter("lnm");
			Date dob=Date.valueOf(request.getParameter("dob"));
			String email=request.getParameter("em");
			String pass=request.getParameter("pass");
			System.out.println(fname+lname+dob+email+pass);
			
			String status="";
			try {
				status = userDao.Insertuser(email,pass,fname,lname,dob);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pw.print(status);
			System.out.println(status);
			
//			pw.print("user added to db");
			
		}
		
		
		
		// TODO Auto-generated method stub
	}

}
