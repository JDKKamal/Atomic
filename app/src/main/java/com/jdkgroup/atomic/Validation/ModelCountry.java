package com.jdkgroup.atomic.Validation;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Locale;

public class ModelCountry implements Parcelable {

    public String code, name, flagId;

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

    private Locale locale;

    public Locale getLocale() {
        if (locale == null) {
            return new Locale("", code);
        }
        return locale;
    }

    public ModelCountry(String code, String name, String flagId) {
        this.code = code;
        this.name = name;
        this.flagId = flagId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.code);
        dest.writeString(this.name);
        dest.writeValue(this.flagId);
        dest.writeSerializable(this.locale);
    }

    private ModelCountry(Parcel in) {
        this.code = in.readString();
        this.name = in.readString();
        this.flagId =  in.readString();
        this.locale = (Locale) in.readSerializable();
    }

    public static final Creator<ModelCountry> CREATOR = new Creator<ModelCountry>() {
        @Override
        public ModelCountry createFromParcel(Parcel source) {
            return new ModelCountry(source);
        }

        @Override
        public ModelCountry[] newArray(int size) {
            return new ModelCountry[size];
        }
    };
}
