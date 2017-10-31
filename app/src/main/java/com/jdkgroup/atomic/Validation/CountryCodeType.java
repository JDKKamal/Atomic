package com.jdkgroup.atomic.Validation;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 * Created by lakhani on 10/24/2017.
 */

public class CountryCodeType<T> {
    private final CountryCodeCheck validationCheck;
    private int validationType;

    private String result;

    public CountryCodeType(CountryCodeCheck validationCheck, int validationType) {
        this.validationCheck = validationCheck;
        this.validationType = validationType;
    }

    public void setCallback(final CountryCodeCallback callback) {
        if (validationType == CountryCode.COUNTRY) {
            result = validationCheck.gson.toJson(listAll(""));
        } else if (validationType == CountryCode.COUNTRY_CODE) {
            result = "COUNTRY CODE";
        }
        callback.onCompleted(result);
    }

    private ModelCountry getCountry(String countryCode) {
        Locale locale = new Locale("", countryCode);

        return new ModelCountry(countryCode,
                locale.getDisplayName(),
                "flag_" + countryCode.toLowerCase());
    }

    private List<ModelCountry> listAll(final String filter) {
        ArrayList<ModelCountry> list = new ArrayList<>();

        for (String countryCode : Locale.getISOCountries()) {
            ModelCountry country = getCountry(countryCode);

            list.add(country);
        }

        sortList(list);

        if (filter != null && filter.length() > 0) {
            return new ArrayList<>(Collections2.filter(list, new Predicate<ModelCountry>() {
                @Override
                public boolean apply(ModelCountry input) {
                    return input.getName().toLowerCase().contains(filter.toLowerCase());
                }
            }));
        } else {
            return list;
        }
    }

    private void sortList(List<ModelCountry> list) {
        Collections.sort(list, (ccItem, ccItem2) -> removeAccents(ccItem.getName()).toLowerCase().compareTo(removeAccents(ccItem2.getName()).toLowerCase()));
    }

    public String removeAccents(String str) {
        return Normalizer.normalize(str, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }
}
