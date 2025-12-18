<%@ page import="com.mini.ats.model.User" %>
<%
User user = (User) session.getAttribute("currentUser");
if (user == null) {
    response.sendRedirect("login.jsp");
    return;
}
String userName = user.getName();
%>

<!DOCTYPE html>
<html>
<head>
<title>Applicant Dashboard</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

<style>
body { margin:0; font-family:Poppins, sans-serif; background:#f4f6f9; }

.sidebar {
    width:260px;
    height:100vh;
    background:#1e40af;
    position:fixed;
    left:-260px;
    transition:0.3s;
    color:white;
}

.sidebar.active { left:0; }

.profile {
    text-align:center;
    padding:20px;
}

.avatar {
    width:80px;
    height:80px;
    border-radius:50%;
    background:white;
    color:#1e40af;
    font-size:32px;
    display:flex;
    align-items:center;
    justify-content:center;
    margin:auto;
}

.sidebar ul { list-style:none; padding:0; }
.sidebar ul li a {
    display:block;
    padding:15px 25px;
    color:white;
    text-decoration:none;
}
.sidebar ul li a:hover { background:#1d4ed8; }

.topbar {
    height:60px;
    background:white;
    display:flex;
    align-items:center;
    padding:0 20px;
    box-shadow:0 2px 10px rgba(0,0,0,.1);
}

.menu-btn { font-size:26px; cursor:pointer; color:#1e40af; }

.title { margin-left:20px; font-weight:600; }
</style>
</head>

<body>

<!-- Sidebar -->
<div class="sidebar" id="sidebar">
    <div class="profile">
        <div class="avatar"><%= userName.charAt(0) %></div>
        <h3><%= userName %></h3>
    </div>

    <ul>
        <li><a href="uploadResume.jsp">Upload Resume</a></li>
        <li><a href="atsScore.jsp">ATS Score</a></li>
        <li><a href="jobs.jsp">Available Jobs</a></li>
        <li><a href="appliedJobs.jsp">Applied Jobs</a></li>
        <li><a href="profile.jsp">Profile Update</a></li>
    </ul>
</div>

<!-- Top bar -->
<div class="topbar">
    <i class="fa fa-bars menu-btn" onclick="toggleMenu()"></i>
    <div class="title">Welcome, <%= userName %></div>
</div>

<script>
function toggleMenu() {
    document.getElementById("sidebar").classList.toggle("active");
}
</script>

</body>
</html>
