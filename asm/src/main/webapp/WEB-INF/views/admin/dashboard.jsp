<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html; charset=UTF-8" %>

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width,
                   initial-scale=1.0">
        <title>Admin</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
            integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="/foradmin/css/responsive.css">
        <link rel="stylesheet" href="/foradmin/css/style.css">

    </head>

    <body>

        <!-- for header part -->
        <header>

            <div class="logosec">
                <i class="fa fa-bars icn menuicn" id="menuicn" aria-hidden="true"></i>
                <div class="logo">ADMIN</div>
            </div>

            <div class="searchbar">
                <input type="text" placeholder="Search">
                <div class="searchbtn">
                    <i class="fa fa-search" style="color: #fff;" aria-hidden="true"></i>
                </div>
            </div>

            <div class="message">
                <div class="circle"></div>
                <i class="fa fa-bell" style="font-size: 28px;" aria-hidden="true"></i>
                <div class="dp">
                    <img src="/avatar/${img}" class="dpicn" alt="dp" style="height: 100%;
                    width: 100%;
                    background-color: #626262;
                    border-radius: 50%;
                    display: flex;
                    align-items: center;
                    justify-content: center;
                    overflow: hidden;">
                </div>
            </div>

        </header>

        <div class="main-container">
            <div class="navcontainer">
                <nav class="nav">
                    <div class="nav-upper-options">
                        <hr style="width: 100%;margin: 0;">
                        <H6 style="margin: 0;">DANH MỤC QUẢN LÝ</H6>
                        <hr style="width: 100%;margin: 0;">
                        <details class="">
                            <summary style="font-size: 16px;" style="font-size: 16px;"> Quản lý sản phẩm</summary>
                            <ul>
                                <li><a href="/admin/product/list">Danh sách sản phẩm</a></li>
                                <li style="margin-top:10px;"><a href="/admin/product/create">Thêm sản phẩm</a></li>
                            </ul>

                        </details>

                        <details class="">
                            <summary style="font-size: 16px;" style="font-size: 16px;"> Quản lý đơn hàng</summary>
                            <ul>
                                <li><a href="/admin/order/list">Danh sách Đơn hàng</a></li>

                            </ul>

                        </details>

                        <details class="">
                            <summary style="font-size: 16px;" style="font-size: 16px;"> Quản lý khách hàng</summary>
                            <ul>
                                <li><a href="/admin/account/customer">Danh sách khách hàng</a></li>
                                <li style="margin-top:10px;"><a href="/admin/account/customer/create">Thêm khách hàng</a></li>

                            </ul>

                        </details>

                        <details class="">
                            <summary style="font-size: 16px;" style="font-size: 16px;"> Quản lý nhân viên</summary>
                            <ul>
                                <li><a href="/admin/account/employee">Danh sách nhân viên</a></li>
                                <li style="margin-top:10px;"><a href="/admin/account/employee/create">Thêm nhân viên</a></li>

                            </ul>

                        </details>
                        <hr style="width: 100%;margin: 0;">
                        <H6 style="margin: 0;">ĐĂNG NHẬP HỆ THỐNG</H6>
                        <hr style="width: 100%;margin: 0;">


                        <a href="/admin/profile" style="text-decoration: none;color:#000;" class="nav-option option6">
                            <i class="fa fa-user" style="font-size:30px" aria-hidden="true"></i>
                            <h3 style="font-size: 16px;"> Tài khoản</h3>
                        </a>

                        <form action="/admin/log_out" method="post">
                            <button style="border:none; background-color:#fff;">
                                <div class="nav-option logout">
                                    <i class="fa fa-sign-out" style="font-size:30px" aria-hidden="true"></i>
                                    <h3 style="font-size: 16px;">Logout</h3>
                                </div>
                            </button>
                        </form>


                    </div>
                </nav>
            </div>
            <div class="main">
                <jsp:include page="${view}"></jsp:include>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
        <script src="/foradmin/js/index.js"></script>
    </body>

</html>