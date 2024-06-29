<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java" import="java.sql.*, javax.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
</head>
<body>
<%
String data = request.getParameter("reg_no");
String query = "select * from student where reg_no=\""+data+"\"";
Connection con = null;
try{
Class.forName("com.mysql.jdbc.Driver").newInstance();
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/stdb", "root", "a");
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery(query);
out.println("The record you asked for : <br>");
rs.next();
out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+"
"+rs.getString(4)+"<br>");
con.close();
}
catch(Exception e){
e.printStackTrace();
}
%>
</body>
</html>