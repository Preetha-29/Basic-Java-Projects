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
String query = "select count(*) from student";
String query1 = "select * from student";
Connection con = null;
try{
Class.forName("com.mysql.jdbc.Driver").newInstance();
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/stdb", "root", "a");
Statement stmt = con.createStatement();
Statement stmt1 = con.createStatement();
ResultSet rs = stmt.executeQuery(query);
rs.next();
int count = rs.getInt(1);
ResultSet rs1 = stmt1.executeQuery(query1);
for(int i=1;i<=count;i++){
rs1.absolute(i);
out.println(rs1.getString(1)+" "+rs1.getString(2)+" "+rs1.getString(3)+"

"+rs1.getString(4)+"<br>");
}
con.close();
}
catch(Exception e){
e.printStackTrace();
}
%>
</body>
</html>