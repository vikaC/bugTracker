$(document).ready(function () {

    $("#log_in").click(function () {
        var login = $("#user_login").val();
        var password = $("#user_password").val();
        var url = "index/log?";
        if ($.fn.isNotEmpty(login) & $.fn.isNotEmpty(password)) {
            var parameterName = {
                "login": login,
                "password": password
            };
            var mapping = $.fn.getUrl(parameterName, url);
            $.get(mapping)
                .done(function (data) {
                    alert("Success");
                })
                .fail(function (data) {
                    $.fn.signInError("Login or password don't match!");
                });
        } else {
            $.fn.signInError("Parameters cannot be empty!");
        }
    });

    $(window).load(function () {
        $.fn.hideMessage();
    });

    $("#sign_in").click(function () {
        var name = $("#new_name").val();
        var surname = $("#new_surname").val();
        var login = $("#new_login").val();
        var password = $("#new_password").val();
        var confirmedPassword = $("#confirm_password").val();
        var position = $("#new_position").val();
        var url = "index/registration?";
        if ($.fn.noEmptyParams(name, surname, login, password, confirmedPassword)) {
            if ($.fn.isPasswordMatch(password, confirmedPassword)) {
                var parameterName = {
                    "login": login,
                    "password": password,
                    "confirmedPassword": confirmedPassword,
                    "name": name,
                    "surname": surname,
                    "position": position
                };
                var mapping = $.fn.getUrl(parameterName, url);
                $.get(mapping)
                    .done(function (data) {
                        alert("Success");
                    })
                    .fail(function (data) {
                        $.fn.registrationError("Current login used by another user");
                    });
            } else {
                $.fn.registrationError("Passwords don't match!");
            }
        } else {
            $.fn.registrationError("Parameters cannot be empty!");
        }

    });

    $.fn.isNotEmpty = function (param) {
        if (param.length > 0)
            return true;
        return false;
    }

    $.fn.noEmptyParams = function (name, surname, login, password, confirmedPassword) {
        if ($.fn.isNotEmpty(name) & $.fn.isNotEmpty(surname) & $.fn.isNotEmpty(login) & $.fn.isNotEmpty(password) & $.fn.isNotEmpty(confirmedPassword))
            return true;
        return false;
    }

    $.fn.isPasswordMatch = function (password, confirmedPass) {
        return password === confirmedPass;
    }

    $.fn.getUrl = function (parameterName, url) {
        var recursiveDecoded = decodeURIComponent($.param(parameterName));
        return url + recursiveDecoded;
    }

    $.fn.hideMessage = function () {
        $("#error_during_sign_in").hide("slow");
        $("#error_during_log_in").hide("slow");
    }

    $.fn.registrationError = function (message) {
        $("#error_during_sign_in").show("slow");
        $("#error_during_sign_in").text(message);
    }

    $.fn.signInError = function (message) {
        $("#error_during_log_in").show("slow");
        $("#error_during_log_in").text(message);
    }

    $("#user_login").focus(function () {
        $.fn.hideMessage();
    });
    $("#user_password").focus(function () {
        $.fn.hideMessage();
    });
    $("#new_name").focus(function () {
        $.fn.hideMessage();
    });
    $("#new_surname").focus(function () {
        $.fn.hideMessage();
    });
    $("#new_login").focus(function () {
        $.fn.hideMessage();
    });
    $("#new_password").focus(function () {
        $.fn.hideMessage();
    });
    $("#confirm_password").focus(function () {
        $.fn.hideMessage();
    });
    $("#new_position").focus(function () {
        $.fn.hideMessage();
    });


});
