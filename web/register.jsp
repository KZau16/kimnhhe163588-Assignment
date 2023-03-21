<%-- 
    Document   : login
    Created on : Mar 4, 2023, 9:13:19 PM
    Author     : msi
--%>

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
        <form action="register" method="post">
            <div id="formWrapper">
                <div id="form">
                    <div class="logo">
                        <h1 class="text-center head">Book Seller</h1>
                    </div>
                     <p class="alert-danger" role="alert">
                        ${error}
                        ${error1}
                    </p>
                    <div class="form-item">
                        <input type="text" name="name"  class="form-style"  placeholder="Username" autocomplete="off"/>
                    </div>
                    <div class="form-item">
                        <input type="password" name="pass"  placeholder="Password" class="form-style" />
                        <!-- <div class="pw-view"><i class="fa fa-eye"></i></div> -->	
                    </div>
                    <div class="form-item">
                        <input type="password" name="repass"  placeholder="Re-enter Password" class="form-style" />
                        <!-- <div class="pw-view"><i class="fa fa-eye"></i></div> -->	
                    </div>
                    <div class="form-item">
                        <p class="pull-left"><a href="login"><small>Login</small></a></p>
                        <input type="submit" class="login pull-right" value="Register">
                        <div class="clear-fix"></div>
                    </div>
                </div>
            </div>
        </form>
    </body>
</html>
