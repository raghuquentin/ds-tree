package com.avl;

import lombok.Data;

@Data
public class AVLNode<T> {
    private T data;
    private AVLNode<T> leftChild;
    private AVLNode<T> rightChild;
    //used to track the height of the node
    private int height;
}
