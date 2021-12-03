package com.projet_API.tp5.model;


public class AddressApi {
    private double latitude;
    private double longitude;

    public AddressApi(){}
    public AddressApi(double latitude, double longitude){
        setLatitude(latitude);
        setLongitude(longitude);
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Coordonnées{" +
                "lat='" + latitude + '\'' +
                ", long=" + longitude +
                '}';
    }
}
