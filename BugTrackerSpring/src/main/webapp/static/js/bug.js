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