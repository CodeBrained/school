<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>To-Do List</title>
</head>
<body>
<h1> To-Do List</h1>

<!-- Add to-do item -->
<form name="addForm" action="${pageContext.request.contextPath}/toDo-servlet" method="post">
    <label for ="toDoAdd"> Enter to-do list item: </label>
    <input type="text" id="toDoAdd" name = "toDoAdd" size="50">
    <input type="submit" value="Submit" name="submit" />
</form>

<!-- Delete to-do item -->
<form name="deleteForm" action="${pageContext.request.contextPath}/toDo-servlet" method="post">
    <label for ="toDoAdd"> Enter ID of item to delete: </label>
    <input type="text" id="toDoDelete" name = "toDoDelete" size="50">
    <input type="submit" value="Submit" name="submit" />
</form>

</body>
</html>