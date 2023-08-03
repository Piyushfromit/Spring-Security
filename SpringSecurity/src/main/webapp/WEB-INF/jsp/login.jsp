<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">

.form-signin {
    max-width: 330px;
    padding: 15px;
    margin: 0 auto;
}
*, ::after, ::before {
    box-sizing: inherit;
}
form {
    display: block;
    margin-top: 0em;
}

body {
    margin: 0;
    font-family: -apple-system,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif;
    font-size: 1rem;
    font-weight: 400;
    line-height: 1.5;
    color: #212529;
    background-color: #fff;
}


html {
    box-sizing: border-box;
    font-family: sans-serif;
    line-height: 1.15;
    -webkit-text-size-adjust: 100%;
    -ms-text-size-adjust: 100%;
    -ms-overflow-style: scrollbar;
    -webkit-tap-highlight-color: transparent;
}

*, ::after, ::before {
    box-sizing: inherit;
}

*, ::after, ::before {
    box-sizing: inherit;
}



</style>



</head>
<body>



      <form class="form-signin" method="POST" action="login">
        <h2 class="form-signin-heading">Please sign in p</h2>
        <p>
          <label for="username" class="sr-only">Username</label>
          <input type="text" id="username" name="username" class="form-control" placeholder="Username" required="" autofocus="">
        </p>
        <p>
          <label for="password" class="sr-only">Password</label>
          <input type="password" id="password" name="password" class="form-control" placeholder="Password" required="">
        </p>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>



</body>
</html>