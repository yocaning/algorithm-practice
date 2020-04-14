package com.yocan.algorithm.practice;

import java.util.Arrays;

/**
 * 归并排序
 * 递归法
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] ints = new int[]{2, 5, 6, 3,7,10,1};
        int[] int1 = new int[]{2, 5, 6, 3,3};
        int[] int2 = new int[]{2, 5, 6, 3,4};
        int[] int3 = new int[]{1,2, 5, 6, 3};
        int[] int4 = new int[]{2, 4,5, 6, 3};
        int[] int5 = new int[]{2,3,4, 5, 6, 3};
        test(ints);
        test(int1);
        test(int2);
        test(int3);
        test(int4);
        test(int5);


    }

    public static void test(int[] testInts) {
        int[] assertInts = Arrays.copyOf(testInts, testInts.length);
        int[] temp = new int[testInts.length];
        //自己测试
        mergeSort(testInts, temp, 0, testInts.length - 1);
        Arrays.sort(assertInts);
        System.out.println(Arrays.toString(assertInts));
        System.out.println(Arrays.toString(temp));
        assert Arrays.equals(temp, assertInts) : "不是正确的输出结果";
    }


    /**
     * @param arr   原始数组，需要排序的数组
     * @param temp  临时数组，用于存放排序结果
     * @param left  左指针
     * @param right 右指针
     */
    private static void mergeSort(int[] arr, int[] temp, int left, int right) {
        //判断临界条件，退出本轮递归
        if (left >= right) return;
        //先二分切分原数组
        //获取到mid值
        int length = right - left;
        int mid = length / 2 + left;
        int start = left;
        int end = right;

        mergeSort(arr, temp, left, mid);
        mergeSort(arr, temp, mid + 1, right);
        //合并切分数组
        int k = left;
        int j = mid + 1;
        while (left <= mid && j <= right) {
            temp[k++] = arr[left] > arr[j] ? arr[j++] : arr[left++];
        }
        while (left <= mid) {
            temp[k++] = arr[left++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        //需要加一步拷贝回原数组，才能避免逻辑混乱
        for (k = start; k <= end; k++) {
            arr[k] = temp[k];
        }

    }
}
