package org.helpinghands.models;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

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
}
