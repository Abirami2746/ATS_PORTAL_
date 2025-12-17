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
  <title>ATS Screening</title>
  <style>
    body{font-family:Arial;padding:20px;background:#fbfcfd}
    form{max-width:900px;margin:auto;background:white;padding:18px;border-radius:8px;box-shadow:0 6px 18px rgba(0,0,0,0.04)}
    textarea{width:98%;padding:10px;margin:8px 0;border:1px solid #dfe6ee;border-radius:6px}
    button{padding:10px 14px;background:#17a2b8;color:white;border:none;border-radius:6px}
    .result{max-width:900px;margin:20px auto;text-align:center}
  </style>
</head>
<body>

<h2 style="text-align:center">ATS Screening (Quick Check)</h2>

<form action="../atsScreen" method="post">
  <label>Paste Job Description</label>
  <textarea name="jobDescription" rows="6" placeholder="Paste job description here..."></textarea>

  <label>Paste Candidate Resume Text</label>
  <textarea name="resumeText" rows="8" placeholder="Paste resume text here..."></textarea>

  <button type="submit">Calculate Match</button>
</form>

<div class="result">
  <!-- In a real app the servlet writes result or redirects -->
  <p>Match Score: <strong>--</strong></p>
  <p>Missing keywords: <em>--</em></p>
</div>

</body>
</html>
