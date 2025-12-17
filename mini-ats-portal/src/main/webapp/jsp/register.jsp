<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
    <h2>Register</h2>
    <form action="register" method="post">
        Name: <input type="text" name="name"/><br/>
        Email: <input type="email" name="email"/><br/>
        Password: <input type="password" name="password"/><br/>
        Role: 
        <select name="role">
            <option value="seeker">Job Seeker</option>
            <option value="recruiter">Recruiter</option>
        </select><br/>
        <input type="submit" value="Register"/>
    </form>
    <a href="login.jsp">Login</a>
</body>
</html>
