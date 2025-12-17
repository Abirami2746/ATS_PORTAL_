<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.mini.ats.model.User" %>
<%
    User u = (User) session.getAttribute("currentUser");
    if (u == null) {
        response.sendRedirect("recruiter-login.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
  <title>Post Job - ATS Portal</title>
  <style>
    body{font-family:Arial;padding:30px;background:#f5f6f8}
    form{max-width:700px;margin:auto;background:white;padding:20px;border-radius:8px;box-shadow:0 4px 10px rgba(0,0,0,0.06)}
    input, textarea, button { width:98%; padding:10px; margin:10px 0; border-radius:6px; border:1px solid #d0d7de; }
    button { background:#007bff; color:white; border:none; cursor:pointer; padding:12px; }
  </style>
</head>
<body>
  <h2 style="text-align:center">Post New Job</h2>

  <form action="../postJob" method="post">
    <input type="hidden" name="recruiterId" value="<%= u.getId() %>" />
    <label>Job Title</label>
    <input type="text" name="title" required />

    <label>Job Description</label>
    <textarea name="description" rows="6" required></textarea>

    <label>Required Skills (comma separated)</label>
    <input type="text" name="skills" placeholder="Java,Spring,SQL" required />

    <label>Experience (years)</label>
    <input type="number" name="experience" min="0" />

    <button type="submit">Post Job</button>
  </form>
</body>
</html>
