package com.rbt;

public class RBTImpl<T extends Comparable> {
    private RBTNode<T> rootNode;

    public void insert(T data){
        if(rootNode == null) {
            rootNode = new RBTNode<T>(data, null);
            settleViolation(rootNode);
        }
        else
            insertNode(rootNode,data);
    }

    private RBTNode<T> insertNode(RBTNode<T> node, T data) {
        if(node == null) return node;

         if(node.getData().compareTo(data) >0){
             if(node.getLeftChild() !=null)
                    insertNode(node.getLeftChild(),data);
             else{
                 RBTNode<T> newNode = new RBTNode<T>(data,node);
                 node.setLeftChild(newNode);
                 settleViolation(newNode);
             }
        }else{
             if(node.getRightChild()!=null)
                 insertNode(node.getRightChild(),data);
             else{
                 RBTNode<T> newNode = new RBTNode<T>(data,node);
                 node.setRightChild(newNode);
                 settleViolation(newNode);
             }
         }
         settleViolation(node);
         return node;
    }

    public void settleViolation(RBTNode<T> node){
        RBTNode<T> parentNode = null;
        RBTNode<T> grandParentNode = null;

        while( node != rootNode && isRed(node) && isRed(node.getParentNode())){
            parentNode = node.getParentNode();
            grandParentNode = parentNode.getParentNode();

            if(parentNode == grandParentNode.getLeftChild() ){
                RBTNode<T> uncle = grandParentNode.getRightChild();
                if(uncle != null && isRed(uncle)){
                    parentNode.setColor(NodeColor.BLACK);
                    uncle.setColor(NodeColor.BLACK);
                    grandParentNode.setColor(NodeColor.RED);
                    node = grandParentNode;
                }
                else{
                    if(node == parentNode.getRightChild()){
                        leftRotation(parentNode);
                    }
                    rightRotation(grandParentNode);
                    NodeColor tempColor = grandParentNode.getColor();
                    grandParentNode.setColor(parentNode.getColor());
                    parentNode.setColor(tempColor);
                    node = parentNode;
                }
            }else
            if(parentNode ==grandParentNode.getRightChild() ){
                RBTNode<T> uncle = grandParentNode.getLeftChild();
                if(uncle != null && isRed(uncle)){
                    parentNode.setColor(NodeColor.BLACK);
                    uncle.setColor(NodeColor.BLACK);
                    grandParentNode.setColor(NodeColor.RED);
                    node = grandParentNode;
                }
                else{
                    if(node == parentNode.getLeftChild()){
                        rightRotation(parentNode);
                    }
                    leftRotation(grandParentNode);
                    NodeColor tempColor = grandParentNode.getColor();
                    grandParentNode.setColor(parentNode.getColor());
                    parentNode.setColor(tempColor);
                    node = parentNode;
                }
            }
        }
    }

    /**
     *
     * @param node
     * @return boolean
     * return true when the node color is red
     */
    private Boolean isRed(RBTNode<T> node){
        //in RBT null consider as BLACK node, so we return false
        if(node == null)
            return false;
        return node.getColor() == NodeColor.RED;
    }

    /**
     * @param node
     * right rotation, when the BF is positive >1 for the left heavy cases
     */
    public RBTNode<T> rightRotation(RBTNode<T> node){
        System.out.println("doing right rotation : "+node.getData().toString());
        //this node going to the new root node
        RBTNode<T> tempLeftChild = node.getLeftChild();
        //this node going to attach with current root nod Se of right
        RBTNode<T> grandChild = tempLeftChild.getRightChild();
        //rotation happens here
        tempLeftChild.setRightChild(node);
        node.setLeftChild(grandChild);

        if(grandChild !=null){
            grandChild.setParentNode(node);
        }
        tempLeftChild.setParentNode(node.getParentNode());
        node.setParentNode(tempLeftChild);

        if(tempLeftChild.getParentNode()!=null && tempLeftChild.getParentNode().getLeftChild() == node)
            tempLeftChild.getParentNode().setLeftChild(tempLeftChild);
        if(tempLeftChild.getParentNode() != null && tempLeftChild.getParentNode().getRightChild() == node)
            tempLeftChild.getParentNode().setRightChild(tempLeftChild);
        //check if the current node is root, if its reassign the rootnode reference
        if(node == rootNode)
            rootNode = tempLeftChild;
        return tempLeftChild;
    }
    /**
     * @param node
     * right rotation, when the BF is negative >-1 for the right heavy cases
     */
    public RBTNode<T> leftRotation(RBTNode<T> node){
        System.out.println("doing left rotation : "+node.getData().toString());
        //this node going to the new root node
        RBTNode<T> tempRightChild = node.getRightChild();
        //this node going to attach with current root node of right
        RBTNode<T> grandChild = tempRightChild.getLeftChild();
        //rotation happens here
        tempRightChild.setLeftChild(node);
        node.setRightChild(grandChild);
        if(grandChild !=null){
            grandChild.setParentNode(node);
        }
        tempRightChild.setParentNode(node.getParentNode());
        node.setParentNode(tempRightChild);

        if(tempRightChild.getParentNode()!=null && tempRightChild.getParentNode().getLeftChild() == node)
            tempRightChild.getParentNode().setLeftChild(tempRightChild);
        if(tempRightChild.getParentNode() != null && tempRightChild.getParentNode().getRightChild() == node)
            tempRightChild.getParentNode().setRightChild(tempRightChild);

        //check if the current node is root, if its reassign the rootnode reference
        if(node == rootNode)
            rootNode = tempRightChild;
        return tempRightChild;
    }

    public void traversal(){
        inOrderTraversal(rootNode);
    }

    private void inOrderTraversal(RBTNode<T> node) {
        if(node == null) return;
        inOrderTraversal(node.getLeftChild());
        System.out.print(node.getData()+":"+node.getColor()+" ==> ");
        inOrderTraversal(node.getRightChild());
    }

}
