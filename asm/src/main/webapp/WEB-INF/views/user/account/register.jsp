<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/foruser/css/style.css"/> 
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Document</title>
</head>
<body>
    <jsp:include page="../header.jsp"></jsp:include>
    <main class="app_container-mt register mb-5">
            <div class="row text-center mb-5">
                <h2>ĐĂNG KÝ</h2>
            </div>
            <form:form class="register-form" action="/user/register" modelAttribute="user">
                <div class="row">
                    <div class="col">
                        <div class="mb-3">
                            <label for="exampleInputEmail1" class="form-label">Username</label>
                            <form:input path="username"  type="text" class="form-control"/>
                        </div>
                    </div>
                    <div class="col">
                        <div class="mb-3">
                            <label for="exampleInputPassword1" class="form-label">Mật khẩu</label>
                            <form:input path="password"  type="password" class="form-control" id="exampleInputPassword1"/>
                          </div>
                    </div>
                    
                    
                </div>
                <div class="row">
                    <div class="col">
                        <div class="mb-3">
                            <label for="fullname" class="form-label">Họ Tên</label>
                            <form:input path="fullname"  type="text" class="form-control" id="fullname"  aria-describedby="emailHelp"/>
                          </div>
                    </div>
                    
                    <div class="col">
                        <div class="mb-3">
                            <label class="form-label">Số điện thoại</label>
                            <form:input path="mobile"  type="text" class="form-control"/>
                        </div>
                    </div>
                    
                </div>
                <div class="row">
                    <div class="col">
                        <div class="mb-3">
                            <label for="exampleInputEmail1" class="form-label">Email address</label>
                            <form:input path="email"  type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"/>
                          </div>
                    </div>
                    
                    
                </div>
                <button formaction="/user/register" class="btn btn-primary mt-4">Đăng ký</button>
              </form:form>
    </main>
    <jsp:include page="../footer.jsp"></jsp:include>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>