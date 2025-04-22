import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.ArrayList;

public class EmployeeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ArrayList<String[]> employees = new ArrayList<>();
        try {
            Connection con = DBConnection.initializeDatabase();
            Statement stmt = con.createStatement();
            ResultSet rs;
            if (id != null && !id.isEmpty()) {
                PreparedStatement ps = con.prepareStatement("SELECT * FROM employee WHERE id=?");
                ps.setInt(1, Integer.parseInt(id));
                rs = ps.executeQuery();
            } else {
                rs = stmt.executeQuery("SELECT * FROM employee");
            }
            while (rs.next()) {
                String[] row = { rs.getString("id"), rs.getString("name"), rs.getString("department") };
                employees.add(row);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("employees", employees);
        RequestDispatcher rd = request.getRequestDispatcher("employee.jsp");
        rd.forward(request, response);
    }
}