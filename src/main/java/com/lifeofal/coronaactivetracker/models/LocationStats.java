package com.lifeofal.coronaactivetracker.models;

public class LocationStats {

    private String state;
    private String country;
    private String county;
    private int latestConfirmedCases;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public int getLatestConfirmedCases() {
        return latestConfirmedCases;
    }

    public void setLatestConfirmedCases(int latestConfirmedCases) {
        this.latestConfirmedCases = latestConfirmedCases;
    }

    @Override
    public String toString() {
        return "LocationStats{" +
                "state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", county='" + county + '\'' +
                ", latestConfirmedCases=" + latestConfirmedCases +
                '}';
    }
}
