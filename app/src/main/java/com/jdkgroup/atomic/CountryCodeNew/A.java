package com.jdkgroup.atomic.CountryCodeNew;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class A {
    private static final String TAG = A.class.getSimpleName();

    public Gson gson;
    public int type;

    public A() {
        GsonBuilder builder = new GsonBuilder();
        gson = builder.create();
    }

    public A type(int type) {
        this.type = type;
        return this;
    }

    public <T> C<T> as(Class<T> t) {
        C<T> c = new C<T>(this, t);
        return c;
    }
}

