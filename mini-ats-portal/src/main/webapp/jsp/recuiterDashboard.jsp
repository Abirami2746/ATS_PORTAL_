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
  <title>Recruiter Dashboard</title>
  <style>
    body { font-family: Arial, sans-serif; background:#f7f9fb; padding:20px; }
    header { display:flex; justify-content:space-between; align-items:center; max-width:1000px; margin:auto; }
    .card { background:white; padding:20px; border-radius:8px; box-shadow:0 4px 10px rgba(0,0,0,0.05); margin:14px 0; }
    .menu { max-width:600px; margin:auto; }
    a.btn { display:block; text-decoration:none; text-align:center; padding:12px; margin:8px 0; border-radius:6px; color:white; background:#007bff; }
    a.secondary { background:#6c757d; }
    .small { font-size:0.9rem; color:#555; }
  </style>
</head>
<body>

<header>
  <div>
    <h2>Recruiter Dashboard</h2>
    <div class="small">Welcome, <strong><%= u.getName() %></strong> — <%= u.getEmail() %></div>
  </div>
  <div>
    <form action="../logout" method="post" style="display:inline;">
      <button style="padding:8px 12px; border-radius:6px; border:none; background:#dc3545; color:white; cursor:pointer;">Logout</button>
    </form>
  </div>
</header>

<div class="menu">
  <div class="card">
    <a class="btn" href="postJob.jsp">Post New Job</a>
    <a class="btn" href="viewApplicants.jsp">View All Applicants</a>
    <a class="btn" href="atsScreening.jsp">ATS Screening</a>
    <a class="btn" href="sendEmail.jsp">Email Templates</a>
    <a class="btn secondary" href="recruiter-profile.jsp">Update Profile</a>
  </div>
</div>

</body>
</html>
