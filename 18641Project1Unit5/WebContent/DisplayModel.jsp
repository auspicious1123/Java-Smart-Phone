<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Selected Car Model</title>
</head>
<body>
    <h1>Here is what you you selected:</h1>
    <%
    String[][] chosedModel = (String[][])session.getAttribute("chosedModel");
    %>
    <table border="1">
    <% for (int i = 0; i < chosedModel.length-1; i++) { %>
        <tr>
        <% for (int j = 0; j < chosedModel[i].length; j++) { %>
            <td><%=chosedModel[i][j] %></td>
        <% } %>
   </tr>
   <% } %>
   <tr>
        <% for (int j = 0; j < chosedModel[chosedModel.length-1].length; j++) { %>
            <td><b><%=chosedModel[chosedModel.length-1][j] %></b></td>
        <% } %>
        </tr>
    </table>
</body>
</html>