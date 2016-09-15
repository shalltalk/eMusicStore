<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: zhy
  Date: 2016/9/8
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/WEB-INF/views/template/header.jsp" %>

<div class="container-wrapper">
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Invalid Cart!</h1>
                </div>
            </div>
        </section>
        <section class="container">
            <p>
                <a href="<spring:url value="/product/productList"/>" class="btn btn-default">products</a>
            </p>
        </section>
    </div>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp" %>