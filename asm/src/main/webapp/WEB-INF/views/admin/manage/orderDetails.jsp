<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>


<table class="table table-hover">
    <h1 class="text-center mb-5" style="color:#3f0097;">Danh sách Đơn hàng</h1>
    <thead>
      <tr>
        <th scope="col">ID</th>
        <th scope="col">Order ID</th>
        <th scope="col">Product name</th>
        <th scope="col">Quantity</th>
        <th scope="col">Price</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="item" items="${items}">
        <tr>
          <td>${item.id}</td>
          <td>${item.order.id}</td>
          <td>${item.product.name}</td>
          <td>${item.quantity}</td>
          <td>${item.price}</td>
        </tr>
      </c:forEach>

    </tbody>
  </table>