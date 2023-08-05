<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Registration Page</title>
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
  
  
    .registration-form {
      max-width: 400px;
      margin: 100px auto;
      background-color: #f9eaea;
      padding: 20px;
      border-radius: 5px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    .registration-form h2 {
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



  <div class="registration-form">
    <h2>Create Account</h2>
    
    <form action="register" method="POST" >
    
      <div class="form-group">
        <label  for="username">User name</label>
        <input type="text" id="username" name="name" required>
      </div>
      <div class="form-group">
        <label for="email">Email</label>
        <input type="email" id="email" name="email" required>
      </div>
      <div class="form-group">
        <label for="password">Password</label>
        <input type="password" id="password" name="password" required>
      </div>
    <!--   <div class="form-group">
        <label for="confirm_password">Confirm Password</label>
        <input type="password" id="confirm_password" name="confirm_password" required>
      </div> -->
      <div class="form-group">
        <label for="userrole">role</label>
        <select required>
        <option>Admin</option>
        <option>User</option>
        </select>
      </div> 
      <div class="form-group">
        <label for="phone">Phone Number</label>
        <input type="tel" id="phone" name="phone" required>
      </div>
      <div class="form-group">
        <input type="submit" value="Register">
      </div>
    </form>
    
  </div>
</body>
</html>