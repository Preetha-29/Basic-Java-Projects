import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/LoginServlet"})

public class LoginServlet extends HttpServlet {
protected void processRequest(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
response.setContentType("text/html;charset=UTF-8");
try (PrintWriter out = response.getWriter()) {
String sname=request.getParameter("sname");
String sno=request.getParameter("sno");
String gender = request.getParameter("gender");
String[] skills = request.getParameterValues("skills");

String htmlResponse = "<html><head><title>Form Submission</title></head><body>";
htmlResponse += "<h2>Your name: " + sname + "</h2>";
htmlResponse += "<p>Your Roll No: " + sno + "</p>";
htmlResponse += "<p>Gender: " + gender + "</p>";
if (skills != null) {
htmlResponse += "<p>Skills:</p><ul>";
for (String skill : skills) {
htmlResponse += "<li>" + skill + "</li>";
}
htmlResponse += "</ul>";
} else {
htmlResponse += "<p>No skills selected.</p>";
}
htmlResponse += "</body></html>";
PrintWriter writer = response.getWriter();
writer.println(htmlResponse);
}
}
}