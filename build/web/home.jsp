<%-- 
    Document   : home
    Created on : Feb 19, 2023, 9:59:26 PM
    Author     : msi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Book Store</title>
        <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
        <link rel="shortcut icon" href="css/images/favicon.ico" />
        <link rel="stylesheet" href="css/new.css" type="text/css" media="all" />
        <script type="text/javascript" src="js/jquery-1.6.2.min.js"></script>
        <script type="text/javascript" src="js/jquery.jcarousel.min.js"></script>
        <!--[if IE 6]>
                <script type="text/javascript" src="js/png-fix.js"></script>
        <![endif]-->
        <script type="text/javascript" src="js/functions.js"></script>
    </head>
    <body>
        <!-- Header -->
        <div id="header" class="shell">
            <div id="logo"><h1>BOOKSELLER</h1></div>
            <!-- Navigation -->
            <div id="navigation">
                <ul>
                    <li><a href="home">Home</a></li>

                    <li><a href="product?index=1">Products</a></li>

                        <c:if test="${sessionScope.account.role == 'admin'}">
                        <li><a href="Pmanagement?index=1">Management product</a></li>
                        <li><a href="Amanagement">Management account</a></li>
                        </c:if>
                        <c:if test="${sessionScope.account.role == 'seller'}">
                        <li><a href="Pmanagement?index=1">Management product</a></li>
                        </c:if>
                    <li><a href="#">Contact</a></li>
                    <li><a href="search">Search</a></li>

                </ul>
            </div>
            <!-- End Navigation -->
            <div class="cl">&nbsp;</div>
            <!-- Login-details -->
            <div id="login-details">
                <c:if test="${account == null}">
                    <p><a href="#" class="cart" ><img src="css/images/cart-icon.png" alt="" /></a> <a href="login" class="sum">Login</a></p>
                        </c:if>
                        <c:if test="${account != null}">
                    <p>Welcome, <a href="profile?aid=${account.uname}" id="user">${account.uname}</a> </p><p><a href="#" class="cart" ><img src="css/images/cart-icon.png" alt="" /></a> <a href="logout" class="sum">Logout</a></p>
                        </c:if>
            </div>
            <!-- End Login-details -->
        </div>
        <!-- End Header -->
        <!-- Slider -->
        <div id="slider">
            <div class="shell">
                <ul>
                    <li>
                        <div class="image">
                            <img src="css/images/books.png" alt="" />
                        </div>
                        <div class="details">
                            <h2>Bestsellers </h2>
                            <h3>Special Offers</h3>
                            <p class="title"></p>
                            <p class="description"></p>
                            <a href="#" class="read-more-btn">Read More</a>
                        </div>
                    </li>
                    <li>
                        <div class="image">
                            <img src="css/images/books.png" alt="" />
                        </div>
                        <div class="details">
                            <h2>Bestsellers</h2>
                            <h3>Special Offers</h3>
<!--                            <p class="title">Pellentesque congue lorem quis massa blandit non pretium nisi pharetra</p>
                            <p class="description">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent id odio in tortor scelerisque dictum. Phasellus varius sem sit amet metus volutpat vel vehicula nunc lacinia.</p>-->
                            <a href="#" class="read-more-btn">Read More</a>
                        </div>
                    </li>
                    <li>
                        <div class="image">
                            <img src="css/images/books.png" alt="" />
                        </div>
                        <div class="details">
                            <h2>Bestsellers</h2>
                            <h3>Special Offers</h3>
<!--                            <p class="title">Pellentesque congue lorem quis massa blandit non pretium nisi pharetra</p>
                            <p class="description">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent id odio in tortor scelerisque dictum. Phasellus varius sem sit amet metus volutpat vel vehicula nunc lacinia.</p>-->
                            <a href="#" class="read-more-btn">Read More</a>
                        </div>
                    </li>
                    <li>
                        <div class="image">
                            <img src="css/images/books.png" alt="" />
                        </div>
                        <div class="details">
                            <h2>Bestsellers</h2>
                            <h3>Special Offers</h3>
<!--                            <p class="title">Pellentesque congue lorem quis massa blandit non pretium nisi pharetra</p>
                            <p class="description">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent id odio in tortor scelerisque dictum. Phasellus varius sem sit amet metus volutpat vel vehicula nunc lacinia.</p>-->
                            <a href="#" class="read-more-btn">Read More</a>
                        </div>
                    </li>
                </ul>
                <div class="nav">
                    <a href="#">1</a>
                    <a href="#">2</a>
                    <a href="#">3</a>
                    <a href="#">4</a>
                </div>
            </div>
        </div>
        <!-- End Slider -->
        <!-- Main -->
        <div id="main" class="shell">
            <!-- Sidebar -->
            <div id="sidebar">
                <ul class="categories">
                    <li>
                        <h4>Categories</h4>
                        <ul>
                            <c:forEach items="${requestScope.cate}" var="c">
                                <li><a href="category?cid=${c.id}">${c.name}</a></li>
                                </c:forEach>                         
                        </ul>
                    </li>
                    <li>
                        <h4>Fillter</h4>
                        <ul>
           
                            <form action="fillter?index=${i}" method="get">
                                <input type="radio" name="option" value="1"/>From high to low <Br>
                                <input type="radio" name="option" value="2"/>From low to high <br><!-- comment -->
                                <input type="submit" value="Fillter"/>
                            </form>
                                
                        </ul>
                    </li>
                </ul>
            </div>
            <!-- End Sidebar -->
            <!-- Content -->
            <div id="content">
                <!-- Products -->

                <div class="products">
                    <h3>Newest products</h3>
                    <ul>
                        <c:forEach items="${requestScope.book}" var="b">
                            <li>
                                <div class="product">
                                    <a href="detail?bid=${b.id}" class="info">                                
                                        <span class="holder">
                                            <img src="${b.image}" alt="Tat Den" />
                                            <span class="book-name">${b.title}</span>
                                            <span class="author">by <b>${b.author}</b></span>
                                        </span>
                                    </a>
                                    <a href="detail?bid=${b.id}" class="buy-btn">ADD TO CARD <span class="price"><span class="low">$</span>${b.price}</span></a>
                                </div>
                            </li>                           
                        </c:forEach>
                    </ul>
                    <!-- End Products -->
                </div>
                <div class="cl">&nbsp;</div>
                <!-- Best-sellers -->
                <div id="paging">
     



                    <!--                                        <ul>
                                                                <li>
                                                                    <div class="product">
                                                                        <a href="#">
                                                                            <img src="css/images/image-best01.jpg" alt="" />
                                                                            <span class="book-name">Book Name </span>
                                                                            <span class="author">by John Smith</span>
                                                                            <span class="price"><span class="low">$</span>35<span class="high">00</span></span>
                                                                        </a>
                                                                    </div>
                                                                </li>
                                                                <li>
                                                                    <div class="product">
                                                                        <a href="#">
                                                                            <img src="css/images/image-best02.jpg" alt="" />
                                                                            <span class="book-name">Book Name </span>
                                                                            <span class="author">by John Smith</span>
                                                                            <span class="price"><span class="low">$</span>45<span class="high">00</span></span>
                                                                        </a>
                                                                    </div>
                                                                </li>
                                                                <li>
                                                                    <div class="product">
                                                                        <a href="#">
                                                                            <img src="css/images/image-best03.jpg" alt="" />
                                                                            <span class="book-name">Book Name </span>
                                                                            <span class="author">by John Smith</span>
                                                                            <span class="price"><span class="low">$</span>15<span class="high">00</span></span>
                                                                        </a>
                                                                    </div>
                                                                </li>
                                                                <li>
                                                                    <div class="product">
                                                                        <a href="#">
                                                                            <img src="css/images/image-best04.jpg" alt="" />
                                                                            <span class="book-name">Book Name </span>
                                                                            <span class="author">by John Smith</span>
                                                                            <span class="price"><span class="low">$</span>27<span class="high">99</span></span>
                                                                        </a>
                                                                    </div>
                                                                </li>
                                                                <li>
                                                                    <div class="product">
                                                                        <a href="#">
                                                                            <img src="css/images/image-best01.jpg" alt="" />
                                                                            <span class="book-name">Book Name </span>
                                                                            <span class="author">by John Smith</span>
                                                                            <span class="price"><span class="low">$</span>35<span class="high">00</span></span>
                                                                        </a>
                                                                    </div>
                                                                </li>
                                                                <li>
                                                                    <div class="product">
                                                                        <a href="#">
                                                                            <img src="css/images/image-best02.jpg" alt="" />
                                                                            <span class="book-name">Book Name </span>
                                                                            <span class="author">by John Smith</span>
                                                                            <span class="price"><span class="low">$</span>45<span class="high">00</span></span>
                                                                        </a>
                                                                    </div>
                                                                </li>
                                                                <li>
                                                                    <div class="product">
                                                                        <a href="#">
                                                                            <img src="css/images/image-best03.jpg" alt="" />
                                                                            <span class="book-name">Book Name </span>
                                                                            <span class="author">by John Smith</span>
                                                                            <span class="price"><span class="low">$</span>15<span class="high">00</span></span>
                                                                        </a>
                                                                    </div>
                                                                </li>
                                                                <li>
                                                                    <div class="product">
                                                                        <a href="#">
                                                                            <img src="css/images/image-best04.jpg" alt="" />
                                                                            <span class="book-name">Book Name </span>
                                                                            <span class="author">by John Smith</span>
                                                                            <span class="price"><span class="low">$</span>27<span class="high">99</span></span>
                                                                        </a>
                                                                    </div>
                                                                </li>
                                                            </ul>-->
                </div>
                <!-- End Best-sellers -->
            </div>
            <!-- End Content -->
            <div class="cl">&nbsp;</div>
        </div>
        <!-- End Main -->
        <!-- Footer -->
        <div id="footer" class="shell">
            <div class="top">
                <div class="cnt">
                    <div class="col about">
                    </div>
                    <div class="col store">
                        <h4>Store</h4>


                    </div>

                </div>
            </div>
        </div>
        <!-- End Footer -->
    </body>
</html>
