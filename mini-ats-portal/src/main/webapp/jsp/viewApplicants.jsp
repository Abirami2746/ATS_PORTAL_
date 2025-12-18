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
  <title>View Applicants</title>
  <style>
    body{font-family:Arial;padding:20px;background:#f7f8fa}
    table{width:95%; margin:auto; border-collapse:collapse; box-shadow:0 2px 8px rgba(0,0,0,0.04)}
    th,td{padding:12px;border-bottom:1px solid #e9ecef;text-align:left}
    th{background:#f1f3f5}
    a.btn{padding:8px 10px;background:#007bff;color:white;border-radius:6px;text-decoration:none}
    select{padding:6px}
  </style>
</head>
<body>
  <h2 style="text-align:center">Applicants for Your Jobs</h2>

  <!-- In real app, loop over applicants from DB -->
  <table>
    <thead>
      <tr><th>Applicant</th><th>Email</th><th>Applied For</th><th>ATS Score</th><th>Resume</th><th>Action</th></tr>
    </thead>
    <tbody>
      <tr>
        <td>Rahul Kumar</td>
        <td>rahul@example.com</td>
        <td>Java Developer</td>
        <td>78%</td>
        <td><a class="btn" href="../downloadResume?id=101">Download</a></td>
        <td>
          <select name="rating">
            <option>Rate</option><option>1</option><option>2</option><option>3</option><option>4</option><option>5</option>
          </select>
        </td>
      </tr>

      <tr>
        <td>Priya Sharma</td>
        <td>priya@example.com</td>
        <td>Frontend Developer</td>
        <td>85%</td>
        <td><a class="btn" href="../downloadResume?id=102">Download</a></td>
        <td>
          <select name="rating">
            <option>Rate</option><option>1</option><option>2</option><option>3</option><option>4</option><option>5</option>
          </select>
        </td>
      </tr>
    </tbody>
  </table>

  <p style="text-align:center; margin-top:16px;"><a href="recruiterDashboard.jsp">Back to Dashboard</a></p>
</body>
</html>
