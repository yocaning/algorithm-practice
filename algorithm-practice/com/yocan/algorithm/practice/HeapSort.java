package com.yocan.algorithm.practice;

import java.util.Arrays;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 示例 1:
 *      输入: [3,2,1,5,6,4] 和 k = 2
 *      输出: 5
 * 示例 2:
 *      输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 *      输出: 4
 * 说明:
 *      你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 *      Related Topics 堆 分治算法
 *      堆排序是一种选择排序，它的最坏，最好，平均时间复杂度均为O(nlogn)
 */
public class HeapSort {

    public static void main(String[] args) {
        //个人测试
        int[] ints ={3,6,8,10,11,7,4};
        //构造堆
        buildHeap(ints,ints.length);
        System.out.println(Arrays.toString(ints));

        /**
         *  执行测试用例
         * 示例 1:
         *  *      输入: [3,2,1,5,6,4] 和 k = 2
         *  *      输出: 5
         */
        int[] ints1 ={3,2,1,5,6,4};
        buildHeap(ints1,ints1.length);
        System.out.println("输入: [3,2,1,5,6,4] 和 k = 2");
        System.out.println("期望输出: 5");
        System.out.println("实际输出"+ints1[1]);
        /**
         *  示例 2:
         *  *      输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
         *  *      输出: 4
         */
        int[] ints2 ={3,2,3,1,2,4,5,5,6};
        buildHeap(ints2,ints2.length);
        System.out.println("输入: [3,2,3,1,2,4,5,5,6] 和 k = 4");
        System.out.println("期望输出: 4");
        System.out.println("实际输出"+ints2[3]);
    }
    /**
     * 此处构建小顶堆
     * @param ints 需排序数组
     * @param length  一个多大堆
     */
    private static void buildHeap(int[] ints,int length){
        // 构建堆从leng/2-1开始
        for (int i=(length/2-1);i>=0;i--){
                adjustHeap(ints,i,length);
        }
        //将头尾交换，然后重新构造一个新的堆，长度减一
        //构建新的数组，降序
        while (length>0){
            swapArray(ints,0,length-1);
            adjustHeap(ints,0,--length);
        }
    }

    /**
     * 调整固定节点-堆
     * @param ints
     * @param i
     * @param length
     */
    private static void adjustHeap(int[] ints,int i,int length){
        //获取左右节点 下标
            int left =i *2+1;
            int right =i *2+2;
            if (left <length &&ints[i] >ints[left]){
                swapArray(ints,i,left);
                //交换之后再调整一次，避免交换的不是合适的。
                adjustHeap(ints,left,length);
            }
            if (right <length && ints[i] >ints[right]){
                swapArray(ints,i,right);
                //交换之后再调整一次，避免交换的不是合适的。
                adjustHeap(ints,right,length);
            }
    }

    /**
     * 交换
     * @param ints
     * @param from
     * @param to
     */
    private static void swapArray(int[] ints,int from,int to){
            int  temp =ints[from];
            ints[from] = ints[to];
            ints[to] =temp;
    }
}
