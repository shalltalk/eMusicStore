<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>

<script>
    // when the html page finishes loading, do the stuff in the function.
    $(document).ready(function () {
        // selector, with table class
        $('.table').DataTable({
            // display how many entries in the menu drop down list
            "lengthMenu": [[1, 2, 3, 5, 10, -1], [1, 2, 3, 5, 10, "All"]]
        });
    });
</script>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Products Inventory Page</h1>
            <p class="lead">This is the product inventory page for admin.</p>
        </div>

        <table class="table table-stripped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Photo Thumb</th>
                <th>Product Name</th>
                <th>Category</th>
                <th>Condition</th>
                <th>Price</th>
                <th>Action</th>
            </tr>
            </thead>
            <c:forEach items="${products}" var="product">
                <tr>
                    <td><img src="<c:url value="/resources/images/${product.productID}.png" /> " alt="image"
                             style="width:100%"/></td>
                    <td>${product.productName}</td>
                    <td>${product.productCategory}</td>
                    <td>${product.productCondition}</td>
                    <td>${product.productPrice} USD</td>
                    <td><a href="<spring:url value="/product/viewProduct/${product.productID}" />"
                    ><span class="glyphicon glyphicon-info-sign"></span></a>
                        <a href="<spring:url value="/admin/product/deleteProduct/${product.productID}" />"
                        ><span class="glyphicon glyphicon-remove"></span></a>
                        <a href="<spring:url value="/admin/product/editProduct/${product.productID}" />"
                        ><span class="glyphicon glyphicon-pencil"></span></a>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <a href="<spring:url value="/admin/product/addProduct" />" class="btn btn-primary">Add Product</a>
        <%@include file="/WEB-INF/views/template/footer.jsp" %>
