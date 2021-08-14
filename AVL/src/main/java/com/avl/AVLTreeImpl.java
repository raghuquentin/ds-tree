package com.avl;

public class AVLTreeImpl implements AVLTree<Department>{
    AVLNode<Department> rootNode;

    public void insert(Department department) {
        if(rootNode ==null){
            AVLNode<Department> node = new AVLNode<>();
            node.setData(department);
            rootNode = node;
        }else{
            rootNode = insertNode(rootNode,department);
        }
    }

    private AVLNode insertNode(AVLNode<Department> node, Department department) {
        System.out.println("insert : "+department.toString());
        if(node == null) {
            AVLNode lNode = new AVLNode<Department>();
            lNode.setData(department);
            return lNode;
        }
        else if(department.getId() < node.getData().getId()){
                node.setLeftChild(insertNode(node.getLeftChild(),department));
        }
        else {
                node.setRightChild(insertNode(node.getRightChild(),department));
        }
        updateHeight(node);
      return settleVoilation(node);
    }
    /**
     * @param node
     * right rotation, when the BF is positive >1 for the left heavy cases
     */
    public AVLNode<Department> rightRotation(AVLNode<Department> node){
        System.out.println("doing right rotation : "+node.getData().toString());
        //this node going to the new root node
        AVLNode<Department> tempLeftChild = node.getLeftChild();
        //this node going to attach with current root nod Se of right
        AVLNode<Department> grandChild = tempLeftChild.getRightChild();
        //rotation happens here
        tempLeftChild.setRightChild(node);
        node.setLeftChild(grandChild);
        //check if the current node is root, if its reassign the rootnode reference
        if(node == rootNode)
            rootNode = tempLeftChild;
        //update the height for the tempLeftChild and node
        updateHeight(node);
        updateHeight(tempLeftChild);
        return tempLeftChild;
    }
    /**
     * @param node
     * right rotation, when the BF is negative >-1 for the right heavy cases
     */
    public AVLNode<Department> leftRotation(AVLNode<Department> node){
        System.out.println("doing left rotation : "+node.getData().toString());
        //this node going to the new root node
        AVLNode<Department> tempRightChild = node.getRightChild();
        //this node going to attach with current root node of right
        AVLNode<Department> grandChild = tempRightChild.getLeftChild();
        //rotation happens here
        tempRightChild.setLeftChild(node);
        node.setRightChild(grandChild);
        //check if the current node is root, if its reassign the rootnode reference
        if(node == rootNode)
            rootNode = tempRightChild;
        //update the height for the tempLeftChild and node
        updateHeight(node);
        updateHeight(tempRightChild);
        return tempRightChild;
    }

    public void remove(Department department){
        removeNode(rootNode,department);
    }

    /**
     * Purpose : used to rotate the tree structure by using balance factor
     * Rotation case 1 :
     *              Left heavy situation : when the balancefactor greater than +1, which contain two subcases
     *                                     left-left case, left right case
     * Rotation case 2 :
     *              Right heavy situation :  when the balancefactor less than -1, which contain two subcases
     *                                      right-right case, right left case
     */
    public AVLNode<Department> settleVoilation(AVLNode<Department> node){
        System.out.println("rotation started for the node :: "+node.getData().toString());
        int balanceFactor = getBalanceFactor(node);
        //case 1
        if(balanceFactor >1){
            //subcase 2
            if(getBalanceFactor(node.getLeftChild())<0){
                System.out.println("left rotation in the left heavy case (left right case).........");
                node.setLeftChild(leftRotation(node.getLeftChild()));
            }
            //subcase 1
            System.out.println("right rotation in the left heavy case (left left case).........");
            return rightRotation(node);
        }
        //case 2
        else if(balanceFactor < -1){
            //subcase 2
            if(getBalanceFactor(node.getRightChild())>0){
                System.out.println("right rotation in the right heavy case (right left case).........");
                node.setRightChild(rightRotation(node.getRightChild()));
            }
            //subcase 1
            System.out.println("left rotation in the right heavy case (right right case).........");
            return  leftRotation(node);
        }
        return node;
    }

    private AVLNode removeNode(AVLNode<Department> node, Department ele) {
        if(node == null) return node;
        else if(ele.getId()<node.getData().getId()){
            node.setLeftChild(removeNode(node.getLeftChild(),ele));
        }else if(ele.getId()>node.getData().getId()){
            node.setRightChild(removeNode(node.getRightChild(),ele));
        }else{
            if(node.getLeftChild() == null && node.getRightChild() == null){
                node = null;
            }else if(node.getLeftChild() == null){
                node = node.getRightChild();
            }else if(node.getRightChild() == null){
                node = node.getLeftChild();
            }else if(node.getLeftChild()!=null && node.getRightChild() !=null){
                AVLNode<Department> minNode = findMin(node.getRightChild());
                node.setData(minNode.getData());
                node.setRightChild(removeNode(node.getRightChild(), node.getData()));
            }
        }
        updateHeight(node);
        return settleVoilation(node);
    }

    private AVLNode<Department> findMin(AVLNode<Department> rightChild) {
        if (rightChild.getLeftChild() == null)
            return rightChild;
        return findMin(rightChild.getLeftChild());
    }

    /**
     *  update the height of the given node
     *  formula height = Max( h(left) , h(right) )+1
     */
    private void updateHeight(AVLNode<Department> node){
        System.out.println("updateHeight : "+node.getData().toString());
        node.setHeight(Math.max(getHeight(node.getLeftChild()),getHeight(node.getRightChild()))+1);
    }

    //find the height of the given node
    private int getHeight(AVLNode<Department> node){
        if(node == null)
            return -1;
        return node.getHeight();
    }
    /**
     * find the balance factor for the given node
     * BF used to find left heavy case(positive BF) or right heavy case(negative BF)
     * formula: BF = h(left)-h(right)
     */
    private int getBalanceFactor(AVLNode<Department> node){
        int balanceFactor;
        if(node == null) {
            balanceFactor=0;
        }else{
            balanceFactor= getHeight(node.getLeftChild())-getHeight(node.getRightChild());
        }
        System.out.println("balanceFactor : "+balanceFactor+" : node : "+node.getData().toString());
        return balanceFactor;
    }



    public void traversal(){
        inOrderTraversal(rootNode);
    }

    private void inOrderTraversal(AVLNode<Department> node) {
        if(node == null) return;
        inOrderTraversal(node.getLeftChild());
        System.out.print(node.getData().getId()+":"+node.getData().getName()+":"+node.getHeight()+" ==> ");
        inOrderTraversal(node.getRightChild());
    }
}
