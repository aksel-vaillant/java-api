package com.projet_API.tp5.model;


public class AddressApi {
    private float latitude;
    private float longitude;

    public AddressApi(){}

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
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
