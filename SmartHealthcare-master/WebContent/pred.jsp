<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>HealthCare system</title>
 <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >
    <link href="css/feed.css" type="text/css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" ></script>
    
</head>

<body>
<%
if(session.getAttribute("username")==null)
{
  //request.setAttribute("user", session.getAttribute("username"));
  request.getRequestDispatcher("login.jsp").forward(request,response);    
}

 %>
<div class="container-fluid bg">
    <div class="row">
        <div class="col-md-4 col-sm-4 col-xs-12"></div>
        <div class="col-md-4 col-sm-4   col-xs-12">
        <!--form start-->
        <%
         session.setAttribute("sym1",request.getParameter("symptom1"));
         session.setAttribute("sym2",request.getParameter("symptom2"));
         session.setAttribute("sym3",request.getParameter("symptom3"));
         session.setAttribute("sym4",request.getParameter("symptom4"));
         %>
         <form class="form-container" action ="Pred" method="post">
             <h1><b>Disease Prediction</b> </h1>
             
             <div class="form-group">
                <label for="exampleInputSymptom1">Symptom 1</label>
                <input type="text" class="form-control" id="exampleInputSymptom1" name="symptom1" placeholder="Symptom1"value=<% if ((session.getAttribute("sym1"))!=null){ %>
<%= session.getAttribute("sym1")%>
<%}%>>
              </div>
             
              <div class="form-group">
                <label for="exampleInputSymptom2">Symptom 2</label>
                <input type="text" class="form-control" id="exampleInputSymptom2 " name="symptom2" placeholder="Symptom2"value=<% if ((session.getAttribute("sym2"))!=null){ %>
<%= session.getAttribute("sym2")%>
<%}%>>
              </div>
             
              <div class="form-group">
                <label for="exampleInputSymptom3">Symptom 3</label>
                <input type="text" class="form-control" id="exampleInputSymptom3" name="symptom3" placeholder="Symptom3"value=<% if ((session.getAttribute("sym3"))!=null){ %>
<%= session.getAttribute("sym3")%>
<%}%>>
              </div>
             
                
                <div class="form-group">
                <label for="exampleInputSymptom4">Symptom 4</label>
                <input type="text" class="form-control" id="exampleInputSymptom4" name="symptom4" placeholder="Symptom4"value=<% if ((session.getAttribute("sym4"))!=null){ %>
<%= session.getAttribute("sym4")%>
<%}%>>
              </div>
             
             
              <button type="GetPredicton" class="btn btn-success btn-block"> Get Prediction </button>
             
                  <div class="form-group">
                    <label for="exampleInputdisease"></label>
                    <textarea class="form-control" rows="4" id="exampleInputdisease" placeholder="Diagnosed Disease">${message}</textarea>
                  </div>


            
          
            </form>
          <!--form end-->
        </div>
    </div>
</div>

</body>
</html>