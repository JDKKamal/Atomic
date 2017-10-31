package com.jdkgroup.atomic.Validation;

/**
 * Created by lakhani on 10/24/2017.
 */

public class CountryCode {
    public static int COUNTRY = 1;
    public static int COUNTRY_CODE = 2;

    public static CountryCodeCheck with() {
        CountryCodeCheck countryCodeCheck = new CountryCodeCheck();
        return countryCodeCheck;
    }
}
