package co.edu.uelbosque.software.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by david on 16/11/16.
 */
public class ShoppingRequest {

    private String date_shopping;
    private int product_id;
    private int quantity;
    private double total_price;

    public String getDate_shopping() {
        return date_shopping;
    }

    public void setDate_shopping(String date_shopping) {
        this.date_shopping = date_shopping;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }
}
