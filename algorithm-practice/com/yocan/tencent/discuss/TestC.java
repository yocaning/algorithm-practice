package com.yocan.tencent.discuss;

import java.util.ArrayList;

/**
 * 关于引用值传递的一些实践
 * 1.不管是this.integers 返回还是listNew都是返回的引用值，所以并没有什么区别
 * 关于使用临时变量在多线程中的测试
 * 1.多线程的修改都能立即在另外一个线程体现
 *
 */
public class TestC {


    private ArrayList<Integer> integers =new ArrayList<Integer>();

    public ArrayList<Integer>  getList() throws InterruptedException {
        Thread.sleep(1000);

        integers.add(10);
        System.out.println(integers.toString());
        return this.integers;
    }
    public ArrayList<Integer>  getList1() throws InterruptedException {
        ArrayList<Integer> listNew =this.integers;
        System.out.println(listNew.toString());
        Thread.sleep(3000);
        listNew.add(11);
        System.out.println(listNew.toString());
        return listNew;
    }

    public void print(){
        System.out.println(this.integers.toString());
    }

    public static void main(String[] args) {
        final TestC testC =new TestC();
//        ArrayList<Integer> integers =testC.getList();
//        integers.add(12);
//        System.out.println(testC.getList().toString());
//        System.out.println(testC.getList1().toString());
//        testC.print();


        final Thread thread1 =new Thread(){
            @Override
            public void run(){
                try {
                    testC.getList();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        final Thread thread2 =new Thread(){
            @Override
            public void run(){
                try {
                    testC.getList1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread1.start();
        thread2.start();
    }
}



