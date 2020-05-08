package com.yocan.tencent.discuss;

import com.yocan.algorithm.practice.HeapSort;

import java.util.ArrayList;

/**
 * 关于引用值传递的一些实践
 */
public class TestC {

    private HeapSort heapSort =new HeapSort();

    private ArrayList<Integer> integers =new ArrayList<Integer>();

    public ArrayList<Integer>  getList(){
        integers.add(10);
        return this.integers;
    }
    public ArrayList<Integer>  getList1(){
        ArrayList<Integer> listNew =this.integers;
        listNew.add(11);
        return listNew;
    }

    public void print(){
        System.out.println(this.integers.toString());
    }

    public static void main(String[] args) {
        TestC testC =new TestC();
        ArrayList<Integer> integers =testC.getList();
        integers.add(12);
        System.out.println(testC.getList().toString());
        System.out.println(testC.getList1().toString());
        testC.print();
    }
}



