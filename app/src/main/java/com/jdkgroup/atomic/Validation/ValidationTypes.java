package com.jdkgroup.atomic.Validation;

/**
 * Created by lakhani on 10/24/2017.
 */

public class ValidationTypes<T> {
    private final Class<?> aClass;
    private final ValidationCheck validationCheck;
    private T t = null;
    private int validationType;
    private String result = "";

    public ValidationTypes(ValidationCheck validationCheck, int validationType, Class<T> aClass) {
        this.validationCheck = validationCheck;
        this.validationType = validationType;
        this.aClass = aClass;
    }

    public void setCallback(final ValidationCallback callback) {
        if (validationType == Validation.EMAIL) {
            result = "Email";
        } else if (validationType == Validation.PASSWORD) {
            if (result.isEmpty()) {
                result = "PASSWORD";
            }
        }
        callback.onCompleted(result);
    }
}
