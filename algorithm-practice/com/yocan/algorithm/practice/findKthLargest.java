package com.yocan.algorithm.practice;

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
 */
public class findKthLargest {
    /**
     * 排序后取值
     * 1.选用快排
     * @param nums
     * @param k
     * @return
     */
    private static int findKthLargest(int[] nums, int k) {
        int size =nums.length;
        if (k>size || k<0){
            return -1;
        }
        quickSort(nums,0,size-1);
        return nums[size-k];
    }

    private static void quickSort(int[] nums, int left, int right){
        if ( left >=right){
            return;
        }
        int l =left;
        int r =right;
        int temp =nums[left];
        while (left < right){
            while (left < right && nums[right] >= temp){
                right--;
            }
            nums[left] =nums[right];
            while (left < right && nums[left] <temp){
                left++;
            }
            nums[right] =nums[left];
        }
        nums[left] =temp;
        quickSort(nums, l, left);
        quickSort(nums, right+1, r);
    }

    public static void main(String[] args) {
        int[] ints = {5,6,7,8,4,2,3};
        System.out.println(findKthLargest(ints,-1));
        /**
         *  示例 1:
         *       输入: [3,2,1,5,6,4] 和 k = 2
         *      输出: 5
         */
        int[] ints1 = {3,2,1,5,6,4};
        System.out.println(findKthLargest(ints1,2));
        /**
         * 示例 2:
         *      输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
         *     输出: 4
         */
        int[] ints2 = {3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(ints2,4));

    }
}
