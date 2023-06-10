package pages;

import java.io.BufferedReader;
import java.io.FileReader;
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
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init register");
	}

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in get register");
		response.setContentType("text/html");
		// TODO Auto-generated method stub
		try(BufferedReader br=new BufferedReader(new FileReader("G:\\WBJSourabhPranav\\day2.1\\src\\main\\java\\pages\\registration.html"));
				PrintWriter pw=response.getWriter();){
			br.lines().forEach((p)->{
				pw.print(p);
				
			});
		}
		
		
	}

}
