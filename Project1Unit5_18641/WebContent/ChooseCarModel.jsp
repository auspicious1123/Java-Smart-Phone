<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "adapter.BuildAuto" %>
<%@ page import="java.util.Properties"%>
<%@ page import= "adapter.BuildAuto"%>
<%@ page import="util.FileIO" %>
<%@ page import="model.Automobile"%>
<%@ page import= "java.util.ArrayList"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Choose Car Model</title>
</head>
<body>
    <form action="doModelChoose" method = "post">
    <h1>Please choose your model here.</h1>
    <%
    /* System.out.println("yes, it is test1");
    FileIO io = new FileIO();
    System.out.println("read properties");
    Properties properties1 = io.readPropertiesFile("Model1.Properties");
    System.out.println("read properties finish");
    Automobile auto1 = io.buildAutoFromProperties(properties1);
    Properties properties2 = io.readPropertiesFile("Model2.Properties");
    Automobile auto2 = io.buildAutoFromProperties(properties2); */
    
    ArrayList<String> modelNameList = new ArrayList<>();
    
    modelNameList.add("a");
    modelNameList.add("b");
    %>
        <table border="1">
            <tr>
                <td align="center"><b>Make/Model</b></td>
                <td><select name="selectModel">
                        <%
                            for (int j = 0; j < modelNameList.size(); j++) {
                        %>
                        <option value="<%=modelNameList.get(j)%>"><%=modelNameList.get(j)%></option>

                        <%
                            }
                        %>

                </select></td>
            </tr>
        </table>
        <input type="submit" value="done" />

    </form>
        

</body>
</html>