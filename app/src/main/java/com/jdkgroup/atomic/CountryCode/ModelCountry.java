package com.jdkgroup.atomic.CountryCode;

public class ModelCountry  {

    public String code, name, flagId;

    public ModelCountry(String code, String name, String flagId) {
        this.code = code;
        this.name = name;
        this.flagId = flagId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlagId() {
        return flagId;
    }

    public void setFlagId(String flagId) {
        this.flagId = flagId;
    }
}
