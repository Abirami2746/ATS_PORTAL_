<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Job Seeker Login</title>
    <style>
        body { font-family: Arial; text-align: center; background: #eef2f3; padding: 50px; }
        form { width: 320px; margin: auto; background: white; padding: 25px; border-radius: 10px; box-shadow: 0 0 10px #ccc; }
        input { width: 90%; padding: 10px; margin: 10px; }
        button { padding: 10px 20px; background: #007bff; color: white; border: none; border-radius: 6px; }
    </style>
</head>
<body>

<h2>Job Seeker Login</h2>

<form action="../login" method="post">
    <input type="email" name="email" placeholder="Email" required />
    <input type="password" name="password" placeholder="Password" required />
    <button type="submit">Login</button>
</form>

</body>
</html>
