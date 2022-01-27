package com.shavi.shavirestaurant.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Nutritions")
public class Nutrition {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nutrition;

    // meal one to many
    @OneToMany(mappedBy = "nutrition", orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Meal> mealList ;

    public Nutrition() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNutrition() {
        return nutrition;
    }

    public void setNutrition(String nutrition) {
        this.nutrition = nutrition;
    }

    public List<Meal> getMealList() {
        return mealList;
    }

    public void setMealList(List<Meal> mealList) {
        this.mealList = mealList;
    }

    @Override
    public String toString() {
        return "Nutrition{" +
                "id=" + id +
                ", nutrition='" + nutrition + '\'' +
                ", mealList=" + mealList +
                '}';
    }
}
