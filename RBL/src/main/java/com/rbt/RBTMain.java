package com.rbt;

public class RBTMain {
    public static void main(String[] args) {
        RBTImpl<Integer> tree  = new RBTImpl<>();

        tree.insert(10);
        tree.insert(18);
        tree.insert(7);
        tree.insert(15);
        tree.insert(16);
        tree.insert(30);
        tree.insert(25);
        tree.insert(40);
        tree.insert(60);
        tree.insert(2);
        tree.insert(1);
        tree.insert(70);

        tree.traversal();
    }
}
