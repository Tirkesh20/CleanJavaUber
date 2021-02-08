package entities;
import entities.enums.TransactionStatus;

import java.sql.Timestamp;

public class Transactions {
    private int id;
    private TransactionStatus type;

    private int order_id;
    private Timestamp pay_date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrder_id(){return order_id;}

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public void setPay_date(Timestamp pay_date) {
        this.pay_date = pay_date;
    }

    public Timestamp getPay_date() {
        return pay_date;
    }


    public void setType(TransactionStatus type) {
        this.type = type;
    }

}
