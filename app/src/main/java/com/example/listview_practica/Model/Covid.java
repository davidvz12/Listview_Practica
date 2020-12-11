package com.example.listview_practica.Model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Covid {

    String Country;
    String CountryCode;
    Integer NewConfirmed;
    Integer TotalConfirmed;

    public Integer getNewConfirmed() {
        return NewConfirmed;
    }

    public void setNewConfirmed(Integer newConfirmed) {
        NewConfirmed = newConfirmed;
    }

    public Integer getTotalConfirmed() {
        return TotalConfirmed;
    }

    public void setTotalConfirmed(Integer totalConfirmed) {
        TotalConfirmed = totalConfirmed;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }



    public Covid(JSONObject a) throws JSONException {
        Country = a.getString("Country").toString();
        CountryCode = a.getString("CountryCode").toString();
        NewConfirmed = a.getInt("NewConfirmed");
        TotalConfirmed = a.getInt("TotalConfirmed");
    }

    public static ArrayList<Covid> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Covid> covid = new ArrayList<>();

        for (int i = 0; i < datos.length() && i<20; i++) {
            covid.add(new Covid(datos.getJSONObject(i)));
        }
        return covid;
    }
}
