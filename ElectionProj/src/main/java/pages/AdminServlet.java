package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CandidateDaoImpl;
import pojos.User;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/admin_page")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		try(PrintWriter pw=response.getWriter()) {
			HttpSession hs=request.getSession();
			User admin=(User)hs.getAttribute("user_details");
			if(admin!=null) {
				
				pw.print("<h5> Hello admin , " + admin.getFirstName() +  "</h5>");
				
				CandidateDaoImpl cdao = (CandidateDaoImpl) hs.getAttribute("candidate_Dao");
				
				String[] parties=cdao.getToptwoParties();
				pw.print("parties and votes:");
				for(String c:parties) {
					pw.print(c+"  ");
				}
				
				
				
			}
			
			
			
			
			
			pw.print("<h5>In admin page ....</h5>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
