package com.jdkgroup.atomic.Validation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jdkgroup.atom.C;

/**
 * Created by lakhani on 10/24/2017.
 */

public class CountryCodeCheck {
    private int countryCodeType;
    public Gson gson;

    public CountryCodeCheck() {
        GsonBuilder builder = new GsonBuilder();
        gson = builder.create();
    }

    public CountryCodeCheck countryCodeTypeType(int countryCodeType) {
        this.countryCodeType = countryCodeType;
        return this;
    }

    public <T> CountryCodeType<T> as() {
        CountryCodeType<T> c = new CountryCodeType<T>(this, countryCodeType);
        return c;
    }

}
