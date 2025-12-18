<!DOCTYPE html>
<html>
<head>
    <title>Upload Resume</title>
    <style>
        body {font-family: Arial; padding: 20px;}
        .container {width: 400px; margin: auto; border:1px solid #ddd; padding: 20px; border-radius: 10px;}
        button {padding: 10px; width: 100%; background: #007bff; color: white; border: none;}
    </style>
</head>
<body>

<div class="container">
    <h2>Upload Resume (PDF/DOCX)</h2>

    <form action="uploadResume" method="post" enctype="multipart/form-data">
        <input type="file" name="resume" accept=".pdf,.doc,.docx" required>
        <button type="submit">Upload</button>
    </form>
</div>

</body>
</html>
