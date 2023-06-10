package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CandidateDaoImpl;
import dao.Candidatedao;
import pojos.Candidate;
import pojos.User;

/**
 * Servlet implementation class CandidateListServlet
 */
@WebServlet("/candidate_list")
public class CandidateList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
//			
//		
			pw.print("<h5>In candidate c list pages ....</h5>");
			HttpSession hs = request.getSession();
			System.out.println("is new ?" + hs.isNew());// f
			System.out.println("session id " + hs.getId());
			User userDetails = (User) hs.getAttribute("user_details");
			if (userDetails != null) {
				pw.print("<h5> Hello , " + userDetails.getFirstName() + " " + userDetails.getLastName() + "</h5>");

				CandidateDaoImpl cdao = (CandidateDaoImpl) hs.getAttribute("candidate_Dao");
				List<Candidate> candidateList = cdao.getAllCandidate();
				// dynamic form generation
				pw.print("<form action='logout'>");
				for (Candidate c : candidateList)
					pw.print("<h5> <input type='radio' name='cid' value='" + c.getCandidateid() + "'/>" + c.getName()
							+ "</h5>");
				pw.print("<h5><input type='submit' value='Cast A Vote'/></h5>");
				pw.print("</form>");

			} else {
				pw.print("<h5> Session Tracking Failed , No Cookies!!!!!!!!!!!!!</h5>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
