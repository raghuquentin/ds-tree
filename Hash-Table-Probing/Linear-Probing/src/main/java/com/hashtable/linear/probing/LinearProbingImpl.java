package com.hashtable.linear.probing;

/**
 * Implementation of Hashtable by using Linear Probing
 * Linear Probing : If collision occurred need to find the diffrent index by rehashing linearly
 */
public class LinearProbingImpl {
    //total size of hash table
    private static final int TABLE_SIZE = 10;
    private HashItem[] table;
    public LinearProbingImpl(){
        table = new HashItem[TABLE_SIZE];
    }
    public int get(int key){
        int arrayIndex = hash(key);
        HashItem hashItem = table[arrayIndex];
        //due to the collision we need to traverse in the index till the key match
        while(table[arrayIndex]!=null && table[arrayIndex].getKey() != key){
            arrayIndex = (arrayIndex+1)%TABLE_SIZE;
        }
        if(table[arrayIndex] == null)
            return -1;
        else
            return table[arrayIndex].getValue();
    }
    public void put(int key, int value){
        int arrayIndex = hash(key);
        //if collision happened need to find the another index
        while(table[arrayIndex]!=null){
            arrayIndex = (arrayIndex+1)%TABLE_SIZE;
        }
       table[arrayIndex] = new HashItem(key,value);

    }
    //for testing the collision return 1
    private int hash(int key){
        //return key % TABLE_SIZE;
        return 1;
    }
}
