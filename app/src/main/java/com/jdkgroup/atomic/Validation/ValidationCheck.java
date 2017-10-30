package com.jdkgroup.atomic.Validation;

/**
 * Created by lakhani on 10/24/2017.
 */

public class ValidationCheck {
    private int validationType;

    public ValidationCheck() {
    }

    public ValidationCheck validationType(int validationType) {
        this.validationType = validationType;
        return this;
    }

    public <T> ValidationTypes<T> as(Class<T> t) {
        ValidationTypes<T> c = new ValidationTypes<T>(this, validationType, t);
        return c;
    }

}
