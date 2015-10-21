$(document).ready(function () {

    //TODO set today day
    $(function () {
        $(".datepicker").datepicker({
            defaultDate: new Date()
    });
});

$("#log_out").click(function () {
    //TODO spring security log out
    location.replace("/index");
});

$("#new_project").click(function () {
    location.replace("/add/project");
});

$("#list_of_project").click(function () {
    //TODO redirect project page
    location.replace("/project");
});

})
;