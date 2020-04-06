package com.yocan.algorithm.practice;

/**
 * @author liuyongkang
 * 如何判断一个链表是否有环
 * 思路：追赶法
 */
public class IsCircleLinked {


    private static boolean isCircle(ReverseLinked.ListNode listNode) {
        boolean flag = false;
        ReverseLinked.ListNode listNode1 = listNode;
        ReverseLinked.ListNode listNode2 = listNode;
        while (!flag) {
            if (listNode2 == null || listNode1 == null) {
                break;
            }
            try {
                listNode1 = listNode1.getNext();
                listNode2 = listNode2.getNext().getNext();
            } catch (NullPointerException e) {
                System.out.println(e);
                break;
            }
            if (listNode1 == listNode2) {
                flag = true;
            }
        }
        return flag;
    }


    public static void main(String[] args) {
        //构造一个有环链表
        ReverseLinked.ListNode listNode1 = new ReverseLinked.ListNode(1);
        ReverseLinked.ListNode listNode2 = new ReverseLinked.ListNode(2);
        ReverseLinked.ListNode listNode3 = new ReverseLinked.ListNode(3);
        ReverseLinked.ListNode listNode4 = new ReverseLinked.ListNode(4);
        ReverseLinked.ListNode listNode5 = new ReverseLinked.ListNode(5);
        ReverseLinked.ListNode listNode6 = new ReverseLinked.ListNode(6);
        ReverseLinked.ListNode listNode10 = new ReverseLinked.ListNode(10);
        ReverseLinked.ListNode listNode11 = new ReverseLinked.ListNode(11);
        ReverseLinked.ListNode listNode12 = new ReverseLinked.ListNode(12);
        listNode1.setNext(listNode2);
        listNode2.setNext(listNode3);
        listNode3.setNext(listNode4);
        listNode4.setNext(listNode5);
        listNode5.setNext(listNode6);
        listNode6.setNext(listNode1);

        //构造一个单向链表
        listNode10.setNext(listNode11);
        listNode11.setNext(listNode12);
        System.out.println(listNode10);


        System.out.println(isCircle(listNode1));
        System.out.println(isCircle(listNode10));
    }
}
