

import java.io.IOException;
import Cred.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class Loginstore
 */
public class Loginstore extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loginstore() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con =DbConnection.connect();
		String Email=request.getParameter("Email");
		String password=request.getParameter("password");
		System.out.println(Email);
		System.out.println(password);
		try{
		
			String s="select * from storeregister where Email=? and password=?";
			PreparedStatement pst=(PreparedStatement) con.prepareStatement(s);
			pst.setString(1, Email);
			pst.setString(2, password);
			ResultSet rt=pst.executeQuery();
			if(rt.next()){
				ABC.setEmail(Email);
				response.sendRedirect("storedashbord.jsp");
			}
			else{
				response.sendRedirect("storelogin.jsp");
			}
				
			}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
