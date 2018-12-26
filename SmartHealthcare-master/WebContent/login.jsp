<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
 <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >
    <link href="css/global1.css" type="text/css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" ></script>
</head>
<body>
<%
if(session.getAttribute("username")!=null)
{
  request.setAttribute("user", session.getAttribute("username"));
  request.getRequestDispatcher("logout.jsp").forward(request,response);    
}

 %>

<div class="container-fluid bg">
    <div class="row">
        <div class="col-md-4 col-sm-4 col-xs-12"></div>
        <div class="col-md-4 col-sm-4 col-xs-12">
        <!--form start-->
         <form class="form-container" action="Login" method = "post">
             <h1>Login </h1>
              <div class="form-group">
                <label for="exampleInputEmail1">Email</label>
                <input type="email"  name ="email" class="form-control" id="exampleInputEmail1" placeholder="Email" required>
              </div>
              <div class="form-group">
                <label for="exampleInputPassword1">Password</label>
                <input type="password" name ="password" class="form-control" id="exampleInputPassword1" placeholder="Password" required>
              </div>
             
             
             <h4>Not have an account?
             <a href="register.jsp">Register</a></h4>
             
              <button type="submit"  name ="submit" value ="login" class="btn btn-success btn-block">Login</button>
          </form>
          <!--form end-->
        </div>
    </div>
</div>
</body>
</html>