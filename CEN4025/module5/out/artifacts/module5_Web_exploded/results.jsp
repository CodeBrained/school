<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>User Information</title>
    </head>
    <%
        String id = request.getParameter("id");
        String toDo = request.getParameter("todo");
    %>

    <body>
        <h1>User Information</h1>

        <table>
            <tbody>
                <tr>
                    <td>ID: </td>
                    <td><%= id %></td>
                </tr>
                <tr>
                    <td>ToDo: </td>
                    <td><%= toDo %></td>
                </tr>
            </tbody>
        </table>

    </body>
</html>
