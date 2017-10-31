package com.jdkgroup.atomic.CountryCode;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by lakhani on 10/24/2017.
 */

public class CountryCodeCheck {
    public int countryCodeTypeType;
    public Gson gson;

    public CountryCodeCheck() {
        GsonBuilder builder = new GsonBuilder();
        gson = builder.create();
    }

    public CountryCodeCheck countryCodeTypeType(int countryCodeTypeType) {
        this.countryCodeTypeType = countryCodeTypeType;
        return this;
    }

    public <T> CountryCodeType<T> as() {
        CountryCodeType<T> c = new CountryCodeType<T>(this);
        return c;
    }
}
