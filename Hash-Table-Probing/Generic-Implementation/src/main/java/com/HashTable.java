package com;

public class HashTable<Key,Value> {
    private Key[] keys;
    private Value[] values;
    private int capacity;
    private int numOfItems;
    private static final int TABLE_SIZE = 10;
    private static final float LOAD_FACTOR = 0.75f;

    public HashTable(){
        this.keys = (Key[]) new Object[TABLE_SIZE];
        this.values = (Value[]) new Object[TABLE_SIZE];
        this.capacity = TABLE_SIZE;
        this.numOfItems = 0;
    }
    public HashTable(int resizeValue){
        this.keys = (Key[]) new Object[resizeValue];
        this.values = (Value[]) new Object[resizeValue];
        this.capacity = resizeValue;
        this.numOfItems = 0;
    }
    public Value get(Key key){
        int arrayIndex = hash(key);
        while(keys[arrayIndex]!=null && keys[arrayIndex] != key){
            arrayIndex=(arrayIndex+1)%capacity;
        }
        return values[arrayIndex];
    }
    public  void put(Key key, Value value){
        int arrayIndex = hash(key);
        if(numOfItems >=capacity*LOAD_FACTOR)
            System.out.println("do something..");
        while(keys[arrayIndex]!=null){
            if(keys[arrayIndex] == key){
                values[arrayIndex] = value;
                return;
            }
            arrayIndex=(arrayIndex+1)%capacity;
        }
        keys[arrayIndex] = key;
        values[arrayIndex]=value;
        numOfItems++;
    }
    public void remove(Key key){
        if(key == null)
            return;
        int arrayIndex = hash(key);
        while(keys[arrayIndex] != key)
            arrayIndex = (arrayIndex+1)%capacity;
        keys[arrayIndex] = null;
        values[arrayIndex]=null;

        while(keys[arrayIndex] != null){
            Key tempKey = keys[arrayIndex];
            Value tempValue = values[arrayIndex];
        }
        // need to move up other values, we cannot leave empty slot in the middle
        //it affects get method
        //see later
    }

    private int hash(Key key) {
        return key.hashCode() % capacity;
    }


    public int size(){
        return numOfItems;
    }
    public boolean isEmpty(){
        return numOfItems == 0;
    }
}
