package com.oliver;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        BinaryTree<Integer> bt = new BinaryTree<Integer>();
        bt.insert(314);
        bt.insert(6);
        bt.insert(6);
        bt.insert(271);
        bt.insert(561);
        bt.insert(2);
        bt.insert(271);
        bt.insert(28);
        bt.insert(0);

        DepthComputer<Integer> depthComputer = new DepthComputer<Integer>();
        ArrayList<ArrayList<Integer>> arrayLists = depthComputer.compute(bt);

        for(int i = 0; i < arrayLists.size(); i++) {
            System.out.print("depth " + i + ": ");
            for(Integer integer : arrayLists.get(i)) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
