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



    $("#bugs_list").click(function () {
        location.replace("/bugs");
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