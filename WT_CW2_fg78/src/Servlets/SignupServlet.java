package Servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BIC.BIC;
import BIC.BICDAO;
import BIC.BICDAOImplementer;
import Connector.myConnectorClass;
import Voter.Voter;
import Voter.VoterDAO;
import Voter.VoterDAOImplementer;

public class SignupServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest req,
			 HttpServletResponse res)
			 throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String userID = req.getParameter("userID");
		String pword = req.getParameter("password");
		String bic = req.getParameter("bic");
		String dob = req.getParameter("dob");
		String address = req.getParameter("address");
		String city = req.getParameter("city");
		String state = req.getParameter("state");
		String postcode = req.getParameter("postcode");
	
		//check BIC is in the DB
		//check BIC hasn't already registered
		//store password as #MD5
		PrintWriter pw = res.getWriter();

		try( Connection connect = myConnectorClass.getConnection();)
				{
				BICDAO bd = new BICDAOImplementer();
				BIC b = bd.getBIC(bic, 0);
				
				if(b == null){
					req.setAttribute("signup_message", "BIC already exists or cannot be found");
					req.getRequestDispatcher("signup.jsp").forward(req, res);
				}
				
				if(b!=(null)){
					
				Voter v = new Voter();
				VoterDAO vd = new VoterDAOImplementer();
				
				if (vd.getVoter(userID, pword) != null)
					{					
					req.setAttribute("signup_message", "User I.D. already exists");
					req.getRequestDispatcher("signup.jsp").forward(req, res);
					}
				v.setName(name);
				v.setUserID(userID);
				v.setPassword(pword);
				v.setBic(bic);
				v.setDob(dob);
				v.setAddress(address);
				v.setCity(city);
				v.setState(state);
				v.setPostcode(postcode);
				
				vd.insertVoter(v);
				bd.useBIC(bic);
				
				req.setAttribute("login_message", "Sign up successful");
				req.getRequestDispatcher("login.jsp").forward(req, res);
				
				}
					
		}catch(Exception ex){
			 pw.println("Error");
			 ex.printStackTrace();
			 }
	}
	
}
