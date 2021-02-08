package entities;

import entities.enums.ReqStatus;

public class Location {
    private int id;
    private String streetFrom;
    private String streetTo;
    private ReqStatus reqStatus;

    public ReqStatus getReqStatus() {
        return reqStatus;
    }

    public void setReqStatus(ReqStatus reqStatus) {
        this.reqStatus = reqStatus;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getStreetTo() {
        return streetTo;
    }
    public String getStreetFrom(){
        return streetFrom;
    }

    public void setStreetTo(String streetTo) {
        this.streetTo = streetTo;
    }
    public void setStreetFrom(String streetFrom){
        this.streetFrom = streetFrom;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", streetName='" + streetFrom + '\'' +
                ", streetNumber=" + streetTo +
                '}';
    }
}

