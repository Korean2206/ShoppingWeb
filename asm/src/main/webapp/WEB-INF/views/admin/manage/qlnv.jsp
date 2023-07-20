<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>


<table class="table table-hover">
    <h1 class="text-center mb-5" style="color:#3f0097;">Danh sách nhân viên</h1>
    <thead>
      <tr>
        <th scope="col">Mã NV</th>
        <th scope="col">Họ Tên</th>
        <th scope="col">Địa chỉ</th>
        <th scope="col">giới tính</th>
        <th scope="col">Email</th>
        <th scope="col">Phone</th>
        <th scope="col">Action</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="item" items="${items}">
        <tr>
          <td>${item.username}</td>
          <td>${item.fullname}</td>
          <td>${item.address}</td>
          <td>${item.gender == 'true' ? 'Nam':'Nữ'}</td>
          <td>${item.email}</td>
          <td>${item.mobile}</td>
          <td>
            <a href="/admin/account/employee/update?id=${item.username}" class="btn btn-warning">Sửa</a>
            <a href="/admin/account/employee/delete?id=${item.username}" class="btn btn-danger">Xóa</a>
          </td>
        </tr>
      </c:forEach>
     
      
    </tbody>
  </table>