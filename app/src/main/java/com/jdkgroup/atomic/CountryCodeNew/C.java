package com.jdkgroup.atomic.CountryCodeNew;

import com.google.gson.reflect.TypeToken;
import com.jdkgroup.atomic.CountryCode.ModelCountry;

import java.lang.reflect.Type;
import java.util.List;

public class C<T> {
    private final A a;
    private final Class<?> aClass;
    private List<T> t = null;

    public C(A a, Class<T> aClass) {
        this.a = a;
        this.aClass = aClass;
    }

    public C(A a, Type t) {
        this.a = a;
        this.aClass = t.getClass();
    }

    public void setCallback(final FutureCallback<T> callback) {
        String str = "[{\"code\":\"IN\",\"flagId\":\"flag_in\",\"name\":\"India\"}]";
        parse(str);
        callback.onCompleted(t);
    }

    private List<T> parse(String response)   {
        t = a.gson.fromJson(response, new TypeToken<List<T>>(){}.getType());
        return t;
    }
}
