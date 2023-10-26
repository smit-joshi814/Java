package moduleStudent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

import conPkg.ConnectionProvider;

/**
 * Servlet implementation class GeneratePdf
 */
@WebServlet("/GeneratePdf")
public class GeneratePdf extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GeneratePdf() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// get the output stream for writing binary data in the response.
		ServletOutputStream os = response.getOutputStream();
		// set the response content type to PDF
		response.setContentType("application/pdf");
		// create a new document
		Document doc = new Document();
		ResultSet rs;
		PreparedStatement ps;
		// create some special styles and font sizes
		Font bfBold18 = new Font(FontFamily.TIMES_ROMAN, 18, Font.BOLD, new BaseColor(0, 0, 0));
		Font bfBold12 = new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLD, new BaseColor(0, 0, 0));
		Connection conn = ConnectionProvider.getCon();
		String sql = null;

		
		 
		
		 
		try {

			// create an instance of the PdfWriter using the output stream
			PdfWriter.getInstance(doc, os);
			
			
			// document header properties
			doc.addCreationDate();
			doc.addProducer();
			doc.addCreator("SMit");
			doc.addTitle("Inovince");
			doc.setPageSize(PageSize.A4);
			doc.open();
			sql = "SELECT * FROM `institute`";
			ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.TYPE_SCROLL_SENSITIVE);
			rs=ps.executeQuery();
			rs.next();
			// add a new paragraph
			//doc.add(new Paragraph("Innovance", bfBold18));
			doc.add(new Paragraph(rs.getString(2),bfBold18));
			doc.add(new Paragraph(rs.getString(3),bfBold18));
			doc.add(Chunk.NEWLINE);
			doc.add(new LineSeparator());

			// connection to the MySQL database
			// Context ctx = (Context) new InitialContext().lookup("java:comp/env");

			// just get 10 countries from my database for demo
			sql = "Select * from student WHERE student_id=?";
			ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.TYPE_SCROLL_SENSITIVE);
			ps.setString(1, request.getParameter("sid"));
			rs = ps.executeQuery();

			// Move cursor to the first row

			while (rs.next()) {
				ps = conn.prepareStatement("SELECT course_name FROM cources WHERE course_id=?");
				ps.setString(1, rs.getString("course_id"));
				ResultSet rs1 = ps.executeQuery();
				rs1.next();
				doc.add(new Paragraph("Name : " + rs.getString("student_name").trim(), bfBold12));
				doc.add(new Paragraph("Address: " + rs.getString("address").trim(), bfBold12));
				doc.add(new Paragraph("Fees Paid: " + rs.getString("Fees_Paid").trim(), bfBold12));
				if (!rs.getString("Fees_due").equals("0")) {
					doc.add(new Paragraph("Fees Due: " + rs.getString("Fees_due").trim(), bfBold12));
				}
				doc.add(new Paragraph("course: " + rs1.getString("course_name").trim(), bfBold12));
				doc.add(new Paragraph("Fees received Date: " + rs.getString("dateUpdated").trim(), bfBold12));
			}

			rs.close();
			conn.close();
			doc.close();

		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
