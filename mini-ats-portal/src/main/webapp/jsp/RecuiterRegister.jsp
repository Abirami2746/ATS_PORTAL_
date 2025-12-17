<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Recruiter Register - ATS Portal</title>
  <style>
    body { font-family: Arial, sans-serif; background:#eef2f3; padding:40px; text-align:center;}
    form { width:380px; margin:auto; background:white; padding:24px; border-radius:8px; box-shadow:0 4px 12px rgba(0,0,0,0.08);}
    input, button { width:92%; padding:10px; margin:8px 0; border-radius:6px; border:1px solid #cfd8dc; }
    button { background:#007bff; color:white; border:none; cursor:pointer; }
    a { color:#007bff; text-decoration:none; }
  </style>
</head>
<body>
  <h2>Recruiter Registration</h2>

  <form action="../register" method="post">
    <input type="hidden" name="role" value="recruiter" />
    <input type="text" name="company" placeholder="Company Name" required />
    <input type="text" name="name" placeholder="Recruiter Name" required />
    <input type="email" name="email" placeholder="Email" required />
    <input type="password" name="password" placeholder="Password" required />
    <input type="text" name="phone" placeholder="Phone Number" required />
    <button type="submit">Create Recruiter Account</button>
  </form>

  <p style="margin-top:12px;">Already registered? <a href="recruiter-login.jsp">Login here</a></p>
</body>
</html>
