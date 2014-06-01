package org.helpinghands.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ocx on 5/31/14.
 */
public class Organization {

    @Id
    private String id;

    private String name;
    private String hours;

    private URL website;
    private String phone;
    private String email;
    private String address;

    private List<String> services = new ArrayList<String>();

    private Point location;

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public void setLocation(double latitude, double longitude){
        this.location = new Point(longitude, latitude);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public URL getWebsite() {
        return website;
    }

    public void setWebsite(URL website) {
        this.website = website;
    }

    public void setWebsite(String website){
        try {
            this.website = new URL(website);
        } catch (MalformedURLException e) {

        }
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getServices() {
        return services;
    }

    public void setServices(List<String> services) {
        this.services = services;
    }

    public void addService(String service){
        this.services.add(service);
    }

    @Override
    public String toString() {
        return String.format(
                "Organization[id=%s, name='%s']",
                id, name);
    }
}
