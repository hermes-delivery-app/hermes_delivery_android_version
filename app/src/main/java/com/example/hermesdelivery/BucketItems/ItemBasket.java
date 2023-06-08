package com.example.hermesdelivery.BucketItems;

public class ItemBasket {
    String name;
    String Description;
    int __v;

    public ItemBasket(String name, String Description, int __v) {
        this.name = name;
        this.Description = Description;
        this.__v = __v;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    public int get__v() {
        return __v;
    }

    public void set__v(int __v) {
        this.__v = __v;
    }
}
