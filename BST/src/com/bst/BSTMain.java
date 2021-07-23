package com.bst;

public class BSTMain {
    public static void main(String[] args) {
        BSTImpl impl = new BSTImpl();
        impl.add(new Employee(25,"James","Bond"));
        impl.add(new Employee(20,"James","Bond"));
        impl.add(new Employee(23,"James","Bond"));
        impl.add(new Employee(19,"James","Bond"));
        impl.add(new Employee(17,"James","Bond"));
        impl.add(new Employee(30,"James","Bond"));
        impl.add(new Employee(29,"James","Bond"));
        impl.add(new Employee(31,"James","Bond"));
        impl.add(new Employee(35,"James","Bond"));
        impl.add(new Employee(33,"James","Bond"));
        impl.add(new Employee(40,"James","Bond"));

        System.out.println("max :: "+impl.getMax());
        System.out.println("min :: "+impl.getMin());
        impl.traversel();
        impl.delete(new Employee(17,"James","Bond"));
    }
}
