package com.hastable.impl;

import lombok.Data;

/**
 * Model class for Hash table
 */
@Data
public class HashItem {
    private int key;
    private int value;
    //if collision occurred
    private HashItem nextHashItem;

    public HashItem(int key, int value){
        this.key = key;
        this.value = value;
    }

}
