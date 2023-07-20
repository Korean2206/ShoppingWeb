<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>


<table class="table table-hover">
    <h1 class="text-center mb-5" style="color:#3f0097;">Danh sách Đơn hàng</h1>
    <thead>
      <tr>
        <th scope="col">Mã Đon</th>
        <th scope="col">Mã KH</th>
        <th scope="col">Ngày bán</th>
        <th scope="col">Action</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="item" items="${items}">
        <tr>
          <td>${item.id}</td>
          <td>${item.user.username}</td>
          <td>${item.createdate}</td>
          <td>
            <a href="/admin/order/delete?id=${item.id}" class="btn btn-danger">Xóa</a>
            <a href="/admin/order/order_detail?id=${item.id}" class="btn btn-light">Xen chi tiết</a>
          </td>
        </tr>
      </c:forEach>

    </tbody>
  </table>