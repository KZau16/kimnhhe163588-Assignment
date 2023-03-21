<%-- 
    Document   : detail
    Created on : Feb 27, 2023, 10:43:07 PM
    Author     : msi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.bundle.min.js"></script>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    </head>
    <body>
        
        <div class="container">
            <div class="card">
                <div class="card-body">
                    <h3 class="card-title">${bo.title}</h3>
                    <div class="row">
                        <div class="col-lg-5 col-md-5 col-sm-6">
                            <div class="white-box text-center"><img src="${bo.image}" class="img-responsive"></div>
                        </div>
                        <div class="col-lg-7 col-md-7 col-sm-6">
                            <h4 class="box-title mt-5">Product description</h4>
                            <p><small>${bo.description}</small></p>
                            <h2 class="mt-5">
                                ${bo.price}$
                            </h2>
                            <button class="btn btn-dark btn-rounded mr-1" data-toggle="tooltip" title="" data-original-title="Add to cart">
                                <i class="fa fa-shopping-cart"></i>
                            </button>
                            <button class="btn btn-primary btn-rounded">Buy Now</button>
                            
                            </ul>
                        </div>
                        <div class="col-lg-12 col-md-12 col-sm-12">
                            <h3 class="box-title mt-5">General Info</h3>
                            <div class="table-responsive">
                                <table class="table table-striped table-product">
                                    <tbody>
                                        <tr>
                                            <td width="390">Title</td>
                                            <td>${bo.title}</td>
                                        </tr>
                                        <tr>
                                            <td>Author</td>
                                            <td>${bo.author}</td>
                                        </tr>                                    
                                        <tr>
                                            <td>Quantity</td>
                                            <td>${bo.quantity}</td>
                                        </tr>
                                        <tr>
                                            <td>Publisher</td>
                                            <td>${bo.publisher}</td>
                                        </tr>
                                        <tr>
                                            <td>Genre</td>
                                            <td>${bo.genre}</td>
                                        </tr>

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <style type="text/css">
            body{
                background-color: #edf1f5;
                margin-top:20px;
                background: #3b3b3b url(images/body.png);
            }
            .card {
                margin-bottom: 30px;
            }
            .card {
                position: relative;
                display: flex;
                flex-direction: column;
                min-width: 0;
                word-wrap: break-word;
                background-color: #fff;
                background-clip: border-box;
                border: 0 solid transparent;
                border-radius: 0;
            }
            .card .card-subtitle {
                font-weight: 300;
                margin-bottom: 10px;
                color: #8898aa;
            }
            .table-product.table-striped tbody tr:nth-of-type(odd) {
                background-color: #f3f8fa!important
            }
            .table-product td{
                border-top: 0px solid #dee2e6 !important;
                color: #728299!important;
            }
        </style>


        <script type="text/javascript">

        </script>      
    </body>
</html>
