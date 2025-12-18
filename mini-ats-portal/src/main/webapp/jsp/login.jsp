<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="../static/css/styles.css">
</head>
<body>
<div class="container">
    <h2>Login</h2>
    <form action="login" method="post">
        <input type="email" name="email" placeholder="Email" required/><br/><br/>
        <input type="password" name="password" placeholder="Password" required/><br/><br/>
        <input type="submit" value="Login"/>
    </form>
    <p>Don't have an account? <a href="register.jsp">Register</a></p>
</div>
</body>
</html>
