package com.jdkgroup.atomic.CountryCodeNew;

import java.util.List;

public interface FutureCallback<T> {
    void onCompleted(List<T> result);
}
