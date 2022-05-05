package com.api.restaurant.model;

import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="restaurant")
@NoArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy ="uuid")
    private String id;

    @Column(name="name")
    private String name;

    @Column(name="address")
    private String address;

    @OneToMany(cascade = CascadeType.ALL) // Deleting a restaurant delete all menus
    @Column(name="menus")
    private Set<Menu> menus = new HashSet<>(); // Set is a way to exclude duplicates menus in a same restaurant

    public Restaurant(String name, String address, Set<Menu> menus) {
        this.name = name;
        this.address = address;
        this.menus = menus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Menu> getMenus() {
        return menus;
    }

    public void setMenus(Set<Menu> menus) {
        this.menus = menus;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", menus=" + menus.toString() +
                '}';
    }
}
