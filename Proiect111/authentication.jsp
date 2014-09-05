<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Authentication</title>
</head>
<body>

  <form name="authentication" action="RegServlet" method="post">

  <table cellpadding="5" cellspacing="5">
  
    <tr>
     <td>Role</td>
     <td><input type="text" name="trole"/></td>
    </tr>
  
  	<tr>
     <td>Username</td>
     <td><input type="text" name="tuser"/></td>
    </tr>
    
    <tr>
     <td>Password</td>
     <td><input type="password" name="tpass"/></td>
    </tr>
    
    <tr>
     <td><button type="submit">Login</button></td>
     
    </tr>

   </table>
  </form>
</body>
</html>