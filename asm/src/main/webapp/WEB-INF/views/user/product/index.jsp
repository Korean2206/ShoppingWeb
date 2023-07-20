<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
                <main class="app_container mt-200 mb-200 ">
                    <div class="row mt-5">
                        <div class="col-sm-3">
                            <c:if test="${view != 'search'}">
                                <ul class="list-group app_product_category">
                                    <li class="list-group-item">DANH MỤC</li>
                                    <li class="list-group-item"><a href="/product/${view}/ao-thun">ÁO THUN</a></li>
                                    <li class="list-group-item"><a href="/product/${view}/Ao-Khoac$Blazer">ÁO KHOÁC & ÁO
                                        BLAZER</a></li>
                                        <li class="list-group-item"><a href="/product/${view}/Quan">QUẦN</a></li>
                                        <li class="list-group-item"><a href="/product/${view}/Tui&vi">TÚI & VÍ</a></li>
                                        <li class="list-group-item"><a href="/product/${view}/giay">GIÀY</a></li>
                                        <li class="list-group-item"><a href="/product/${view}/Hoodies&Sweatshirt">HOODIES &
                                            SWEATSHIRT</a></li>
                                            <li class="list-group-item"><a href="/product/${view}/phu-kien">PHỤ KIỆN</a></li>
                                        </ul>
                            </c:if>
                        </div>
                        <div class="col-sm-9">
                            <form class="app_select" name="sort">
                                <P class="fw-bold d-inline me-1">Xếp theo:</P>
                                <div class="form-check form-check-inline">
                                    <input onChange="autoSubmit();" class="form-check-input" type="radio" name="sort"
                                        id="inlineRadio1" value="A" ${param.sort == 'A' ? 'checked="checked"' : '' } />
                                    <label class="form-check-label" for="inlineRadio1">TÊN A-Z</label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <input onChange="autoSubmit();" class="form-check-input" type="radio" name="sort"
                                        id="inlineRadio2" value="Z" ${param.sort == 'Z' ? 'checked="checked"' : '' } >
                                    <label class="form-check-label" for="inlineRadio2">TÊN Z-A</label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <input onChange="autoSubmit();" class="form-check-input" type="radio" name="sort"
                                        id="inlineRadio3" value="N" ${param.sort == 'N' ? 'checked="checked"' : '' }>
                                    <label class="form-check-label" for="inlineRadio3">HÀNG MỚI</label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <input onChange="autoSubmit();" class="form-check-input" type="radio" name="sort"
                                        id="inlineRadio4" value="T" ${param.sort == 'T' ? 'checked="checked"' : '' } >
                                    <label class="form-check-label" for="inlineRadio4">GIÁ TỪ THẤP ĐẾN CAO</label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <input onChange="autoSubmit();" class="form-check-input" type="radio" name="sort"
                                        id="inlineRadio5" value="C" ${param.sort == 'C' ? 'checked="checked"' : '' } >
                                    <label class="form-check-label" for="inlineRadio5">GIÁ TỪ CAO ĐẾN THẤP</label>
                                </div>
                            </form>
                            <div class="row">
                                <c:forEach var="item" items="${page.content}">
                                    <div class="col-sm-3 py-2">
                                        <div class="card">
                                            <img src="/product/${item.image}" class="card-img-top product_img"
                                                alt="...">
                                            <div class="card-body">
                                                <h6 class="card-title text-center">${item.name}
                                                </h6>
                                                <p class="card-text text-center">${item.price}</p>
                                                <a href="/cart/add/?id=${item.id}&index=product/${view}${view1}" class="btn btn-secondary ">Thêm vào giỏ hàng</a>
                                                <a href="#!productInfor" class="btn btn-dark mt-1 ">Mua ngay</a>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                            <div class="row mt-5">
                                <nav aria-label="Page navigation example ">
                                    <c:if test="${page.totalPages >1}">

                                        <ul class="pagination justify-content-center ">
                                            <c:if test="${page.number > 0}">
                                                <li class="page-item"><a
                                                        href="/product/${view}${view1}?p=${page.number-1}"
                                                        class="page-link text-dark">Previous</a></li>
                                            </c:if>
                                            <c:if test="${page.number <= 0}">
                                                <li class="page-item"><button style="min-width:90px"
                                                        class="btn btn-outline-secondary" disabled>Previous</button>
                                                </li>
                                            </c:if>
                                            <c:forEach var="item" items="${number}">
                                                <li class="page-item "><a href="/product/${view}${view1}?p=${item -1}"
                                                        class="page-link text-white bg-dark">${item}</a></li>
                                            </c:forEach>
                                            <c:if test="${page.number < (page.totalPages -1)}">
                                                <li class="page-item"><a href="/product/${view}${view1}?p=${page.number+1}"
                                                        class="page-link text-dark">Next</a></li>
                                            </c:if>
                                            <c:if test="${page.number >= (page.totalPages -1)}">
                                                <li class="page-item"><button style="min-width:90px"
                                                        class="btn btn-outline-secondary" disabled>Next</button></li>

                                            </c:if>
                                        </ul>
                                    </c:if>
                                </nav>
                            </div>
                        </div>
                    </div>
                </main>
                <jsp:include page="../footer.jsp"></jsp:include>

                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
                    integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
                    crossorigin="anonymous"></script>
                <script>
                    function autoSubmit(id) {
                        var formObject = document.forms['sort'];
                        formObject.submit();

                    }
                    
                </script>
            </body>

            </html>