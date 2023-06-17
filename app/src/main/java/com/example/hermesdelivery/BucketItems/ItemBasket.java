package com.example.hermesdelivery.BucketItems;

public class ItemBasket {
    public ItemBasket(String _id, String name, String description, double price, String category_id, boolean isActive, int __v) {
        this._id = _id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category_id = category_id;
        this.isActive = isActive;
        this.__v = __v;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int get__v() {
        return __v;
    }

    public void set__v(int __v) {
        this.__v = __v;
    }

    String _id;
    String name;
    String description;
    double price;
    String category_id;
    boolean isActive;
    int __v;


}
