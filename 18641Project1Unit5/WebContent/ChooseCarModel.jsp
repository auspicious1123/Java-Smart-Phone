<%@page import="adapter.BuildAuto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "util.FileIO" %>
<%@ page import="java.util.Properties" %>
<%@ page import= "java.util.ArrayList"%>
<%@ page import= "model.Automobile" %>
<%@ page import= "java.net.Socket" %>
<%@ page import= "java.io.PrintWriter" %>
<%@ page import= "java.io.ObjectInputStream" %>
<%@ page import= "java.io.InputStreamReader" %>
<%@ page import= "java.io.BufferedReader" %>
<%@ page import= "java.io.IOException" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Choose Car Model</title>
</head>
<body>
    <form action="ModelSevlet" method = "Get">
    <h1>Please choose your model here.</h1>
    <%
    Socket clientSocket = null;
    PrintWriter outStream = null;
    BufferedReader inStream = null;
    try {
        clientSocket = new Socket("localhost", 7878);
        outStream = new PrintWriter(clientSocket.getOutputStream(), true);
        inStream = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    } catch (IOException e) {
        e.printStackTrace();
    }
    outStream.println("2");
    System.out.println("The list of automobiles are:");
    ArrayList<String> modelNameList = new ArrayList<String>();
    String readin; // read list from server
    while(!(readin = inStream.readLine()).equals("")) {
        System.out.println(readin);
        modelNameList.add(readin);
    }
    %>
        <table border="1">
        <tr>
            <td align="center"><b>Make/Model</b></td>
                <td><select name="selectModel">
                        <%
                            for (int i = 0; i < modelNameList.size(); i++) {
                        %>
                        <option value="<%=modelNameList.get(i)%>"><%=modelNameList.get(i)%></option>
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