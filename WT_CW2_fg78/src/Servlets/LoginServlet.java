package Servlets;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Commissioner.CommDAO;
import Commissioner.CommDAOImplementer;
import Commissioner.Commissioner;
import Voter.Voter;
import Voter.VoterDAO;
import Voter.VoterDAOImplementer;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
            }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VoterDAO voterDAO = new VoterDAOImplementer();
		CommDAO commDAO = new CommDAOImplementer();
		String userID = request.getParameter("userID");
		String password = request.getParameter("password");
		
		Voter v = voterDAO.getVoter(userID, password);
		Commissioner c = commDAO.getCommissioner(userID, password);
		
		if(v!=null && v.getUserID()!=null && v.getPassword() != null) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		} else if (c!=null && c.getUserID() != null && c.getPassword() != null) {
			request.getRequestDispatcher("commIndex.jsp").forward(request, response);

		} else {
			request.setAttribute("login_message", "Incorrect details entered, please try again");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		
		
		
		
		
		
		
		
	}

}
