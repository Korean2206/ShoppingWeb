<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<form class="form-horizontal" role="form" action="/admin/account/${uri}/${action}" enctype="multipart/form-data" method="post" >

    <div class="row">
        <!-- left column -->
        <div class="col-md-3" style="display: flex;align-items: center;">
            <div class="text-center">
                <img src="/product/${user.image}" id="userImage" class="avatar img-circle img-thumbnail"
                    alt="avatar">
                <h6>Avatar</h6>

                <input name="attach" type="file" class="form-control"
                    onchange="document.getElementById('userImage').src = window.URL.createObjectURL(this.files[0])">
            </div>
        </div>

        <!-- edit form column -->
        <div class="col-md-9 personal-info">
            <h3 style="color:#3f0097;">Thông tin :</h3>

            <div class="form-group">
                <label class="col-lg-3 control-label">Username:</label>
                <div class="col-lg-8">
                    <input name="username" value="${user.username}" class="form-control" type="text" ${uri == 'update' ? 'readonly' : ''}  >
                </div>
            </div>
            <div class="form-group">
                <input name="id" value="${item.id}" type="text" hidden >
                <label class="col-lg-3 control-label">Họ Tên:</label>
                <div class="col-lg-8">
                    <input name="fullname" value="${user.fullname}" class="form-control" type="text">
                </div>
            </div>
            
            
            <div class="form-group">
                <label class="col-lg-3 control-label">Password:</label>
                <div class="col-lg-8">
                    <input name="password" value="${user.password}" class="form-control" type="password">
                </div>
            </div>
            <div class="form-group" >
                <label class="col-lg-3 control-label">Giới tính:</label>
                <div class="col-lg-8">
                    <select name="gender" id="" style="width: 100%;">
                        <option value="gender" selected></option>
                        <option value="true" ${user.gender == 'true' ? 'selected' : ''}>Nam</option>
                        <option value="false" ${user.gender == 'false' ? 'selected' : ''}>Nữ</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label class="col-lg-3 control-label">Email:</label>
                <div class="col-lg-8">
                    <input name="email" value="${user.email}" class="form-control" type="text" value="">
                </div>
            </div>
            <div class="form-group">
                <label class="col-lg-3 control-label">SĐT:</label>
                <div class="col-lg-8">
                    <input name="mobile" value="${user.mobile}" class="form-control" type="text" value="">
                </div>
            </div>
            <div class="form-group">
                <label class="col-lg-3 control-label">Dịa chỉ:</label>
                <div class="col-lg-8">
                    <textarea name="address" class="form-control">${user.address}</textarea>
                </div>
            </div>
            <div class="form-group mt-5">
                <button formaction="/admin/account/${uri}/${action}" type="submit" style="background-color:#3f0097; border: none;" class="btn btn-primary mr-1">Save change</button>
                <button formaction="/admin/account/${uri}/${action}/cancel" style="background-color:#3f0097; border:none;" class="btn btn-primary">Cancel</button>
            </div>
            <h1>${ad}</h1>
        </div>
    </div>
</form>
