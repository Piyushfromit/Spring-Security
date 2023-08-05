<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Sign in Page</title>
  <style>
  
  
  
    body {
      margin: 0;
      padding: 0;
      font-family: Arial, sans-serif;
      text-align: center;
    }
  
   .navbar {
      background-color: pink;
      position: sticky;
      top: 0;
      left: 0;
      width: 100%;
      padding: 18px 0;
      text-align: center;
    }

    .navbar a {
      color: white;
      text-decoration: none;
      margin: 0 15px;
    }

    .navbar a:hover {
      text-decoration: underline;
    }
  
  
    .login-form {
      max-width: 400px;
      margin: 100px auto;
      background-color: #f9eaea;
      padding: 20px;
      border-radius: 5px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    .login-form h2 {
      color: #ff699e;
    }

    .form-group {
      margin-bottom: 10px;
    }

    .form-group label {
      display: block;
      font-weight: bold;
      margin-bottom: 5px;
    }

    .form-group input {
      width: 100%;
      padding: 8px;
      border: 1px solid #ccc;
      border-radius: 4px;
    }
    .form-group select {
      width: 100%;
      padding: 8px;
      border: 1px solid #ccc;
      border-radius: 4px;
    }

    .form-group input[type="submit"] {
      background-color: #ff699e;
      color: #fff;
      cursor: pointer;
      transition: background-color 0.3s ease;
    }

    .form-group input[type="submit"]:hover {
      background-color: #ff4f80;
    }
    
    label {
	text-align: left;
	padding-left: 5px;
    }
    
  </style>
</head>
<body>

<div class="navbar">
    <a href="#">Home</a>
    <a href="#">About</a>
    <a href="#">Contact</a>
  </div>



  <div class="login-form">
    <h2>Sign In</h2>
     
    <!-- From Document  --> 
      	<%-- <div th:if="${param.error}">
			Invalid username and password.</div>
			
		<div th:if="${param.logout}">
			You have been logged out.</div> --%>
			
			
		<form th:action="@{/login}" method="post">
			<div>
			<input type="text" name="username" placeholder="Username"/>
			</div>
			<div>
			<input type="password" name="password" placeholder="Password"/>
			</div>
			<input type="submit" value="Log in" />
		</form>
    
  </div>
  
   
  
</body>
</html>