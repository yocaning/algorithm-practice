package com.yocan.algorithm.practice;

/**
 * @author liuyongkang
 * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 */
public class MaxArrayNum {



    public  int maxSubArray(int[] nums) {
        if(nums.length<1 ||nums.length>((int)Math.pow(10,5))){return 0;}
        int sum=0;
        int result=nums[0];
        for (int i =0;i<nums.length;i++){
            sum = (sum>0)?nums[i]+sum:nums[i];
            result =Math.max(result,sum);
        }
        return result;
    }

}
