<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <html lang="en">

    <head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <link rel="stylesheet" href="/foruser/css/style.css" />
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
      <title>Document</title>
    </head>

    <body>
      <%@ include file="header.jsp" %>
        <main class="app_container mt-200" style="margin-bottom: 200px;">
          <section class="vh-100" style="text-align:center;">
            <c:if test="${count > 0}">
              <div class="container h-100">
                <div class="row d-flex justify-content-center align-items-center h-100">
                  <div class="col" >
                    <p style="text-align: left;"><span class="h2">Shopping Cart </span><span class="h4">(${count} item
                        in your cart)</span></p>
                    <div class="card mb-4">
                      <div class="card-body p-4">
                        <c:forEach var="item" items="${cart.items}">
                          <form action="/cart/update" method="post">
                            <input type="hidden" name="id" value="${item.product.id}">
                            <div class="row align-items-center">
                              <div class="col-md-2" style="max-width: 100px;">
                                <img src="/product/${item.product.image}" class="img-fluid"
                                  alt="Generic placeholder image">
                              </div>
                              <div class="col-md-2 d-flex justify-content-center">
                                <div>
                                  <p class="small text-muted mb-4 pb-2">Tên sp</p>
                                  <p class="lead fw-normal mb-0">${item.product.name}</p>
                                </div>
                              </div>
                              <div class="col-md-2 d-flex justify-content-center">
                                <div>
                                  <p class="small text-muted mb-4 pb-2">Số lượng</p>
                                  <div class="col-md-3 col-lg-3 col-xl-2 d-flex">
                                    <button class="btn btn-link px-2"
                                      onclick="this.parentNode.querySelector('input[type=number]').stepDown()">
                                      <i class="fa fa-minus"></i>
                                    </button>

                                    <input name="qty" value="${item.quantity}" type="number" onblur="this.form.submit()"
                                      style="width:50px;">

                                    <button class="btn btn-link px-2"
                                      onclick="this.parentNode.querySelector('input[type=number]').stepUp()">
                                      <i class="fa fa-plus"></i>
                                    </button>
                                  </div>
                                </div>
                              </div>
                              <div class="col-md-2 d-flex justify-content-center">
                                <div>
                                  <p class="small text-muted mb-4 pb-2">Giá</p>
                                  <p class="lead fw-normal mb-0">${item.product.price}</p>
                                </div>
                              </div>
                              <div class="col-md-2 d-flex justify-content-center">
                                <div>
                                  <p class="small text-muted mb-4 pb-2">Tổng tiền</p>
                                  <p class="lead fw-normal mb-0">${item.product.price * item.quantity}đ</p>
                                </div>
                              </div>
                              <div class="col-md-2 d-flex justify-content-center">
                                <div>
                                  <p></p>
                                  <a style="font-size: 30px; color: #000;"
                                    href="/cart/remove/?id=${item.product.id}&index=cart"><i class="fa fa-times"
                                      aria-hidden="true"></i></a>
                                </div>
                              </div>
                            </div>
                          </form>
                          <hr>
                        </c:forEach>
                      </div>
                    </div>

                    <div class="card mb-5">
                      <div class="card-body p-4">

                        <div class="float-end">
                          <p class="mb-0 me-5 d-flex align-items-center">
                            <span class="small text-muted me-2">Tổng tiền:</span> <span class="lead fw-normal">${amount}
                              đ</span>
                          </p>
                        </div>

                      </div>
                    </div>

                    <div class="d-flex justify-content-end">
                      <a href="/home/index"  class="btn btn-light btn-lg me-2">Tiếp tục mua hàng</a>
                      <a  href="/cart/pay" class="btn btn-dark btn-lg">Thanh toán</a>
                    </div>

                  </div>
                </div>
            </c:if>
            <c:if test="${count == 0}">
              <img style="caret-color: transparent;" src="/foruser/img/cartEmpty.webp" alt="">

            </c:if>
            </div>
          </section>

        </main>

        <jsp:include page="footer.jsp"></jsp:include>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
          integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
          crossorigin="anonymous"></script>
    </body>

    </html>