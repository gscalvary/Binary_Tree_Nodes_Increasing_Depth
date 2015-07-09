package com.oliver;

import java.util.ArrayList;

public class BinaryTree<T> {

    private ArrayList<BinaryTreeNode<T>> treeNodes;

    public BinaryTree() {

        treeNodes = new ArrayList<BinaryTreeNode<T>>();
    }

    public void insert(T data) {

        if(data == null) return;

        treeNodes.add(new BinaryTreeNode<T>(data));
    }

    public ArrayList<BinaryTreeNode<T>> getChildren(BinaryTreeNode<T> node) {

        ArrayList<BinaryTreeNode<T>> children = new ArrayList<BinaryTreeNode<T>>();

        int size = treeNodes.size();

        for(int i = 0; i < size; i++) {
            if(treeNodes.get(i) == node) {
                int childIndex = 2 * i + 1;
                if(childIndex < size) {
                    children.add(treeNodes.get(childIndex));
                    if(childIndex + 1 < size) {
                        children.add(treeNodes.get(childIndex + 1));
                    } else {
                        children.add(null);
                    }
                } else {
                    children.add(null);
                    children.add(null);
                }
                return children;
            }
        }

        children.add(null);
        children.add(null);
        return children;
    }

    public BinaryTreeNode<T> getHead() {

        return treeNodes.get(0);
    }
}
