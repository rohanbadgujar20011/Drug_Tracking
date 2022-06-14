

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class Inventryzone
 */
public class Inventryzone extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inventryzone() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection con =DbConnection.connect();
		int a=0;
		String zone=request.getParameter("zone");
		String m1=request.getParameter("m1");
		String quan=request.getParameter("quan");
		try{
			String s="select Quantity from zoneinven where Medicine=?";
			PreparedStatement pst=(PreparedStatement) con.prepareStatement(s);
			pst.setString(1, m1);
			ResultSet rt=pst.executeQuery();
			if(rt.next()){
				int i=rt.getInt("Quantity");
				
				String s1="update zoneinven set Quantity=? where Medicine=?";
				PreparedStatement pstm=(PreparedStatement) con.prepareStatement(s1);
				pstm.setInt(1, i-Integer.parseInt(quan));
				pstm.setString(2,m1);
				int r=pstm.executeUpdate();
				if(r>0){
					String s2="insert into storeinven values(?,?,?,?)";
					PreparedStatement pstmt=(PreparedStatement) con.prepareStatement(s2);
					pstmt.setInt(1, a);
					pstmt.setString(2, zone);
					pstmt.setString(3, m1);
					pstmt.setInt(4, Integer.parseInt(quan));
					int r1=pstmt.executeUpdate();
					if(r1>0){
						response.sendRedirect("zonedashbord.jsp");
					}
					else{
						response.sendRedirect("Inventry.jsp");
					}
					}
					
					
					
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
