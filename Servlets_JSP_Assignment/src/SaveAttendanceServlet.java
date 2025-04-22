import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SaveAttendanceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentId = request.getParameter("student");
        String date = request.getParameter("date");
        String status = request.getParameter("status");
        try {
            Connection con = DBConnection.initializeDatabase();
            PreparedStatement ps = con.prepareStatement("INSERT INTO attendance(student_id, date, status) VALUES (?, ?, ?)");
            ps.setInt(1, Integer.parseInt(studentId));
            ps.setDate(2, Date.valueOf(date));
            ps.setString(3, status);
            ps.executeUpdate();
            con.close();
            response.getWriter().println("Attendance recorded successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}