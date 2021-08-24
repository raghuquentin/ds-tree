package com.rbt;

import lombok.Data;

@Data
public class RBTNode<T>  {
    private T data;
    private RBTNode<T> leftChild;
    private RBTNode<T> rightChild;
    private RBTNode<T> parentNode;
    private NodeColor color;
    public RBTNode(T data, RBTNode<T> parentNode){
        this.data = data;
        this.parentNode = parentNode;
        this.color = NodeColor.RED;
    }
}
