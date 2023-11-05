
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>To-Do List</title>
    </head>
    <body>
    <h1> To-Do List</h1>
        <form name="myForm" action="results.jsp" method="post">

            <table>
                <tbody>

                <tr>
                    <td>ID: </td>
                    <td><input type="text" name="id" value="" size="50"></td>
                </tr>

                <tr>
                    <td>To Do: </td>
                    <td><input type="text" name="todo" value="" size="50"></td>
                </tr>

                </tbody>
            </table>

            <input type="reset" value="Clear" name="clear" />
            <input type="submit" value="Submit" name="submit" />

        </form>

    </body>
</html>
