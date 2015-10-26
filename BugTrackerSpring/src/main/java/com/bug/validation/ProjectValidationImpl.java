package com.bug.validation;

import java.time.LocalDate;

/**
 * Created by vita on 10/26/15.
 */
public class ProjectValidationImpl implements ProjectValidation {

    @Override
    public boolean isValidDates(LocalDate start, LocalDate end) {
        if (start.getYear() > end.getYear())
            return false;
        if (start.getMonthValue() > end.getMonthValue())
            return false;
        if (start.getDayOfMonth() > end.getDayOfMonth())
            return false;
        return true;
    }

    @Override
    public boolean isNameValid(String name) {
        return name.length() > 4;
    }
}
