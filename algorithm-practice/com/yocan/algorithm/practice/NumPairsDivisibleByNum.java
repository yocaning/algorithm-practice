package com.yocan.algorithm.practice;




/**
 * 1.总持续时间可被 60 整除的歌曲
 * 在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。
 * 返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。形式上，我们希望索引的数字 i 和 j 满足  i < j 且有 (time[i] + time[j]) % 60 == 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pairs-of-songs-with-total-durations-divisible-by-60
 * <p>
 * 输入：[30,20,150,100,40]
 * 输出：3
 * 解释：这三对的总持续时间可被 60 整数：
 * (time[0] = 30, time[2] = 150): 总持续时间 180
 * (time[1] = 20, time[3] = 100): 总持续时间 120
 * (time[1] = 20, time[4] = 40): 总持续时间 60
 * <p>
 * 输入：[60,60,60]
 * 输出：3
 * 解释：所有三对的总持续时间都是 120，可以被 60 整数。
 */
public class NumPairsDivisibleByNum {

    //时间复杂度O(n2),超时不达标
    private int numPairsDivisibleBy60(int[] time) {
        if (time.length>60000 || time.length<1){
            return 0;
        }
        int count = 0;
        for (int i = 0; i < time.length; i++) {
            if (time[i]>500 || time[i] <1){return 0;}
            for (int j = i+1; j < time.length; j++) {
                if (time[j]>500 || time[j] <1){return 0;}
                if ((time[i] + time[j]) % 60 == 0) {
                    count++;
                }
            }
        }
        return count;
    }
    public int num2PairsDivisibleBy60(int[] time) {
        //保存余数出现的次数
        int[] record = new int[60];
        int count = 0;
        for(int t : time){
            //求这个时间的余数
            t %= 60;
            // 如果时间余数不为0，找出相加为0的余数总和相加
            if(t != 0)
                //这里相加有一个小细节是：直接加之前的次数，因为出现一次就代表  可以形成之前次数   的  对数
                //如之前余数为0的情况已经有3次，第四次出现余数为0的时候，可以与之前三次组成三对，所以是加之前次数。（类似于乘）
                count += record[60 - t];
            else count += record[t];        //如果为0，加其他为0的数
            record[t] ++;
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(new NumPairsDivisibleByNum().numPairsDivisibleBy60(new int[]{
                30,20,150,100,40}));
        System.out.println(new NumPairsDivisibleByNum().num2PairsDivisibleBy60(new int[]{
                30,20,150,100,40}));
    }
}
