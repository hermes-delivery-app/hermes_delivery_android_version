package com.example.hermesdelivery;

import com.example.hermesdelivery.StoreMenuItems.Item;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JSONResponse {

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public Item[] items;
}
