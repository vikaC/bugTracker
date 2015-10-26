package com.bug.validation;

import java.time.LocalDate;

/**
 * Created by vita on 10/26/15.
 */
public interface ProjectValidation {

    boolean isValidDates(LocalDate start, LocalDate end);

    boolean isNameValid(String name);
}
