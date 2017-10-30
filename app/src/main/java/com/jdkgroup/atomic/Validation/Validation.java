package com.jdkgroup.atomic.Validation;

/**
 * Created by lakhani on 10/24/2017.
 */

public class Validation {
    public static int EMAIL = 1;
    public static int PASSWORD = 2;
    public static int EMAIL_PASSWORD = 3;

    public static ValidationCheck with() {
        ValidationCheck validationCheck = new ValidationCheck();
        return validationCheck;
    }
}
