<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "model.Automobile"%>
<%@ page import= "model.OptionSet"%>
<%@ page import= "java.util.ArrayList"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Basic Car Configuration</title>
</head>
<body>
    <from action = "doChoice" method = "post">
    <%
    Automobile auto = (Automobile)session.getAttribute("automobile");
    %>
    
    <table border = "1">
    <tr>
        <td algin = "center"><b>Make/Model:</b></td>
        <td name = "modelName"><%=auto.getMake() %></td>
    </tr>
    <% 
    // input color option
    ArrayList<OptionSet> optionSet = auto.getOptionSet();
    for(int i = 0; i < optionSet.size(); i++){
    %>
        <tr>
        <td algin = "center"><b><%= optionSet.get(i).getName() %></b></td>
        <td>
        <select>
                <%
                ArrayList<String> optionNames = auto.getOptionsName(i);  // i is index of optionSet
                for(int j = 0; j < optionNames.size(); j++) {
                %>
                <option value=<%=optionNames.get(j)%>><%=optionNames.get(j)%></option>
                <%
                }
                %>
        </select>
       </td>
    </tr>
    <%
    }
    %>
    <tr>
        <td colspan = "2" align = "right"><input type = "submit" value = "Done"></td>
    </tr>
    
    </table>
    

</body>
</html>