package com.shavi.shavirestaurant.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Meals")
public class Meal {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private int serving;

    @Column
    private String imageUrl;

    @Column
    private double price;

    // add category many to one
    @JsonIgnore
    @JoinColumn(name = "category_id")
    @ManyToOne
    private Category category;

    // add order one to many
    @OneToMany(mappedBy = "meal", orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Order> orderList ;

    //add nutrition many to one
    @JsonIgnore
    @JoinColumn(name = "nutrition_id")
    @ManyToOne
    private Nutrition nutrition;

    public Meal() {

    }

    @Override
    public String toString() {
        return "Meal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", serving=" + serving +
                ", imageUrl='" + imageUrl + '\'' +
                ", price=" + price +
                ", category=" + category +
                ", orderList=" + orderList +
                ", nutrition=" + nutrition +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getServing() {
        return serving;
    }

    public void setServing(int serving) {
        this.serving = serving;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public Nutrition getNutrition() {
        return nutrition;
    }

    public void setNutrition(Nutrition nutrition) {
        this.nutrition = nutrition;
    }
}
