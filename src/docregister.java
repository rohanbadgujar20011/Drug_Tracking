

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class docregister
 */
public class docregister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public docregister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con =DbConnection.connect();
		int acc=0;
		String Lnum=request.getParameter("LNum");
		String Name=request.getParameter("DName");
		String clinicaddress=request.getParameter("CAddress");
		String Email=request.getParameter("Email");
		String postal=request.getParameter("postal");
		String zone=request.getParameter("zone");
		String password=request.getParameter("password");
		String s="insert into doctors values(?,?,?,?,?,?,?,?)";
	
		
		try {
			PreparedStatement pst=con.prepareStatement(s);
			pst.setInt(1, acc);
			pst.setString(2, Lnum);
			pst.setString(3,Name);
			pst.setString(4, clinicaddress);
			pst.setString(5, Email);
			pst.setString(6, postal);
			pst.setString(7, zone);
			
			
			pst.setString(8, password);
			int i =pst.executeUpdate();
			if(i>0){
	
				response.sendRedirect("doclogin.jsp");
				
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
