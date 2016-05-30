package net.wearecode.whereismybus.models;

import java.util.Map;

public class Bus {
    private String name;
    private double latitude;
    private double longitude;
    private boolean active;
    private Object created;

    public Bus(){}


    public Bus(String name, double latitude, double longitude, boolean active, Object created) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.active = active;
        this.created = created;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Object getCreated() {
        return created;
    }

    public void setCreated(Object created) {
        this.created = created;
    }

    public static Bus mapToBus(Map map){
        return new Bus(map.get("name").toString(),Double.valueOf(map.get("latitude").toString()),Double.valueOf(map.get("longitude").toString()),Boolean.valueOf(map.get("active").toString()),Long.valueOf(map.get("created").toString()));
    }
}
