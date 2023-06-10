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

import dao.Candidatedao;
import dao.UserDao;
import pojos.User;

/**
 * Servlet implementation class LogServlet
 */
@WebServlet("/logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			pw.print("<h5>In logout page ....</h5>");
			HttpSession hs = request.getSession();
			User voter = (User) hs.getAttribute("user_details");
			if (voter != null) {
				if (voter.isVotingStatus()) {
					pw.print("<h5> You have already voted !!!!!</h5>");
				} else {
					int candid = Integer.parseInt(request.getParameter("cid"));
					UserDao userDao = (UserDao) hs.getAttribute("user_Dao");
					Candidatedao canDao = (Candidatedao) hs.getAttribute("candidate_Dao");

					pw.print("<h3>" + userDao.updateVotingStatus(voter.getId()) + "</h3>");
					pw.print("<h3>" + canDao.incrementCandidateVotes(candid) + "</h3>");
				}
			}
			else {
				pw.print("<h5>No session Tracking !!!!</h5>");
			// invalidate session
			hs.invalidate();
			pw.print("<h5> You have been logged out.....</h5>");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
