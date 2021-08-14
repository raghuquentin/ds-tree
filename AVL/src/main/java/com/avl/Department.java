package com.avl;

import lombok.Data;

@Data
public class Department {
    private int id;
    private String name;
    public Department(int id, String name){
        this.id = id;
        this.name= name;
    }
}

