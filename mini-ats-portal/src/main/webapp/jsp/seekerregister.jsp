<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Job Seeker Register</title>
    <style>
        body { font-family: Arial; text-align: center; background: #eef2f3; padding: 50px; }
        form { width: 340px; margin: auto; background: white; padding: 25px; border-radius: 10px; box-shadow: 0 0 10px #ccc; }
        input { width: 90%; padding: 10px; margin: 10px; }
        button { padding: 10px 20px; background: green; color: white; border: none; border-radius: 6px; }
    </style>
</head>
<body>

<h2>Create Job Seeker Account</h2>

<form action="../register" method="post">
    <input type="text" name="name" placeholder="Full Name" required />
    <input type="email" name="email" placeholder="Email" required />
    <input type="text" name="phone" placeholder="Phone Number" required />
    <input type="password" name="password" placeholder="Password" required />
    <input type="hidden" name="role" value="seeker" />
    <button type="submit">Register</button>
</form>

</body>
</html>
