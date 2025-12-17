<%@ page import="com.mini.ats.model.User" %>

<%
    User user = (User) session.getAttribute("currentUser");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Seeker Dashboard</title>
    <style>
        body {font-family: Arial; padding: 20px;}
        a {display: block; margin: 10px 0; font-size: 18px;}
    </style>
</head>
<body>

<h2>Welcome, <%= user.getName() %> </h2>

<h3>Job Seeker Dashboard</h3>

<a href="uploadResume.jsp"> Upload Resume</a>
<a href="applyJobs.jsp"> Apply Jobs</a>
<a href="atsScore.jsp"> Check ATS Score</a>
<a href="#">View Applied Jobs (coming soon)</a>
<a href="logout">Logout</a>

</body>
</html>
