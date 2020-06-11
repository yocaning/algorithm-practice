package com.yocan.algorithm.practice;

/**
 * @author liuyongkang
 * 根据每日 气温 列表，请重新生成一个列表，
 * 对应位置的输出是需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
 * 测试用例使用的是https://leetcode-cn.com/problems/daily-temperatures/submissions/
 */
public class DailyTemperaturesSolution {

    /**
     * 暴力法
     * 效率不高
     *  平均执行时间1503 ms
     * @param
     * @return
     */
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        for (int i = 0; i < T.length-1; i++) {
            int j = i;
            int temp = 1;
            while (temp < T.length - i) {
                if (T[i] < T[j + 1]) {
                    result[i] = temp;
                    break;
                } else {
                    temp++;
                    j++;
                }
            }
        }
        return result;
    }

    /**
     * 进阶
     * 优化一部分
     * 平均执行时间339 ms
     * @param T
     * @return
     */
    public int[] dailyTemperaturesApprove(int[] T) {
        int[] result = new int[T.length];
        for (int i = 0; i < T.length-1; i++) {
            int j = i;
            int temp = 1;
            //争取多用之前的结果
            if (i > 0) {
                if (result[i - 1] == 0 && T[i] >= T[i - 1]) {
                    continue;
                }
                if (T[i] < T[i - 1] && result[i - 1] != 0) {
                    while (temp < result[i - 1] + i) {
                        if (j >= result[i - 1] + i - 1) {
                            result[i] = result[i - 1];
                            break;
                        }
                        if (T[i] < T[j + 1]) {
                            result[i] = temp;
                            break;
                        } else {
                            temp++;
                            j++;
                        }
                    }
                    continue;
                }
                if (T[i] == T[i - 1]) {
                    result[i] = result[i - 1] - 1;
                    continue;
                }

            }
            while (temp < T.length - i) {
                if (T[i] < T[j + 1]) {
                    result[i] = temp;
                    break;
                } else {
                    temp++;
                    j++;
                }
            }
        }
        return result;
    }

    /**
     * 性能优化版
     * 倒过来就可以了，利用结果更多
     * 时间：4 ms
     * @param T
     * @return
     */
    public int[] dailyTemperaturesByDesc(int[] T){
        int[] result = new int[T.length];
        //最后一个数必为0，所以不用管
        for (int i=T.length-2;i>=0;i--){
            int temp = 1;
            while (true){
                int j=i+temp;
                if (T[i]<T[j]){
                    result[i]=temp;
                    break;
                }else if (result[j]==0){
                    break;
                }else {
                    temp +=result[j];
                }
            }
        }
        return result;
    }


}
