<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Registration Form</title>
  
    
    <link rel="stylesheet" type="text/css" href="/resources/css/user.css?jknj">
   
  
     
</head>
<body>
  <jsp:include page="include/indexheader.jsp" />
    <div class="regform">
        <h2>Registration Form</h2>
        <form action="/register" method="POST">
            <div class="form-group">
                <input type="text" id="name" name="name" placeholder="Name" required>
            </div>
            <div class="form-group">
                <input type="tel" id="phone" name="phone" placeholder="Phone Number" required>
            </div>
            <div class="form-group">
                <input type="email" id="email" name="email" placeholder="Email Address:" required>
            </div>
            <div class="form-group">
                <input type="password" id="password" name="password" placeholder="Password" required>
            </div>
            <div class="form-group">
                <input type="submit" value="Register">
            </div>
        </form>
        <p>Do you already have an account? <a href="/login"> Login</a></p>
    </div>
</body>
</html>