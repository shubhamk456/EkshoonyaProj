package com.example.ekshoonaya;

public class CountryItem {

    private  String countrycode;
    private  int mFlagImage;

    public CountryItem(String countrycode, int mFlagImage) {
        this.countrycode = countrycode;
        this.mFlagImage = mFlagImage;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    public int getmFlagImage() {
        return mFlagImage;
    }

    public void setmFlagImage(int mFlagImage) {
        this.mFlagImage = mFlagImage;
    }
}
