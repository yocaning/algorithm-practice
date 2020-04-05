package com.yocan.algorithm.practice;

/**
 * @author liuyongkang
 * @desc 单链表反转
 */
public class ReverseLinked {


    /**
     * 反转方法
     * 使用最常规方法
     * @param linked
     * @return
     */
    private static ListNode Reverse(ListNode linked){
        if (linked.next == null){
            return linked;
        }
        ListNode returnLinked =new ListNode(-1);
        ListNode p =linked;
        while (p !=null){
            ListNode temp =p.next;
            p.next=returnLinked.next;
            returnLinked.next=p;
            p=temp;
        }
        return returnLinked.next;
    }


    public static void main(String[] args) {
        ListNode linked1 =new ListNode(1);
        ListNode linked2 =new ListNode(2);
        ListNode linked3 =new ListNode(3);
        ListNode linked4 =new ListNode(4);
        ListNode linked5 =new ListNode(5);
        linked1.next=linked2;
        linked2.next=linked3;
        linked3.next=linked4;
        linked4.next=linked5;
        System.out.println(linked1.value);
        System.out.println(linked1.next.value);
        System.out.println(linked1.next.next.value);
        System.out.println(linked1.next.next.next.value);
        System.out.println(linked1.next.next.next.next.value);

        System.out.println(linked1.toString());
        ListNode reverse =Reverse(linked1);
        System.out.println(reverse.toString());

    }


    /**
     * 先构造一个链表架构
     */
    public static class ListNode {
        private Integer value;
        private ListNode next;

        public ListNode(Integer value) {
            this.value = value;
            this.next=null;
        }

        public ListNode(Integer value, ListNode next) {
            this.value = value;
            this.next = next;
        }

        public ListNode() {
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }

        @Override
        public String toString(){
            StringBuilder stringBuilder =new StringBuilder();
            stringBuilder.append(this.value);
            ListNode temp =this.next;
            while(temp !=null){
                stringBuilder.append(temp.value);
                temp =temp.next;
            }
            return new String(stringBuilder);
        }

    }
}
