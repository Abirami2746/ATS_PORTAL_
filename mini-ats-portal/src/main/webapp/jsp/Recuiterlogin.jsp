<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Recruiter Login - ATS Portal</title>
  <style>
    body { font-family: Arial, sans-serif; background:#eef2f3; padding:50px; text-align:center; }
    form { width:320px; margin:auto; background:white; padding:20px; border-radius:8px; box-shadow:0 4px 12px rgba(0,0,0,0.06); }
    input, button { width:90%; padding:10px; margin:10px 0; border-radius:6px; }
    button { background:#28a745; color:white; border:none; cursor:pointer;}
    a { color:#007bff; text-decoration:none; }
  </style>
</head>
<body>
  <h2>Recruiter Login</h2>

  <form action="../login" method="post">
    <input type="hidden" name="role" value="recruiter" />
    <input type="email" name="email" placeholder="Email" required />
    <input type="password" name="password" placeholder="Password" required />
    <button type="submit">Login</button>
  </form>

  <p>New recruiter? <a href="recruiter-register.jsp">Register</a></p>
</body>
</html>
