

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.itextpdf.text.Document;  
import com.itextpdf.text.DocumentException;  
import com.itextpdf.text.Paragraph;  
import com.itextpdf.text.pdf.PdfWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Createpric
 */
public class Createpric extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Createpric() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con =DbConnection.connect();
		int acc=0;
		String PFname=request.getParameter("PFname");
		String PLname=request.getParameter("PLname");
		String gen=request.getParameter("gen");
		String dob=request.getParameter("dob");
		String store=request.getParameter("store");
		String m1=request.getParameter("m1");
		String m2=request.getParameter("m2");
		String m3=request.getParameter("m3");
		String m4=request.getParameter("m4");
		String m5=request.getParameter("m5");
		String mq1=request.getParameter("mq1");
		String mq2=request.getParameter("mq2");
		String mq3=request.getParameter("mq3");
		String mq4=request.getParameter("mq4");
		String mq5=request.getParameter("mq5");
		String Add1=request.getParameter("Add1");
		String Add2=request.getParameter("Add2");
		String state=request.getParameter("state");
		String Postal=request.getParameter("Postal");
		String Pcity=request.getParameter("Pcity");
		String coun=request.getParameter("coun");
		Document doc = new Document();  
		try  
		{  
			String s1="D:\\"+PFname+PLname+"_"+dob+".pdf";
		PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(s1));  
		System.out.println("PDF created.");  
		//opens the PDF  
		doc.open();  
		doc.add(new Paragraph("Name-"+PFname+" "+PLname));
//		doc.add(new Paragraph(age));
//		doc.add(new Paragraph(Enum));  
		doc.add(new Paragraph("Gender:"+gen+"                                                        "+"Dob"+dob));  
		doc.add(new Paragraph(m1+" "+mq1));
		doc.add(new Paragraph(m2+" "+mq2));
		doc.add(new Paragraph(m3+" "+mq3));
		doc.add(new Paragraph(m4+" "+mq4));
		doc.add(new Paragraph(m5+" "+mq5));

		//close the PDF file  
		doc.close();  
		//closes the writer  
		writer.close();  
		
		}   
		catch (DocumentException e)  
		{  
		e.printStackTrace();  
		}   
		catch (FileNotFoundException e)  
		{  
		e.printStackTrace();  
		} 
		try {
			String s="insert into prec values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement pst=con.prepareStatement(s);
			pst.setInt(1, 0);
			pst.setString(2, PFname);
			pst.setString(3, PLname);
			pst.setString(4, gen);
			pst.setString(5, dob);
			pst.setString(6, store);
			pst.setString(7, m1);
			pst.setString(8, mq1);
			pst.setString(9, m2);
			pst.setString(10, mq2);
			pst.setString(11, m3);
			pst.setString(12, mq3);
			pst.setString(13, m4);
			pst.setString(14, mq4);
			pst.setString(15, m5);
			pst.setString(16, mq5);
			pst.setString(17, Add1+Add2);
			pst.setString(18, state);
			pst.setString(19,Postal);
			pst.setString(20,Pcity);
			pst.setString(21,coun);
			int i =pst.executeUpdate();
			if(i>0){
	
				response.sendRedirect("doctordashbord.jsp");
				
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
