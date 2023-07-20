<%@ page contentType="text/html; charset=UTF-8" %>

    <div class="container bootstrap snippets bootdey">
        <h1 style="color:#3f0097;" class="">Edit Profile</h1>
        <hr>
        <form class="form-horizontal" role="form" action="/admin/profile" enctype="multipart/form-data" method="post">

            <div class="row">
                <!-- left column -->
                <div class="col-md-3">
                    <div class="text-center">
                        <img src="/avatar/${user.image}" id="adminAvatar" class="avatar img-circle img-thumbnail"
                            alt="avatar">
                        <h6>Cập nhật ảnh khác...</h6>

                        <input name="attach" type="file" class="form-control"
                            onchange="document.getElementById('adminAvatar').src = window.URL.createObjectURL(this.files[0])">
                    </div>
                </div>

                <!-- edit form column -->
                <div class="col-md-9 personal-info">
                    <h3>Thông tin cá nhân</h3>

                    <div class="form-group">
                        <label class="col-lg-3 control-label">Họ tên:</label>
                        <div class="col-lg-8">
                            <input name="fullname" value="${user.fullname}" class="form-control" type="text">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-3 control-label">User name:</label>
                        <div class="col-lg-8">
                            <input name="username" value="${user.username}" class="form-control" type="text">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-3 control-label">Password:</label>
                        <div class="col-lg-8">
                            <input name="password" value="${user.password}" class="form-control" type="text" value="">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-lg-3 control-label">Email:</label>
                        <div class="col-lg-8">
                            <input name="email" value="${user.email}" class="form-control" type="text">
                        </div>
                    </div>
                    <div class="form-group mt-5">
                        <button type="submit" style="background-color:#3f0097; border: none;" class="btn btn-primary mr-1">Save change</button>
                        <button formaction="/admin/profile/cancel" style="background-color:#3f0097; border:none;" class="btn btn-primary">Cancel</button>
                    </div>
                </div>
            </div>
        </form>
    </div>
    <hr>