<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="https://www.thymeleaf.org">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>SignIn Page</title>
  <style>
     body {
      margin: 0;
      padding: 0;
      font-family: Arial, sans-serif;
      text-align: center;
    }
  
   .navbar {
      background-color: #F39C12 ;
      position: sticky;
      top: 0;
      left: 0;
      width: 100%;
      height: 55px;
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
      background-color: #FEF5E7 ;
      padding: 20px;
      border-radius: 5px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    .login-form h2 {
      color: #D68910;
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
      width: 80%;
      padding: 8px;
      margin: 4px;
      border: 1px solid #ccc;
      border-radius: 4px;
    }
    .form-group select {
      width: 80%;
      padding: 8px;
      border: 1px solid #ccc;
      border-radius: 4px;
    }

    .form-group input[type="submit"] {
      background-color: #F39C12;
      color: #fff;
      cursor: pointer;
      width: 25%;
    }

    .form-group input[type="submit"]:hover {
      background-color: #D68910;
       box-shadow: 5px 10px 18px #888888;
    }
    
    label {
	text-align: left;
	padding-left: 5px;
    }
    
    .navbarchild{
     padding: 18px 0px;
    
    } 
    
  </style>
</head>
<body>

  <div class="navbar">
    
    <div class= "navbarchild">
    <a href="#">Home</a>
    <a href="#">About</a>
    <a href="#">Contact</a>
    </div>
  </div>



  <div class="login-form">
    <h2>Sign In</h2>

    <!-- From Document Of Spring Security  
       Documentation Link: https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/form.html
     -->
     
      	<%-- <div th:if="${param.error}">
			Invalid username and password.</div>
			
		<div th:if="${param.logout}">
			You have been logged out.</div> --%>
		
		<form th:action="/login" method="post">
			<div  class="form-group">
			<input type="text" name="username" placeholder="Username or Email"/>
			</div>
			<div  class="form-group">
			<input type="password" name="password" placeholder="Password"/>
			</div>
			
			 <div class="form-group">
			<input type="submit" class="button" value="Log in" />
			</div>
		</form>
		<p>Don't have an account? <a href="/register">SignUp</a></p>
    
  </div>
  
  
  
</body>
</html>