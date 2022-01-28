package com.shavi.shavirestaurant.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "Trackings")
public class Tracking {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String status;

    // add order one to one
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customerorder_id",referencedColumnName = "id")
    private CustomerOrder customerOrder;

    public CustomerOrder getCustomerOrder() {
        return customerOrder;
    }

    public void setCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
    }

    public Tracking() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Tracking{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", customerOrder=" + customerOrder +
                '}';
    }
}
