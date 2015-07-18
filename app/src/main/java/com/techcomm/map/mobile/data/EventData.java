package com.techcomm.map.mobile.data;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * A model representing a community event or other data item.
 *
 * <p>For details, see the spreadsheet that is the data source:
 * https://docs.google.com/spreadsheets/d/18JYnZSBkbCRFgK07JvFnMPM0RrnOzqYBzg9sM2UNOuY/edit
 */
public class EventData extends RealmObject {

    @PrimaryKey private int localId;
    private String type;
    private String name;
    private String description;
    private String website;
    private String startDate;
    private String endDate;
    private String address;
    private double latitude;
    private double longitude;

    /** Public constructor exposed for Realm.io. Do not use. */
    public EventData() {}

    /** Public constructor for building an event. Use this one! */
    public EventData(int localId, String type, String name, String description, String website,
                     String startDate, String endDate, String address, double latitude,
                     double longitude) {
        this.localId = localId;
        this.type = type;
        this.name = name;
        this.description = description;
        this.website = website;
        this.startDate = startDate;
        this.endDate = endDate;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getLocalId() {
        return localId;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getWebsite() {
        return website;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getAddress() {
        return address;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLocalId(int localId) {
        this.localId = localId;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
