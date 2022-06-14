

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class LoginZone
 */
public class LoginZone extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginZone() {
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
		
			String s="select * from zoneregister where ZName=? and password=?";
			PreparedStatement pst=(PreparedStatement) con.prepareStatement(s);
			pst.setString(1, Email);
			pst.setString(2, password);
			ResultSet rt=pst.executeQuery();
			if(rt.next()){
				response.sendRedirect("zonedashbord.jsp");
			}
			else{
				response.sendRedirect("zonelogin.jsp");
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
