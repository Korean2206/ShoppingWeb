<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<base href="${pageContext.servletContext.contextPath}/">
    <header>
        <nav class="navbar navbar-light bg-dark bg-222">
            <div class="container-fluid">
                <ul class="nav-left">
                  <c:if test="${username == null}">
                    <li><a href="/user/login">Đăng nhập</a></li>
                    <li><a href="/user/register">Đăng ký</a></li>
                  </c:if>
                  <c:if test="${username != null}">
                    <li class="header_username"><a href="/user/profile">${username}</a>
                      <ul class="header_username--logout">
                        <li><a href="/user/logout">
                          Đăng xuất
                        </a>
                      </li>
                      </ul>
                    </li>
                  </c:if>
                </ul>
                <ul class="nav-right">
                    <li style="cursor: pointer;"    >
                        <i  class="fa fa-search" aria-hidden="true"></i>
                        <form class="nav-search--click" action="/product/search" method="post">
                            <input type="text" placeholder="search" name="keyword" value="${param.keyword}">
                            <button><i class="fa fa-search" aria-hidden="true"></i></button>
                        </form>
                    </li>
                    <li class="nav-cart"><a href="/cart/index"><i class="fa fa-shopping-cart" aria-hidden="true">
                    </i>

                        <span style="color:#848484; margin-left: 6px;">Giỏ hàng:</span> (${count}) Sản phẩm</a>
                        <ul class="nav-cart--items" style="color:#000; padding: 10px; min-width:400px;">
                          <c:if test="${count > 0}">
                              <c:forEach var="item" items="${cart.items}">
                                <li style="display: flex;align-items: center;"><img src="/product/${item.product.image}" style="max-width: 50px;" alt="">
                                  <span style="margin: 0 30px;">${item.product.name}</span><span>SL:${item.quantity}  |   </span><span>    ${item.product.price} vnđ    </span><a href="/cart/remove/?id=${item.product.id}&index=${view}${view1}"><i style="position: absolute;right: 10px;align-items: center;" class="fa fa-times" aria-hidden="true"></i></a>
                                </li>
                                <hr>
                              </c:forEach>
                            <li style="text-align:end;"><a href="/cart/index" style="color: #fff; text-decoration: none" class="btn btn-dark">Xem giỏ hàng</a></li>
                          </c:if>
                          <c:if test="${count == 0}">
                          <li>
                            <img style="width: 100%; height: 100%;" src="/foruser/img/cartEmpty.webp" alt="">
                          </li>
                          </c:if>
                          </ul>
                    </li>
                    
                </ul>

            </div>
        </nav>
        <nav class="navbar navbar-expand-sm navbar-light header_navbar" id="neubar">
            <div class="container">
              <a class="navbar-brand" href="/home/index"><img src="foruser/img/logo.webp" height="60" /></a>
              <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
          
              <div class=" collapse navbar-collapse" id="navbarNavDropdown">
                <ul class="navbar-nav ms-auto ">
                  <li class="nav-item">
                    <a class="nav-link mx-2 active" aria-current="page" href="/home/index">TRANG CHỦ</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link mx-2" href="#">GIÓI THIỆU</a>
                  </li>
                  
                  <li class="nav-item dropdown">
                    <a class="nav-link mx-2 dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                      SẢN PHẨM
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                      <li><a class="dropdown-item" href="/product/men">Đồ nam</a></li>
                      <li><a class="dropdown-item" href="/product/women">Đồ nữ</a></li>
                      <li><a class="dropdown-item" href="/product/best_seller">Best seller</a></li>
                    </ul>
                  </li>
                  
                  <li class="nav-item">
                    <a class="nav-link mx-2" href="#">LIÊN HỆ</a>
                  </li>
                </ul>
              </div>
            </div>
          </nav>
    </header>