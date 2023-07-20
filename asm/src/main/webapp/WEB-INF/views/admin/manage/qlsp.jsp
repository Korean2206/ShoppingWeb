<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>


<table class="table table-hover">
    <h1 class="text-center mb-5" style="color:#3f0097;">Danh sách Sản phẩm</h1>
    <thead>
      <tr>
        <th scope="col">Mã SP</th>
        <th scope="col">Tên Sản phẩm</th>
        <th scope="col">Dành cho</th>
        <th scope="col">Loại SP</th>
        <th scope="col">Đơn giá</th>
        <th scope="col">Mô tả</th>
        <th scope="col">Hình SP</th>
        <th scope="col">Available</th>
        <th scope="col">Action</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="item" items="${items}">
      <tr>
        <td>${item.id}</td>
        <td>${item.name}</td>
        <td>${item.category.gender == 'true' ? 'nam' : 'nữ'} </td>
        <td>${item.category.name}</td>
        <td>${item.price}</td>
        <td>${item.description}</td>
        <td><img src="/product/${item.image}" style="max-width: 100px;" class="card-img-top" alt="...">
        </td>
        <td>${item.available}</td>

        <td>
            <a href="/admin/product/update?id=${item.id}" class="btn btn-warning">Sửa</a>
            <a href="/admin/product/delete?id=${item.id}" class="btn btn-danger">Xóa</a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>