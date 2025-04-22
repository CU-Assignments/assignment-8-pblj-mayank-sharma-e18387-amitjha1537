<%@ page import="java.util.*" %>
<html>
<head><title>Employee List</title></head>
<body>
    <form method="get" action="EmployeeServlet">
        Search by ID: <input type="text" name="id">
        <input type="submit" value="Search">
    </form>
    <table border="1">
        <tr><th>ID</th><th>Name</th><th>Department</th></tr>
        <%
        ArrayList<String[]> employees = (ArrayList<String[]>) request.getAttribute("employees");
        if (employees != null) {
            for (String[] emp : employees) {
        %>
            <tr>
                <td><%= emp[0] %></td>
                <td><%= emp[1] %></td>
                <td><%= emp[2] %></td>
            </tr>
        <%
            }
        }
        %>
    </table>
</body>
</html>