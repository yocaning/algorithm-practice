package com.yocan.algorithm.practice;

import java.util.Arrays;

/**
 *归并排序
 * 递归法
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] ints =new int[]{2,5,6,3,7,8,27};
        int[] assertInts=new int[]{2,5,6,3,7,8,17};
//        int[] assertInts =Arrays.copyOf(ints,ints.length);
        int[] temp =new int[ints.length];
        //自己测试
        int[] arr =mergeSort(ints,temp,0,ints.length-1);
        Arrays.sort(assertInts);



    }


    /**
     * @param arr 原始数组，需要排序的数组
     * @param temp 临时数组，用于存放排序结果
     * @param left 左指针
     * @param right 右指针
     */
    private static int[] mergeSort(int[] arr ,int[] temp ,int left ,int right){
        //判断临界条件，退出本轮递归
        if (left>=right)return null;
        //先二分切分原数组
        //获取到mid值
        int length =right-left;
        int mid =length/2+left;

        mergeSort(arr,temp,left,mid);
        mergeSort(arr,temp,mid+1,right);
        //合并切分数组
        int k=0;
        int j=mid+1;
        while(left <=mid && j<=right){
            temp[k++]=arr[left]>arr[mid+1]?arr[j++]:arr[left++];
        }
        while(left<=mid){
            temp[k++]=arr[left++];
        }
        while( j<=right){
            temp[k++]=arr[j++];
        }
        arr =Arrays.copyOf(temp,temp.length);
        return arr;


    }
}
