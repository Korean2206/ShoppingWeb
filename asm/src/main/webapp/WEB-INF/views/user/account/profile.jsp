<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link rel="stylesheet" href="/foruser/css/style.css" />
            <link rel="stylesheet"
                href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
                crossorigin="anonymous">
            <title>Document</title>
        </head>

        <body>
            <jsp:include page="../header.jsp"></jsp:include>
            <main class=" register_header" style="margin-left: 100px; margin-right:100px;margin-top: 200px;">
                <h1 style="color:#212529; text-align: center;" class="">Edit Profile</h1>
                <hr>
                <div class="row">
                    <!-- left column -->

                    <!-- edit form column -->
                    <div class=" personal-info">
                        <form class="form-horizontal" role="form" action="user/profile" enctype="multipart/form-data"
                            method="post">
                            <div class="row">
                                <div class="col-md-3">
                                    <div class="text-center">
                                        <img style="max-height: 200px;" id="avatar" name="image"
                                            src="/avatar/${infor.image}" class="avatar img-circle img-thumbnail"
                                            alt="avatar">
                                        <h6>Cập nhật ảnh khác...</h6>

                                        <input name="attach" type="file" class="form-control"
                                            onchange="document.getElementById('avatar').src = window.URL.createObjectURL(this.files[0])">
                                    </div>
                                </div>
                                <div class="col-md-9">

                                    <div class="form-group">
                                        <label class="col-lg-3 control-label">Họ tên:</label>
                                        <div class="col-lg-8">
                                            <input name="fullname" value="${infor.fullname}" class="form-control"
                                                type="text">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-lg-3 control-label">Email:</label>
                                        <div class="col-lg-8">
                                            <input name="email" value="${infor.email}" class="form-control" type="text">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-lg-3 control-label">Password:</label>
                                        <div class="col-lg-8">
                                            <input name="password" value="${infor.password}" class="form-control"
                                                type="text" value="">
                                        </div>
                                    </div>

                                    <div class="form-group mt-5">
                                        <button type="submit" style="background-color:#212529; border: none;" onclick="saveAlert()"
                                            class="btn btn-primary mr-1">Save change</button>
                                        <button formaction="/user/profile/cancel"
                                            style="background-color:#212529; border:none;" onclick="cancelAlert()"
                                            class="btn btn-primary">Cancel</button>
                                    </div>
                                </div>

                            </div>

                        </form>
                    </div>
                </div>
            </main>
            <jsp:include page="../footer.jsp"></jsp:include>

            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
                crossorigin="anonymous"></script>
            <script>
                function saveAlert() {
                    alert("Đã lưu thay đổi");
                }
                function cancelAlert() {
                    alert("Đã hủy thay đổi");
                }
            </script>
        </body>

        </html>