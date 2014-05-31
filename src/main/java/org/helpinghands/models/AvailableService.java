package org.helpinghands.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by ocx on 5/31/14.
 */
@Entity
public class AvailableService {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private String service;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }


    @Override
    public String toString() {
        return String.format(
                "AvailableService[id=%d, service='%s']",
                id, service);
    }
}
