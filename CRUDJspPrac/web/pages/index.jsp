

<%@page import="dao.EmployeeDao" %>
<%@page import="model.Employee" %>
<%@page import="java.util.*" %>

<%@taglib prefix="e" uri="http://java.sun.com/jsp/jstl/core" %>

<% 
    List<Employee> list = EmployeeDao.getAll();
    request.setAttribute("list", list);


%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="/pages/Add.jsp">Add Employee</a>
        <h1>All Employee</h1>
        <table border="1">
            <thead>
                <tr>
                    <td>ID</td>
                    <td>Name</td>
                    <td>Designation</td>
                    <td>Salary</td>
                    <td>Joining Date</td>
                    <td>Action</td>
                </tr>
            </thead>
            <e:forEach items="${list}" var="emp">
                <tbody>
                    <tr>
                        <td>${emp.id}</td>
                        <td>${emp.name}</td>
                        <td>${emp.designation}</td>
                        <td>${emp.salary}</td>
                        <td>${emp.joiningDate}</td>
                        <td>
                            <a href="/employee?action=edit&id=${emp.id}">Edit</a>
                            <a href="/employee?action=delete&id=${emp.id}">Delete</a>
                        </td>

                    </tr>
                </tbody>
            </e:forEach>


        </table>
    </body>
</html>
