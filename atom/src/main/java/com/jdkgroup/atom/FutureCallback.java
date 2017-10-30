package com.jdkgroup.atom;

public interface FutureCallback<T> {
    public void onCompleted(Exception e, T result);
}
