<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>SignUp Page</title>
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
  
  
    .registration-form {
      max-width: 400px;
      margin: 100px auto;
      background-color: #FEF5E7;
      padding: 20px;
      border-radius: 5px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    .registration-form h2 {
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
      width: 85%;
      padding: 6px;
      margin: 4px;
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



  <div class="registration-form">
    <h2>Create Account</h2>
    
    <form action="register" method="POST" >
    
      <div class="form-group">
        <input type="text" id="username" name="name" placeholder="Username" required>
      </div>
      <div class="form-group">
        <input type="email" id="email" name="email" placeholder="Email" required>
      </div>
      <div class="form-group">
        <input type="password" id="password" name="password" placeholder="Password" required>
      </div>
      
     <div class="form-group">
        <select name="role"  required>
        <option selected disabled>Choose Role</option>
        <option value="Admin" >Admin</option>
        <option value="User" >User</option>
        </select>
      </div> 
      <div class="form-group">
        <input type="tel" id="phone" name="phone" placeholder="Phone No" required>
      </div>
      <div class="form-group">
        <input type="submit" value="Register">
      </div>
    </form>
    <p>Already have an account? <a href="/login">LogIn</a></p>
    
  </div>
</body>
</html>