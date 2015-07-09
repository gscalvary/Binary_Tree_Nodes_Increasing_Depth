package com.oliver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DepthComputer<T> {

    public ArrayList<ArrayList<T>> compute(BinaryTree<T> bt) {

        ArrayList<ArrayList<T>> arrayLists = new ArrayList<ArrayList<T>>();

        // Check input.
        if(bt == null || bt.getHead() == null) return arrayLists;

        // Initialize method memory.
        Queue<BinaryTreeNode<T>> q = new LinkedList<BinaryTreeNode<T>>();
        q.offer(bt.getHead());
        arrayLists.add(new ArrayList<T>());
        int stop = 1;
        int processed = 0;
        int depth = 0;

        // Iterate through the binary tree.
        while (!q.isEmpty()) {
            // Poll and offer from the queue.
            BinaryTreeNode<T> node = q.poll();
            for(BinaryTreeNode<T> treeNode : bt.getChildren(node)) {
                if(treeNode != null) q.offer(treeNode);
            }
            // Add data to the correct array list in the list of arrays.
            arrayLists.get(depth).add(node.getData());
            // Add a new array list to the list of arrays at each change in depth.
            ++processed;
            if(processed == stop) {
                processed = 0;
                arrayLists.add(new ArrayList<T>());
                ++depth;
                stop = (int)Math.pow(2, stop);
            }
        }

        return arrayLists;
    }
}
