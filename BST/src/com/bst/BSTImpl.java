package com.bst;

public class BSTImpl implements BSTTree<Employee>{
    public BSTNode<Employee> rootNode;

    public void add(Employee e){
        if(rootNode == null) {
            BSTNode<Employee> newNode = new BSTNode<>();
            newNode.setData(e);
            rootNode=newNode;
        }else{
            addBstNode(rootNode,e);
        }
    }

    private void addBstNode(BSTNode<Employee> node, Employee e) {
        if(e.getEmployeeId()<=node.getData().getEmployeeId()){
            if(node.getLeftChild() !=null)
                addBstNode(node.getLeftChild(),e);
            else {
                BSTNode<Employee> leftChildNode = new BSTNode<>();
                leftChildNode.setData(e);
                node.setLeftChild(leftChildNode);
            }
        }else{
            if(node.getRightChild() !=null){
                addBstNode(node.getRightChild(),e);
            }else{
                BSTNode<Employee> rightChildNode = new BSTNode<>();
                rightChildNode.setData(e);
                node.setRightChild(rightChildNode);
            }
        }
    }

    public int getMax(){
        BSTNode<Employee> node = rootNode.getRightChild();
        int maxValue=0;
        while(node!=null){
            maxValue=node.getData().getEmployeeId();
            node=node.getRightChild();
        }
        return maxValue;
    }
    public int getMin(){
        BSTNode<Employee> node = rootNode.getLeftChild();
        int maxValue=0;
        while(node!=null){
            maxValue=node.getData().getEmployeeId();
            node=node.getLeftChild();
        }
        return maxValue;
    }
    public void traversel(){
        preOrderTraversel(rootNode);
        postorderTraversel(rootNode);
        System.out.println("=====INORDER=========");
        inOrderTraversel(rootNode);
        System.out.println("=====INRDER============");
    }

    private void inOrderTraversel(BSTNode<Employee> node) {
        if(node == null) return;
        inOrderTraversel(node.getLeftChild());
        System.out.print(node.getData().getEmployeeId()+",");
        inOrderTraversel(node.getRightChild());
    }

    private void postorderTraversel(BSTNode<Employee> node) {
        if(node == null) return;
        postorderTraversel(node.getLeftChild());
        postorderTraversel(node.getRightChild());
        System.out.println(node.getData().getEmployeeId());
    }

    private void preOrderTraversel(BSTNode<Employee> node) {
        if(node==null) return;
        System.out.println(node.getData().getEmployeeId());
        preOrderTraversel(node.getLeftChild());
        preOrderTraversel(node.getRightChild());
    }

    public void delete(Employee e){
        deleteNode(rootNode,e);
    }

    private BSTNode<Employee> deleteNode(BSTNode<Employee> node, Employee e) {
        if(node == null) return node;
        if(e.getEmployeeId() < node.getData().getEmployeeId())
            node.setLeftChild(deleteNode(node.getLeftChild(),e));
        else if(e.getEmployeeId() > node.getData().getEmployeeId())
            node.setRightChild(deleteNode(node.getRightChild(),e));
        else
        {
            if(node.getLeftChild() == null && node.getRightChild() == null)
                node = null;
            else if(node.getLeftChild()==null)
                node = node.getRightChild();
            else if(node.getRightChild() ==null)
                node = node.getLeftChild();
            else if(node.getLeftChild() !=null && node.getRightChild() !=null) {
                BSTNode<Employee> minNode = findMin(node.getRightChild());
                node.setData(minNode.getData());
                node.setRightChild(deleteNode(minNode.getRightChild(),minNode.getData()));
            }
        }
        return node;
    }

    private BSTNode<Employee> findMin(BSTNode<Employee> node) {
       while(node.getLeftChild() != null)
           node = node.getLeftChild();

        return node;
    }


}
