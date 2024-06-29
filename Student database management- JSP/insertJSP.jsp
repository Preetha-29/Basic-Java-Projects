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
String[] data =new String[4];
data[0] = request.getParameter("reg_no");
data[1] = request.getParameter("Name");
data[2] = request.getParameter("Mobile");
data[3] = request.getParameter("Email");

String query = "insert into student val-
ues(\""+data[0]+"\",\""+data[1]+"\",\""+data[2]+"\",\""+data[3]+"\")";

Connection con = null;
try{
Class.forName("com.mysql.jdbc.Driver").newInstance();
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/stdb", "root", "a");
Statement stmt = con.createStatement();
int rs = stmt.executeUpdate(query);
out.println("Inserted Successfully" + rs);
con.close();
}
catch(Exception e){
e.printStackTrace();
}
%>
</body>
</html>