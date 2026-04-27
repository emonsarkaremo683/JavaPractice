<%@page import="model.Employee" %>

<%
    Employee e = (Employee) request.getAttribute("employee");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Employee</title>
</head>
<body>
    <form action="/employee" method="post">
        <input type="hidden" name="action" value="update" />
        <input type="hidden" name="id" value="<%= e.getId() %>" />

        <div>
            <label>Name:</label>
            <input type="text" name="name" value="<%= e.getName() %>" />
        </div>

        <div>
            <label>Designation:</label>
            <input type="text" name="designation" value="<%= e.getDesignation() %>" />
        </div>

        <div>
            <label>Salary:</label>
            <input type="text" name="salary" value="<%= e.getSalary() %>" />
        </div>

        <div>
            <label>Joining Date:</label>
            <input type="date" name="joiningDate" value="<%= e.getJoiningDate() %>" />
        </div>

        <div>
            <input type="submit" value="Update" />
        </div>
    </form>
</body>
</html>
