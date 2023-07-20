<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/foruser/css/style.css"/> 
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Document</title>
</head>
<body>
    <%@ include file="header.jsp" %>
    <%@ include file="banner.jsp" %>
    <main class="app_container">
            <div class="container app_product mt-4">
                <div class="row mt-5">
                    <div class="row">
                        <h2 class="app_product__header text-center">
                            <a href="#">BEST SELLER
                            </a>
                        </h2>
                    </div>
                    
                        <div class="row mt-3">
                            <c:forEach var="item" items="${items}">
                            <div class="col-sm-3 py-2 ">
                                <div class="card" action="/home/index">
                                    <img src="/product/${item.image}"  class="card-img-top product_img" alt="...">
                                    <div class="card-body">
                                        <h6 class="card-title text-center">
                                            ${item.name}
                                        </h6>
                                        <p class="card-text text-center">${item.price}</p>
                                        <a href="/cart/add/?index=${view}&id=${item.id}" class="btn btn-secondary " >Thêm vào giỏ hàng</a>
                                        <a href="#"  class="btn btn-dark mt-1 ">Mua ngay</a>
                                    </div>
                                </div>
                            </div>
                            </c:forEach>
                        </div> 
                </div>
                <div class="row mt-5">
                    <div class="row">
                        <h2 class="app_product__header text-center">
                            <a href="#">LOOKBOOK</a>
                        </h2>
                    </div>
                    <div class="row mt-5">
                        <div class="col-sm-6">
                            <div class="card border-0" >
                                <img src="foruser/img/look1.webp" height="350" class="card-img-top" alt="...">
                                <div class="card-body">
                                  <p class="card-text text-center fw-bolder fs-4">CAT & RABBIT COLLECTION</p>
                                </div>
                              </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="card border-0" >
                                <img src="foruser/img/look2.webp"height="350" class="card-img-top" alt="...">
                                <div class="card-body">
                                  <p class="card-text text-center fw-bolder fs-4">HELIANTHUS COLLECTION</p>
                                </div>
                              </div>
                        </div>
                    </div>
                    <div class="row mt-5">
                        <div class="col-sm-6">
                            <div class="card border-0" >
                                <img src="foruser/img/look3.webp" height="350" class="card-img-top" alt="...">
                                <div class="card-body">
                                  <p class="card-text text-center fw-bolder fs-4">SPRING 2023 COLLECTION</p>
                                </div>
                              </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="card border-0" >
                                <img src="foruser/img/look4.webp" height="350" class="card-img-top" alt="...">
                                <div class="card-body">
                                  <p class="card-text text-center fw-bolder fs-4">SWEATSHIRT COLLECTION</p>
                                </div>
                              </div>
                        </div>
                    </div>
                </div>
            </div>
        
    </main>
    
    <jsp:include page="footer.jsp"></jsp:include>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>