package entities;

import entities.enums.FromTo;
import entities.enums.ReqStatus;

public class Location {
    private int id;
    private double lat;
    private double lng;
    private FromTo fromTo;
    private ReqStatus reqStatus = ReqStatus.WAITING;
    private long account_id;

    public long getAccount_id() {
        return account_id;
    }

    public void setAccountId(long account_id) {
        this.account_id = account_id;
    }

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

    public double getLng() {
        return lng;
    }
    public double getLat(){
        return lat;
    }
    public void setLat(double lat){
        this.lat = lat;
    }
    public void setLng(double lng) {
        this.lng = lng;
    }

    public FromTo getFromTo() {
        return fromTo;
    }
    public void setFromTo(FromTo fromTo) {
        this.fromTo = fromTo;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", lat='" + lat + '\'' +
                ", lng=" + lng +'\''+
                ", FromTo='" + fromTo + '\'' +
                ", accountId='" + account_id + '\'' +
                ", Request Status='" + reqStatus + '\'' +
                '}';
    }
}

