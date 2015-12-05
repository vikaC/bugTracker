<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <title>Bug tracking system</title>

    <spring:url value="/static/css/business-casual.css" var="coreCss"/>
    <spring:url value="/static/css/bootstrap.min.css" var="bootstrapCss"/>
    <spring:url value="/static/css/jquery-ui.css" var="jqueryUI"/>
    <link href="${bootstrapCss}" rel="stylesheet"/>
    <link href="${jqueryUI}" rel="stylesheet"/>
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
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li>
                    <a id="log_out">Log out</a>
                </li>
                <li>
                    <a data-toggle="modal" data-target="#add_new_bug">Add new bug</a>
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
                <h1 class="brand-name">List</h1>
                <hr class="tagline-divider">
                <h2>
                    <small>of
                        <strong>bugs</strong>
                    </small>
                </h2>
                <div>
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>Name</th>
                            <th>Description</th>
                            <th>Creation date</th>
                            <th>Due date</th>
                        </tr>
                        </thead>
                        <c:forEach items="${bugs}" var="bug">
                        <tbody>
                        <tr>
                            <td>${bug.name}</td>
                            <td>${bug.description}</td>
                            <td>${bug.creationDate}</td>
                            <td>${bug.dueDate}</td>
                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<spring:url value="/static/js/jquery-2.1.4.js" var="jquery"/>
<spring:url value="/static/js/bug.js" var="coreJs"/>
<spring:url value="/static/js/bootstrap.min.js" var="bootstrapJsMin"/>
<spring:url value="/static/js/bootstrap.js" var="bootstrapJs"/>
<spring:url value="/static/js/jquery-ui.js" var="jqueryUIJs"/>

<script src="${jqueryUIJs}"></script>
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

<div id="add_new_bug" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Add new bug</h4>
            </div>
            <div class="alert alert-danger" id="error_during_add_in" role="alert">
            </div>
            <div class="modal-body">
                <label for="bug_name">Name:</label>
                <input type="text" class="form-control" id="bug_name">
                <label for="description">Description:</label>
                <textarea id="description" class="form-control"></textarea>
                <label for="bug_due_date">Due date:</label>
                <input type="text" class="form-control datepicker" id="bug_due_date">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" id="add_button">Add</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>

    </div>
</div>

</body>
</html>