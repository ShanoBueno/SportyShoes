<%@page import="com.example.Shoe"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="com.example.*" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Details in the table</title>
</head>
<body>
<%List<Shoe> s=(List<Shoe>)request.getAttribute("list"); %>
<table border="1">
<tr><th>Sno</th><th>Sname</th><th>Category</th><th>Price</th><th>edit</th><th>delete</th></tr>
<%for(Shoe ss:s){ %>
<tr><td><%=ss.getId() %></td><td><%=ss.getName() %></td><td><%=ss.getCategory() %></td><td><%=ss.getPrice() %></td><td><form action="addPurchase">
Quantity <input type="number" name="quantity">
<input type="hidden" value=<%=ss.getName() %> name="name">
<input type="hidden" value=<%=ss.getPrice() %> name="price">
<input type="hidden" value=<%=ss.getCategory() %> name="category">
<input type="submit" value="add">
</form></td><td><a href="./edit.jsp">Edit</a></td><td><a href="./delete.jsp">delete</a></td></tr>
<%} %>
</table>


</body>
</html>