<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >
    <link href="css/global.css" type="text/css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" ></script>
</head>
<body>
<div class="container-fluid bg">
    <div class="row">
        <div class="col-md-4 col-sm-4 col-xs-12"></div>
        <div class="col-md-4 col-sm-4   col-xs-12">
      <!-- <h5>${message}</h5> -->
        <!--form start-->
         <form class="form-container" action="Register" method ="post">
             <h1><b>SignUp</b> </h1>
          
             <div class="form-group">
                <label for="exampleInputName1">Name</label>
                <input type="text"  name ="username" class="form-control" id="exampleInputName1" placeholder="UserName">
              </div>
             
             <div class="form-group">
                <label for="exampleInputContact">Contact</label>
                <input type="number"  name ="phone" class="form-control" id="exampleInputContact" placeholder="Contact No. ">
              </div>
             
             <div class="form-group">
                <label for="exampleInputAge">Age</label>
                <input type="number"  name ="age" class="form-control" id="exampleInputAge" placeholder="Age">
              </div>
             
              <div class="form-group">
                <label for="exampleInputEmail1">Email</label>
                <input type="email" name ="email" class="form-control" id="exampleInputEmail1" placeholder="Email Address">
              </div>
              <div class="form-group">
                <label for="exampleInputPassword1">Password</label>
                <input type="password" name ="password" class="form-control" id="exampleInputPassword1" placeholder="Password(maximum 10 characters)">
              </div>
             
             <div class="form-group">
                   <label for="exampleInputGender">Gender</label>
                 <div class="radio">
                 <select class ="form-control" name="gender">
                   <option value="Male">Male</option>
                   <option value="Female">Female</option>
                   <option value="Others">Others</option>
                 </select>
                 </div>
              </div>
             
            <h5>Already have an account?
             <a href="login.jsp">login</a></h5>
            
              <button type="submit" name ="submit" class="btn btn-success btn-block">Register</button>
          </form>
          <!--form end-->
        </div>
    </div>
</div>

</body>
</html>