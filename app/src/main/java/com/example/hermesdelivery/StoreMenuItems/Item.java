package com.example.hermesdelivery.StoreMenuItems;

public class Item {
    String name;
    String description;
    int image;

    public Item(String name, String info, int image) {
        this.name = name;
        this.description = info;
        this.image = image;
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

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
