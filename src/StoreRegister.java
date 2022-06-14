

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StoreRegister
 */
public class StoreRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con =DbConnection.connect();
		int acc=0;
		String name=request.getParameter("SName1");
		String email=request.getParameter("SEmail");
		String add=request.getParameter("SAddress");
		String postal=request.getParameter("postal");
		String zone=request.getParameter("zone");
		String pass=request.getParameter("password");
		String s="insert into storeregister values(?,?,?,?,?,?,?)";
		System.out.println(name);
		System.out.println(email);
		System.out.println(add);
		
		try {
			PreparedStatement pst=con.prepareStatement(s);
			pst.setInt(1, acc);
			pst.setString(2, name);
			pst.setString(3,email);
			pst.setString(4, add);
			pst.setString(5, postal);
			pst.setString(6, zone);
			pst.setString(7,pass);
			int i =pst.executeUpdate();
			if(i>0){
	
				response.sendRedirect("zonedashbord.jsp");
				
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
