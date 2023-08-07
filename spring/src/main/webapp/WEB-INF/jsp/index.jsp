<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Index Page</title>
  <style>
    body {
      margin: 0;
      padding: 0;
      font-family: Arial, sans-serif;
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

    .container {
      text-align: center;
      margin-top: 150px;
    }

    .signinsignup {
      background-color: #F39C12;
      color: white;
      padding: 10px 20px;
      border: none;
      border-radius: 5px;
      font-size: 16px;
      cursor: pointer;
      margin: 10px;
    }

    .signinsignup:hover {
      background-color: #D68910;
       box-shadow: 5px 10px 18px #888888;
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

  <div class="container">
    <h1>Welcome to our website</h1>
    <h4>Demo Website For Spring Security</h4>
    <p>Piyush Kumar. Java Developer Trainee<p>
    
    <a href="/login">
      <button  class="signinsignup">Sign In</button> 
    </a>
    
    <a href="/register">
      <button  class="signinsignup">Sign Up</button>
    </a>
    
  </div>
</body>
</html>