package com.bug.validation;


public interface EmployeeValidation {

    boolean isEmpty(String entity);

    boolean isPasswordsMatch(String password, String confirmedPassword);

    boolean isPasswordPatternMatch(String password);

    boolean isLoginPatternMatch(String login);

    boolean validate(String login, String password, String confirmedPassword, String name, String surname);

    boolean validate(String login,String password);
}
