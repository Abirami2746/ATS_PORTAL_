<!DOCTYPE html>
<html>
<head>
    <title>ATS Score</title>
    <style>
        body {font-family: Arial; padding: 20px;}
        .box {border:1px solid #ddd; padding:20px; width:400px; margin:auto; text-align:center;}
        input {padding:10px; width:100%; margin-bottom:10px;}
        button {padding:10px; width:100%; background:#17a2b8; color:white; border:none;}
    </style>
</head>
<body>

<div class="box">
    <h2>Check ATS Score</h2>

    <form action="atsScore" method="post">
        <input type="text" name="jobTitle" placeholder="Enter Job Title" required>
        <button type="submit">Check Score</button>
    </form>

</div>

</body>
</html>
