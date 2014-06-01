package org.helpinghands.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kelly on 5/31/14.
 */
public class Event {

    @Id
    private String id;

    private String name;
    private String datetime;

    private URL website;
    private String descriptionShort;
    private String descriptionLong;
    private double cost;

    private List<String> services = new ArrayList<String>();

    private Point location;

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public void setLocation(double latitude, double longitude){
        this.location = new Point(latitude, longitude);
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

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public URL getWebsite() {
        return website;
    }

    public void setWebsite(URL website) {
        this.website = website;
    }

    public String getDescriptionShort() {
        return descriptionShort;
    }

    public void setDescriptionShort(String descriptionShort) {
        this.descriptionShort = descriptionShort;
    }

    public String getDescriptionLong() {
        return descriptionLong;
    }

    public void setDescriptionLong(String descriptionLong) {
        this.descriptionLong = descriptionLong;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
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
                "Event[id=%s, name='%s']",
                id, name);
    }
}
