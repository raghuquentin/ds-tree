package com.avl;

/**
 * AVL tree implementation, It same as BST but if the tree is unbalanced, then we need to
 * rotate the tree for balancing.
 *
 * Note : In recursion, we need to set the return node, because after rotating the tree we are returning the
 *       temp child, that needs to be set to the parentnode, we are not rotate by using inmemory, we rotate
 *       by using the tempchild refernces.
 */
public class AVLTreeMain {
    public static void main(String[] args) {

        AVLTree<Department> tree = new AVLTreeImpl();
        tree.insert(new Department(20,"James"));
        tree.insert(new Department(25,"James"));
        tree.insert(new Department(23,"James"));
        tree.insert(new Department(19,"James"));
        tree.insert(new Department(17,"James"));
        tree.insert(new Department(30,"James"));
        tree.insert(new Department(29,"James"));
        tree.insert(new Department(31,"James"));
        tree.insert(new Department(35,"James"));
        tree.insert(new Department(33,"James"));
        tree.insert(new Department(40,"James"));

        tree.traversal();
    }
}
