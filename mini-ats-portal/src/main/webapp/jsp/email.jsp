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
  <title>Send Email to Candidate</title>
  <style>
    body{font-family:Arial;padding:20px;background:#f6f8fa}
    form{max-width:700px;margin:auto;background:white;padding:18px;border-radius:8px;box-shadow:0 6px 16px rgba(0,0,0,0.05)}
    input, textarea, select, button { width:98%; padding:10px; margin:10px 0; border-radius:6px; }
    button { background:#007bff;color:white;border:none;cursor:pointer; }
  </style>
</head>
<body>

<h2 style="text-align:center">Send Email to Candidate</h2>

<form action="../sendEmail" method="post">
  <label>Candidate Email</label>
  <input type="email" name="candidateEmail" placeholder="candidate@example.com" required />

  <label>Template</label>
  <select name="template" id="template">
    <option value="interview">Interview Call</option>
    <option value="reject">Rejection Mail</option>
    <option value="shortlist">Shortlist Mail</option>
    <option value="offer">Offer Letter</option>
  </select>

  <label>Message (customize)</label>
  <textarea name="message" rows="8">Dear Candidate,&#10;&#10;[custom message here]&#10;&#10;Regards, Recruiter</textarea>

  <button type="submit">Send Email</button>
</form>

</body>
</html>
 