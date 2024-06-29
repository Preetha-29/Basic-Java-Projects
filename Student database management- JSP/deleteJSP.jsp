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
String query = "delete from student where reg_no=\""+data+"\"";
Connection con = null;
out.println(query);
try{
Class.forName("com.mysql.jdbc.Driver").newInstance();
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/stdb", "root", "a");
Statement stmt = con.createStatement();
int rs = stmt.executeUpdate(query);
out.println("Deleted Successfully " + " " + rs);
con.close();
}
catch(Exception e){
e.printStackTrace();
}
%>
</body>
</html>