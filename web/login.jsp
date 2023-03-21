<%-- 
    Document   : login
    Created on : Mar 4, 2023, 9:13:19 PM
    Author     : msi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://code.jquery.com/jquery-2.1.0.min.js" ></script>
        <link rel="stylesheet" href="css/login.css"/>
        <title>Login</title>
    </head>
    <body>
        <form action="login" method="post">
            <div id="formWrapper">
                <div id="form">
                    <div class="logo">
                        <h1 class="text-center head">Book Seller</h1>
                    </div>
                    <p class="alert-danger" role="alert">
                        ${ms}
                    </p>
                    <p class="alert-success" role="alert">
                        ${success}
                    </p>
                    <div class="form-item">
                        <input type="text" name="name" value="${param.name}"  class="form-style"  placeholder="Username" autocomplete="off"/>
                    </div>
                    <div class="form-item">
                        <input type="password" name="pass" value="${param.pass}"  placeholder="Password" class="form-style" />
                        <!-- <div class="pw-view"><i class="fa fa-eye"></i></div> -->	
                    </div>
                    <div class="form-item">
                        <p class="pull-left"><a href="register"><small>Register</small></a></p>
                        <input type="submit" class="login pull-right" value="Log In">
                        <div class="clear-fix"></div>
                    </div>
                </div>
            </div>
        </form>
    </body>
</html>
