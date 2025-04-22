<html>
<head><title>Attendance Form</title></head>
<body>
    <form action="SaveAttendanceServlet" method="post">
        Student ID: <input type="text" name="student"><br>
        Date: <input type="date" name="date"><br>
        Status: 
        <select name="status">
            <option value="Present">Present</option>
            <option value="Absent">Absent</option>
        </select><br>
        <input type="submit" value="Submit Attendance">
    </form>
</body>
</html>