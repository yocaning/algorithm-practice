package com.yocan.algorithm.practice;

/**
 *  传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 *
 * 输入：weights = [1,2,3,4,5,6,7,8,9,10], D = 5
 * 输出：15
 * 解释：
 * 船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
 * 第 1 天：1, 2, 3, 4, 5
 * 第 2 天：6, 7
 * 第 3 天：8
 * 第 4 天：9
 * 第 5 天：10
 *  请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) 是不允许的。
 *
 * 输入：weights = [3,2,2,4,1,4], D = 3
 * 输出：6
 *
 *1 <= D <= weights.length <= 50000
 * 1 <= weights[i] <= 500
 *
 * 思路：二分法
 */
public class ShipWithinDaysSolution {

    public int shipWithinDays(int[] weights, int D) {
        //参数校验
        if (D >weights.length || D<1 || weights.length >50000 ){return 0;}
        int min;
        int sum=0;
        for (int i=0;i<weights.length;i++){
            if (weights[i]>500){return 0;}
            sum +=weights[i];
        }
        //初始值范围为 最小值：总数/天数，最大值：总和
        min=sum/D;
        int right =sum;
        //直到最小值=最大值时，就得出结果
        while (min<right){
            int mid =(min+right) >>>1;
            //如果满足要求，代表数字还有可以缩小的空间，于是将中数赋值给右边界
            //如果不满足要求，代表数字还太小，于是将中数赋值给左边界
            if (isOk(weights,mid,D)){
                right =mid;
            }else {
                min =mid+1;
            }
        }
        return min;
    }

    private boolean isOk(int[] weights,int num,int D){
        int start=0;
        int day=1;
        for (int i=0;i<weights.length;i++){
            //确保包裹的重量不会大于容量
            if (weights[i] >num){return false;}
            //如果相加的重量大于可用重量，则换到下一天
            if ((start +weights[i] )<=num){
                start +=weights[i];
            }else {
                //日期加一，开始值为当前便历的那个值
                day++;
                start=weights[i];
                //如果天数超过限制天数，直接返回错误
                if (day>D){
                    return false;
                }
            }
        }
        return true;
    }

}
