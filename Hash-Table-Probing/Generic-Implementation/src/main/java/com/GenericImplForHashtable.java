package com;

public class GenericImplForHashtable {
    public static void main(String[] args) {
        HashTable<Integer,String> table = new HashTable<>();
        table.put(1,"test1");
        table.put(2,"test2");
        table.put(3,"test3");
        table.put(4,"test4");
        table.put(5,"test5");
        table.put(6,"test6");
        System.out.println(table.get(3));
        System.out.println(table.get(4));
        table.remove(2);
    }
}
