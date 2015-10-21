<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <title>Bug tracking system</title>

    <spring:url value="/static/css/business-casual.css" var="coreCss"/>
    <spring:url value="/static/css/bootstrap.min.css" var="bootstrapCss"/>
    <spring:url value="/static/css/jquery-ui.css" var="jqueryUI"/>
    <link href="${bootstrapCss}" rel="stylesheet"/>
    <link href="${coreCss}" rel="stylesheet"/>
    <link href="${jqueryUI}" rel="stylesheet"/>
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
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li>
                    <a id="log_out">Log out</a>
                </li>
                <li>
                    <a id="list_of_project">List of projects</a>
                </li>
            </ul>
        </div>
    </div>
    <!-- /.container -->
</nav>

<div class="container">

    <div class="row">
        <div class="box">
            <div class="col-lg-12 text-center">
                <h1 class="brand-name">Add</h1>
                <hr class="tagline-divider">
                <h2>
                    <small>new
                        <strong>project</strong>
                    </small>
                </h2>
                <label for="project_name">Login:</label>
                <input type="text" class="form-control" id="project_name">
                <label for="project_start_date">Start date:</label>
                <input type="text" class="form-control datepicker" id="project_start_date">
                <label for="project_due_date">Due date:</label>
                <input type="text" class="form-control datepicker" id="project_due_date">

            </div>
        </div>
    </div>
</div>
<spring:url value="/static/js/jquery-2.1.4.js" var="jquery"/>
<spring:url value="/static/js/project.js" var="coreJs"/>
<spring:url value="/static/js/bootstrap.min.js" var="bootstrapJsMin"/>
<spring:url value="/static/js/bootstrap.js" var="bootstrapJs"/>
<spring:url value="/static/js/jquery-ui.js" var="jqueryUIJs"/>

<script src="${jquery}"></script>
<script src="${jqueryUIJs}"></script>
<script src="${coreJs}"></script>
<script src="${bootstrapJsMin}"></script>
<script src="${bootstrapJs}"></script>
<!-- Script to Activate the Carousel -->
<script>
    $('.carousel').carousel({
        interval: 5000 //changes the speed
    })
</script>


</body>
</html>