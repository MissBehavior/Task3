package com.example.task3.model;

import com.example.task3.model.Status;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "mainOrder")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @OneToOne(targetEntity = User.class, cascade = CascadeType.ALL)
    private User user;
    @OneToOne(targetEntity = Courier.class, cascade = CascadeType.ALL)
    private Courier courier;
    private String orderAddress;

    private Status status;

    @OneToMany(targetEntity = OrderItem.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OrderItem> orderItems;

    public Order() {
    }

    public Order(int id, User user, Courier courier, String orderAddress, List<OrderItem> orderItems, Status status) {
        this.id = id;
        this.user = user;
        this.courier = courier;
        this.orderAddress = orderAddress;
        this.orderItems = orderItems;
        this.status = status;
    }

    public Order(User user, Courier courier, String orderAddress, List<OrderItem> orderItems, Status status) {
        this.user = user;
        this.courier = courier;
        this.orderAddress = orderAddress;
        this.orderItems = orderItems;
        this.status = status;
    }


    public int getId() {
        return id;
    }

    public void setId(int orderId) {
        this.id = orderId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public Status getStatus() {
        return this.status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public String toString() {
        System.out.println("--------------------------------------------- BLa");
        return String.format("lt.viko.eif.vjakubcevic.shop.model: " +
                "\n\tOrder ID = %d" +
                "\n\t%s" +
                "\n\t%s" +
                "\n\tOrder Address = %s" +
                "\n\n Order Status = %s" +
                "\n\t%s", this.id,
                this.user,
                this.courier,
                this.orderAddress,
                this.status.toString(),
                constructOrderItemsList());

    }

    private Object constructOrderItemsList() {
        StringBuilder result = new StringBuilder();
        System.out.println(orderItems.size());
        System.out.println("---------------------------");
        for (OrderItem orderitem : this.orderItems) {
            result.append(orderitem.toString());
        }
        return result.toString();
    }
}