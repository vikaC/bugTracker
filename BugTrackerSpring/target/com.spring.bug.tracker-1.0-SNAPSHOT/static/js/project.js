$(document).ready(function () {

    $(function () {
        $(".datepicker").datepicker({
            minDate: '0'
        }).datepicker('setDate', new Date());
    });

    $("#log_out").click(function () {
        //TODO spring security log out
        location.replace("/index");
    });



    $("#list_of_project").click(function () {
        location.replace("/project");
    });


    $("#add_button").click(function () {
        var name = $("#project_name").val();
        if ($.fn.isNotEmpty(name)) {
            var startDate = $("#project_start_date").val();
            var endDate = $("#project_due_date").val();
            var url = "/project/add/new?";
            var parameterName = {
                name: name,
                start: startDate,
                end: endDate
            };
            console.log("startdate " + startDate + " endDate " + endDate);
            var mapping = $.fn.getUrl(parameterName, url);
            $.get(mapping)
                .done(function (data) {
                    location.replace("/project");
                })
                .fail(function (data) {
                    $.fn.showMessage("New project wasn't added!");
                });
        } else {
            $.fn.showMessage("Project name cannot be empty!")
        }
    });

    $("#project_name").focus(function () {
        $.fn.hideMessage("slow");
    });

    $.fn.hideMessage = function (speed) {
        $("#error_during_add_in").hide(speed);
    }

    $.fn.isNotEmpty = function (param) {
        if (param.length > 0)
            return true;
        return false;
    }

    $(window).load(function () {
        $.fn.hideMessage("high");
    });

    $.fn.showMessage = function (message) {
        $("#error_during_add_in").show("slow");
        $("#error_during_add_in").text(message);
    }

    $.fn.getUrl = function (parameterName, url) {
        var recursiveDecoded = decodeURIComponent($.param(parameterName));
        return url + recursiveDecoded;
    }
});