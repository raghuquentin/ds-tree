package com.heap;

/**
 * Heap ds used to implement the PriorityQueue,
 * Heap has two types: Min Heap, Max Heap
 * Min Heap : parent node less than the child node
 * Max Heap : parent node greater than the child node
 * Heap used to manipulate root node only
 * removal operation is costly when deleting the arbitrary node
 *
 * Max heap implementation
 */
public class HeapMain {
    public static void main(String[] args) {
        Heap h = new Heap();
        h.insert(10);
        h.insert(20);
        h.insert(30);
        h.insert(40);
        h.insert(50);
        h.insert(60);
        h.insert(70);
        h.poll();
        h.insert(80);
        while(!h.isEmpty()){
            System.out.println(h.poll());
        }

    }
}
