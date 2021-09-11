package com.hastable.impl;

/**
 * Hash Table - Chaininig - implementation
 */
public class HashTableImpl {
    HashItem[] table;
    public HashTableImpl(){
        table= new HashItem[Constant.TABLE_SIZE];
    }

    // simple hash function return the array index
    //to test collision return 1
    private int hash(int key){
        //return key%Constant.TABLE_SIZE;
        return 1;
    }
    public int get(int key){
        int arrayIndex = hash(key);

        if(table[arrayIndex] == null)
            return -1;
        else{
            HashItem hashItem = table[arrayIndex];
            while(table[arrayIndex] != null && hashItem.getKey() != key){
                hashItem = hashItem.getNextHashItem();
            }
            if(hashItem == null)
                return -1;
            else
                return hashItem.getValue();
        }

    }
    public void put(int key, int value){
        int arrayIndex = hash(key);
        if(table[arrayIndex] != null){
            System.out.println("Collision...key::"+key);
            HashItem hashItem = table[arrayIndex];

            while(hashItem.getNextHashItem() !=null){
                hashItem = hashItem.getNextHashItem();
            }
            hashItem.setNextHashItem(new HashItem(key, value));
        }else{
            System.out.println("No collison");
            table[arrayIndex] = new HashItem(key,value);
        }
    }

}
