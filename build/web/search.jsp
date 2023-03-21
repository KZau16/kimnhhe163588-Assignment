<%-- 
    Document   : search
    Created on : Mar 3, 2023, 9:57:39 PM
    Author     : msi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/search.css"/>
        <<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
        <title>Search</title>
    </head>
    <body>
        <div class="container">

            <div class="row height d-flex justify-content-center align-items-center">

                <div class="col-md-8">
                 
                    <div class="search">
                        <form action="search" method="post">
                        <i class="fa fa-search"></i>
                        <input type="text" name="search"class="form-control" placeholder="Search">
                        <button class="btn btn-primary">Search</button>
                        </form>
                    </div>

                </div>

            </div>
        </div>
    </body>
</html>
