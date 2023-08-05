<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Home Page</title>
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
      
      display: flex;
       justify-content: end; 
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

    .logoutbtn {
      background-color: #784212;
      color: white;
      padding: 8px 15px;
      border: none;
      border-radius: 5px;
      font-size: 16px;
      cursor: pointer;
     
    }

    .logoutbtn:hover {
       background-color: #9C640C;
       box-shadow: 5px 10px 18px #888888;
    }
    /* .buttondiv{
       
    } */
    
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
    
    <div class="buttondiv" >
    <a href="/logout">
      <button class= "logoutbtn">Sign out</button> 
    </a>
    </div>
    
</div>
  
 

  <div class="container">
    <h1>Welcome to our website</h1>
    
     <h1>You are Successfully Signed in</h1>
    
    
    
  </div>
</body>
</html>