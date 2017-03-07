<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>

<!-- Carousel
================================================== -->
<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <img class="first-slide home-image" src="<c:url value="/resources/images/back1.jpg" />" alt="First slide">
            <div class="container">
                <div class="carousel-caption">
                    <h1>Welcome to XXXX XXXX XXXX, Inc.</h1>
                    <p>XXXX XXXX XXXX is a Maintenance, Repair, and Operations (MRO) company focused on
                        industrial products sales, maintenance and spare parts operation. </p>
                </div>
            </div>
        </div>
        <div class="item">
            <img class="second-slide home-image" src="<c:url value="/resources/images/back2.jpg" />" alt="Second slide">
            <div class="container">
                <div class="carousel-caption">
                    <h1>Our Services</h1>
                    <p>Technical service: Customized technicalt solution.</p>
                    <p>Product service: New/Customized product consultation, quotation, sales.</p>
                    <p>Maintenance service: Equipment maintenance, chip-level-maintenance, servo motor repair.</p>
                </div>
            </div>
        </div>
        <div class="item">
            <img class="third-slide home-image" src="<c:url value="/resources/images/back3.jpg" />" alt="Third slide">
            <div class="container">
                <div class="carousel-caption">
                    <h1>Our Services</h1>
                    <p>Precision Computer Numeric Control (CNC) equipment maintenance: Annual maintenance, precision
                        testing equipment management.</p>
                    <p>Commission sale service: Find customers for manufacturers' existing production.</p>
                    <p>Financial service: Domestic and overseas purchasing and payment.</p>
                </div>
            </div>
        </div>
    </div>
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>
<!-- /.carousel -->


<!-- Marketing messaging and featurettes
================================================== -->
<!-- Wrap the rest of the page in another container to center all the content. -->

<div class="container marketing">

    <!-- Three columns of text below the carousel -->
    <div class="row">
        <div class="col-lg-4">
            <a class="btn btn-default" href="<c:url value="/product/productList?searchCondition=Electronic" />"
               role="button">
                <img class="img-rounded" src="<c:url value="/resources/images/instrument.jpg"/>" alt="Electronic Image"
                     width="140" height="140"></a>
            <h2>Electronic</h2>
            <p>This is the category for Industrial Electronic. </p>
        </div><!-- /.col-lg-4 -->

    <div class="row">
        <div class="col-lg-4">
            <a class="btn btn-default" href="<c:url value="/product/productList?searchCondition=Hydraulic" />"
               role="button">
                <img class="img-rounded" src="<c:url value="/resources/images/hydraulic.jpg"/>" alt="Hydraulic Image"
                     width="140" height="140"></a>
            <h2>Hydraulic</h2>
            <p>This is the category for Industrial Hydraulic. </p>
        </div><!-- /.col-lg-4 -->

    <div class="row">
        <div class="col-lg-4">
            <a class="btn btn-default" href="<c:url value="/product/productList?searchCondition=Motor" />"
               role="button">
                <img class="img-rounded" src="<c:url value="/resources/images/motor.jpg"/>" alt="Motor Image"
                     width="140" height="140"></a>
            <h2>Motor</h2>
            <p>This is the category for Industrial Motor. </p>
        </div><!-- /.col-lg-4 -->

    </div><!-- /.row -->

<%@include file="/WEB-INF/views/template/footer.jsp" %>
