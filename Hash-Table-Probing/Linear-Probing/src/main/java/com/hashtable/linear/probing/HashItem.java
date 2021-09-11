package com.hashtable.linear.probing;

import lombok.Data;

@Data
public class HashItem {
    private int key;
    private int value;
    public HashItem(int key, int value){
        this.key=key;
        this.value=value;
    }
}
