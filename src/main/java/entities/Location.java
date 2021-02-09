package entities;

import entities.enums.ReqStatus;

public class Location {
    private int id;
    private double streetFrom;
    private double streetTo;
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

    public double getStreetTo() {
        return streetTo;
    }
    public double getStreetFrom(){
        return streetFrom;
    }

    public void setStreetTo(double streetTo) {
        this.streetTo = streetTo;
    }
    public void setStreetFrom(double streetFrom){
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

