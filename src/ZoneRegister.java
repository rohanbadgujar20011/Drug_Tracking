

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class ZoneRegister
 */
public class ZoneRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ZoneRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con =DbConnection.connect();
		int acc=0;
		String name=request.getParameter("ZoneName1");
		String state=request.getParameter("ZoneName2");
		String pass=request.getParameter("password");
		String s="insert into zoneregister values(?,?,?,?)";
		System.out.println(name);
		System.out.println(state);
		System.out.println(pass);
		
		try {
			PreparedStatement pst=con.prepareStatement(s);
			pst.setInt(1, acc);
			pst.setString(2, name);
			pst.setString(3,state);
			pst.setString(4, pass);
			int i =pst.executeUpdate();
			if(i>0){
	
				response.sendRedirect("admindashbords.jsp");
				
			}
			else{
				
			}
		} catch (SQLException e) {
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
