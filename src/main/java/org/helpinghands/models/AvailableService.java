package org.helpinghands.models;


import org.springframework.data.annotation.Id;

/**
 * Created by ocx on 5/31/14.
 */
public class AvailableService {

    @Id
    private String id;

    private String service;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }


}
