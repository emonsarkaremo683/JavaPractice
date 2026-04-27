<%@page import="dao.EmployeeDao" %>
<%@page import="model.Employee" %>
<%@page import="java.util.*" %>

<%@taglib prefix="e" uri="http://java.sun.com/jsp/jstl/core" %>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Form</title>
    <style>
        form {
            max-width: 400px;
            margin: 20px auto;
            display: flex;
            flex-direction: column;
            gap: 12px;
        }
        label {
            font-weight: bold;
        }
        input {
            padding: 6px;
            font-size: 14px;
        }
        button {
            padding: 8px;
            font-size: 15px;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <h2 style="text-align:center;">Employee Form</h2>

    <form action="/employee" method="post">
      <input type="hidden" name="action" value="add" />
     

        <div>
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required />
        </div>

        <div>
            <label for="designation">Designation:</label>
            <input type="text" id="designation" name="designation" required />
        </div>

        <div>
            <label for="salary">Salary:</label>
            <input type="number" step="0.01" id="salary" name="salary" required />
        </div>

        <div>
            <label for="joiningDate">Joining Date:</label>
            <input type="date" id="joiningDate" name="joiningDate" required />
        </div>
        <input type="submit" value="Submit" />

        
    </form>
</body>
</html>
