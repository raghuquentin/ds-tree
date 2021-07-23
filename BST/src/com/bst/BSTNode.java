package com.bst;

public class BSTNode<T> {
    private T data;
    private BSTNode<T> leftChild;
    private BSTNode<T> rightChild;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BSTNode<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BSTNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public BSTNode<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(BSTNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return "BSTNode : "+data;
    }
}
