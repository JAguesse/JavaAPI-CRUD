package com.api.restaurant.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name="menus")
public class Menu {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy ="uuid")
    private String idMenu;

    private String starter;



    private String dish;

    private String dessert;

    public String getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(String idMenu) {
        this.idMenu = idMenu;
    }

    public String getStarter() {
        return starter;
    }

    public void setStarter(String starter) {
        this.starter = starter;
    }

    public String getDish() {
        return dish;
    }

    public void setDish(String dish) {
        this.dish = dish;
    }

    public String getDessert() {
        return dessert;
    }

    public void setDessert(String dessert) {
        this.dessert = dessert;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "idMenu='" + idMenu + '\'' +
                ", starter='" + starter + '\'' +
                ", dish='" + dish + '\'' +
                ", dessert='" + dessert + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Menu menu = (Menu) o;

        if (starter != null ? !starter.equals(menu.starter) : menu.starter != null) return false;
        if (dish != null ? !dish.equals(menu.dish) : menu.dish != null) return false;
        return dessert != null ? dessert.equals(menu.dessert) : menu.dessert == null;
    }

    @Override
    public int hashCode() {
        int result = starter != null ? starter.hashCode() : 0;
        result = 31 * result + (dish != null ? dish.hashCode() : 0);
        result = 31 * result + (dessert != null ? dessert.hashCode() : 0);
        return result;
    }
}
