package com.yocan.algorithm.practice;

import java.util.*;

/**
 * @author liuyongkang
 * 假设您是个土豪，身上带了足够的1、5、11元面值的钞票。现在您的目标是凑出某个金额w，需要用到尽量少的钞票。
 *
 * 在这个递归过程中你会出现很多重叠子问题，还需要一个数组来记录你已经递归过的结果，如果已经出现过直接return
 * 通过加入moneyMap来存储计算过程中产生的结果，能够极大的减少运算次数，避免因为递归数过多的重复运算
 */
public class DynamicProgramming {

    private static List<Integer> moneyArray =new ArrayList<Integer>(Arrays.asList(1,5,11,20,50,100));

    private static Map<Integer,Integer> moneyMap =new HashMap<Integer, Integer>();


    private static Integer moneyCount(int money){
        int count=money;
        if (money==0){
            return 0;
        }
        if (moneyMap.containsKey(money)){
            return moneyMap.get(money);
        }
        if (moneyArray.contains(money)){
            return 1;
        }
        if (money-100>=0){
            count=minNum(count,moneyCount(money-100)+1);
        }
        if (money-50>=0){
            count=minNum(count,moneyCount(money-50)+1);
        }
        if (money-20>=0){
            count=Math.min(count,moneyCount(money-20)+1);
        }
        if (money-11>=0){
            count=Math.min(count,moneyCount(money-11)+1);
        }
        if (money-5>=0){
            count=Math.min(count,moneyCount(money-5)+1);
        }
        if (money-1>=0){
            count =Math.min(count,moneyCount(money-1)+1);
        }
        moneyMap.put(money,count);
        return count;
    }

    private static int minNum(Integer a,Integer b){
         return Math.min(a,b);
    }


    public static void main(String[] args) {
        //期望值为3张5元，而不是11+4*1
        System.out.println(moneyCount(15));
        //期望值为2张
        System.out.println(moneyCount(111));
        //期望值为11张
        System.out.println(moneyCount(1050));
    }

}
