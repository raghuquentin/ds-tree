package com.splay;

public class Node<T> {
    private Node<T> leftChild;
    private Node<T> rightChild;
    private Node<T> parentNode;
    private T data;
    public Node(T data, Node<T> parentNode){
        this.data = data;
        this.parentNode = parentNode;
    }

    public Node<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    public Node<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }

    public Node<T> getParentNode() {
        return parentNode;
    }

    public void setParentNode(Node<T> parentNode) {
        this.parentNode = parentNode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "data=" + data ;
    }
}
