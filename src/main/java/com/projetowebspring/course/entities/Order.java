package com.projetowebspring.course.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projetowebspring.course.enums.OrderStatus;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.*;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;
    private Integer orderStatus;

    @OneToMany(mappedBy = "id.order")
    private Set<OrderItem> orderItems = new HashSet<OrderItem>();

    @ManyToOne
    @JoinColumn(name = "client_id") //causou loop
    private User client;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }



    public Order(Long id, Instant moment, User client, OrderStatus orderStatus) {
        this.id = id;
        this.moment = moment;
        this.client = client;
        setOrdersStatus(orderStatus);
    }

    public Order(){

    }

    public Set<OrderItem> getItems(){
        return orderItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public OrderStatus getOrdersStatus() {
        return OrderStatus.fromCode(orderStatus);
    }

    public void setOrdersStatus(OrderStatus ordersStatus) {
        if(ordersStatus != null){
            this.orderStatus = ordersStatus.getCode();
        }
    }

    public Double getTotal() {
        Double total = 0.0;
        for (OrderItem item : orderItems) {
            total += item.getSubTotal();
        }
        return total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", moment=" + moment +
                ", client=" + client +
                '}';
    }
}
