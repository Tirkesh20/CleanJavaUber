package entities;

import entities.enums.OrderStatus;

import java.sql.Timestamp;

public class Order {
    private int id;
    private int client_id;
    private int taxi_id;
    private int from_id;
    private int to_id;
    private Timestamp order_date;
    private OrderStatus status = OrderStatus.ACCEPTED;

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }
    public int getClient_id() {
        return client_id;
    }
    public int getFrom_id() {
        return from_id;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getTaxi_id() {
        return taxi_id;
    }
    public void setTaxi_id(int taxi_id) {
        this.taxi_id = taxi_id;
    }
    public int getTo_id() {
        return to_id;
    }
    public void setTo_id(int to_id) {
        this.to_id = to_id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void setFrom_id(int from_id) {
        this.from_id = from_id;
    }

    public Timestamp getOrder_date() {
        return order_date;

    }

    public void setOrder_date(Timestamp order_date) {
        this.order_date = order_date;
    }
}

