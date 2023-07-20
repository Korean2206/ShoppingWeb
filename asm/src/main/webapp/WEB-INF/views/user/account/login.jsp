<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>

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
    <main class="app_container-mt register_header">
      <div class="row text-center">
          <h2>TÀI KHOẢN</h2>
      </div>
      <div class="register_form">
          <form action="/user/login" method="post">
              <div class="form-floating mb-3">
                  <input name="username" value="" type="text" class="form-control" id="floatingInput" placeholder="Username">
                  <label for="floatingInput">Username</label>
                </div>
                <div class="form-floating">
                  <input name="password" value="" type="password" class="form-control" id="floatingPassword" placeholder="Password">
                  <label for="floatingPassword">Password</label>
              </div>
            
              <!-- 2 column grid layout for inline styling -->
              <div class="row mb-4 mt-4">
                <div class="col d-flex justify-content-center">
                  <!-- Checkbox -->
                  <div class="form-check">
                    <input name="remember" class="form-check-input" type="checkbox" value="true" id="form2Example31"  />
                    <label class="form-check-label" for="form2Example31"> Nhớ mật khẩu </label>
                  </div>
                </div>
            
                <div class="col">
                  <!-- Simple link -->
                  <a href="#">Quên mật khẩu?</a>
                </div>
              </div>
            
              <!-- Submit button -->
              <button formaction="/user/login" type="submit" class="btn btn-dark btn-block mb-4 text-center" style="width: 100%;">Đăng nhập</button>
            
              <!-- Register buttons -->
              <div class="text-center">
                <p>Bạn chưa có tài khoản? <a href="/user/register">Đăng ký tại đây</a></p>
              </div>
            </form>
      </div>
</main>
    <jsp:include page="../footer.jsp"></jsp:include>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    
</body>
</html>