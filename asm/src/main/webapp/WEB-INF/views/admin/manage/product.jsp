<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<form class="form-horizontal" role="form" action="/admin/product/${uri}" enctype="multipart/form-data" method="post" >

    <div class="row">
        <!-- left column -->
        <div class="col-md-3" style="display: flex;align-items: center;">
            <div class="text-center">
                <img src="/product/${item.image}" id="productImage" class="avatar img-circle img-thumbnail"
                    alt="avatar">
                <h6>Ảnh sản phẩm</h6>

                <input name="attach" type="file" class="form-control"
                    onchange="document.getElementById('productImage').src = window.URL.createObjectURL(this.files[0])">
            </div>
        </div>

        <!-- edit form column -->
        <div class="col-md-9 personal-info">
            <h3 style="color:#3f0097;">Thông tin Sản phẩm</h3>

            <div class="form-group">
                <input name="id" value="${item.id}" type="text" hidden >
                <label class="col-lg-3 control-label">Tên sản phẩm:</label>
                <div class="col-lg-8">
                    <input name="name" value="${item.name}" class="form-control" type="text">
                </div>
            </div>
            <div class="form-group" style="display: inline-block; width: 30%;">
                <label class="col-lg-6 control-label">Dành cho:</label>
                <div class="col-lg-8" >
                    <select name="gender" style="width: 100%;" >
                        <option value="ps" selected></option>
                        <option value="true" ${item.category.gender == 'true' ? 'selected' : ''}>Nam</option>
                        <option value="false" ${item.category.gender == 'false' ? 'selected' : ''}>Nữ</option>
                    </select>
                </div>
            </div>
            <div class="form-group" style="display: inline-block;width: 30%;">
                <label class="col-lg-6 control-label">Loại:</label>
                <div class="col-lg-8">
                    <select name="loai" style="width: 100%;">
                        <option value="ps" selected></option>
                        <c:forEach var="c" items="${categories}">
                            <option value="${c.name}"${item.category.name == c.name ? 'selected' : ''}>${c.name}</option>
                        </c:forEach>
                    </select>                
                </div>
            </div>
            <div class="form-group">
                <label class="col-lg-3 control-label">Giá sản phẩm:</label>
                <div class="col-lg-8">
                    <input name="price" value="${item.price}" class="form-control" type="text">
                </div>
            </div>
            <div class="form-group">
                <label class="col-lg-3 control-label">Số lượng:</label>
                <div class="col-lg-8">
                    <input name="quantity" value="${item.quantity}" class="form-control" type="text" value="">
                </div>
            </div>
            <div class="form-group">
                <label class="col-lg-3 control-label">Ghi chú:</label>
                <div class="col-lg-8">
                    <textarea name="description"  class="form-control" >${item.description}</textarea>
                </div>
            </div>
            <div class="form-group mt-5">
                <button formaction="/admin/product/${uri}" type="submit" style="background-color:#3f0097; border: none;" class="btn btn-primary mr-1">Save change</button>
                <button formaction="/admin/product/cancel" style="background-color:#3f0097; border:none;" class="btn btn-primary">Cancel</button>
            </div>
            <h1>${ad}</h1>
        </div>
    </div>
</form>
