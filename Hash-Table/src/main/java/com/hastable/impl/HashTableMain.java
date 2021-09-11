package com.hastable.impl;

/**
 * Hash table implemented by chaining method in HashTableImpl class
 * If collision is occurred, then linked list created in the collision occurred array slot
 * like if collision occurred in the arrayslot 1 then items will be ::::=> hashitem1->hashitem2->.....
 *
 **/
public class HashTableMain {
    public static void main(String[] args) {
        HashTableImpl impl = new HashTableImpl();
        impl.put(1,10);
        impl.put(2,100);
        impl.put(3,1000);
        impl.put(4,10000);
        impl.put(5,100000);

        System.out.println(impl.get(5));
    }
}
