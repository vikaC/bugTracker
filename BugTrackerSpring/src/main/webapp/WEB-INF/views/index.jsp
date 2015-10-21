<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <title>Bug tracking system</title>

    <spring:url value="/static/css/business-casual.css" var="coreCss"/>
    <spring:url value="/static/css/bootstrap.min.css" var="bootstrapCss"/>
    <link href="${bootstrapCss}" rel="stylesheet"/>
    <link href="${coreCss}" rel="stylesheet"/>
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800"
          rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic"
          rel="stylesheet" type="text/css">
</head>
<body>
<div class="brand">Bug tarcker</div>
<div class="address-bar"> | Kolylova Victoria |</div>
<nav class="navbar navbar-default" role="navigation">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <!-- navbar-brand is hidden on larger screens, but visible when the menu is collapsed -->
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li>
                    <a data-toggle="modal" data-target="#log_in_popup">Log in</a>
                </li>
                <li>
                    <a data-toggle="modal" data-target="#sign_in_popup">Sign in</a>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>

<div class="container">

    <div class="row">
        <div class="box">
            <div class="col-lg-12 text-center">
                <div id="carousel-example-generic" class="carousel slide">
                    <!-- Indicators -->
                    <ol class="carousel-indicators hidden-xs">
                        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                        <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                    </ol>
                    <spring:url value="/static/img/slide-1.jpg" var="img1"/>
                    <spring:url value="/static/img/slide-2.jpg" var="img2"/>
                    <spring:url value="/static/img/slide-3.jpg" var="img3"/>
                    <div class="carousel-inner">
                        <div class="item active">
                            <img class="img-responsive img-full" src="${img1}">
                        </div>
                        <div class="item">
                            <img class="img-responsive img-full" src="${img2}">
                        </div>
                        <div class="item">
                            <img class="img-responsive img-full" src="${img3}">
                        </div>
                    </div>
                    <!-- Controls -->
                    <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                        <span class="icon-prev"></span>
                    </a>
                    <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                        <span class="icon-next"></span>
                    </a>
                </div>
                <h2 class="brand-before">
                    <small>Welcome to</small>
                </h2>
                <h1 class="brand-name">Bug</h1>
                <hr class="tagline-divider">
                <h2>
                    <small>tracking
                        <strong>system</strong>
                    </small>
                </h2>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="box">
            <div class="col-lg-12">
                <hr class="visible-xs">
                <p>A bug tracking system or defect tracking system is a software application that keeps track of
                    reported software bugs in software development projects. It may be regarded as a type of
                    issue tracking system.</p>

                <p>Many bug tracking systems, such as those used by most open source software projects, allow
                    end-users to enter bug reports directly. Other systems are used only internally in a
                    company or organization doing software development. Typically bug tracking systems are
                    integrated with other software project management applications.</p>

                <p>A bug tracking system is usually a necessary component of a good software development
                    infrastructure, and consistent use of a bug or issue tracking system is considered one of
                    the "hallmarks of a good software team"</p>
            </div>
        </div>
    </div>

</div>


<spring:url value="/static/js/jquery-2.1.4.js" var="jquery"/>
<spring:url value="/static/js/registration.js" var="coreJs"/>
<spring:url value="/static/js/bootstrap.min.js" var="bootstrapJsMin"/>
<spring:url value="/static/js/bootstrap.js" var="bootstrapJs"/>

<script src="${jquery}"></script>
<script src="${coreJs}"></script>
<script src="${bootstrapJsMin}"></script>
<script src="${bootstrapJs}"></script>
<!-- Script to Activate the Carousel -->
<script>
    $('.carousel').carousel({
        interval: 5000 //changes the speed
    })
</script>

<div id="sign_in_popup" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Sign in</h4>
            </div>
            <div class="modal-body">
                <div class="alert alert-danger" id="error_during_sign_in" role="alert">
                </div>
                <div class="form-group">
                    <label for="new_login">Login:</label>
                    <input type="email" class="form-control" id="new_login">
                </div>
                <div class="form-group">
                    <label for="new_password">Password:</label>
                    <input type="password" class="form-control" id="new_password">
                    <label for="confirm_password">Confirm password:</label>
                    <input type="password" class="form-control" id="confirm_password">
                </div>
                <div class="form-group">
                    <label for="new_name">Name:</label>
                    <input type="text" class="form-control" id="new_name">
                    <label for="new_surname">Surname:</label>
                    <input type="text" class="form-control" id="new_surname">
                </div>
                <div class="form-group">
                    <label for="new_position">Position:</label>
                    <select class="form-control" id="new_position">
                        <option>Developer</option>
                        <option>QA</option>
                    </select>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" id="sign_in">Sign in</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>

    </div>
</div>

<div id="log_in_popup" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Log in</h4>
            </div>
            <div class="alert alert-danger" id="error_during_log_in" role="alert">
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <label for="user_login">Login:</label>
                    <input type="text" class="form-control" id="user_login">
                </div>
                <div class="form-group">
                    <label for="user_password">Password:</label>
                    <input type="password" class="form-control" id="user_password">
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" id="log_in">Log in</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>

    </div>
</div>

</body>
</html>