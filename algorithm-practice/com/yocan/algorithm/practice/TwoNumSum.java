package com.yocan.algorithm.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuyongkang
 */
public class TwoNumSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> temp =new HashMap<>(nums.length);
        for (int i=0;i<nums.length;i++){
            if (temp.containsKey(target-nums[i])){
                return new int[]{temp.get(target-nums[i]),i};
            }
            temp.put(nums[i],i);
        }
        return new int[]{};
    }
}
