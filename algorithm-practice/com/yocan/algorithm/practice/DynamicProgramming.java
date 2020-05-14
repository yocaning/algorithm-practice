package com.yocan.algorithm.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuyongkang
 * 假设您是个土豪，身上带了足够的1、5、11元面值的钞票。现在您的目标是凑出某个金额w，需要用到尽量少的钞票。
 *
 * 在这个递归过程中你会出现很多重叠子问题，还需要一个数组来记录你已经递归过的结果，如果已经出现过直接return
 */
public class DynamicProgramming {

    private static List<Integer> moneyArray =new ArrayList<Integer>(Arrays.asList(1,5,11,20,50,100));


    private static Integer moneyCount(int money){
        int count=money;
        if (money==0){
            return 0;
        }
        if (moneyArray.contains(money)){
            return 1;
        }
        count=minNum(count,
                moneyCount((money-100)>0?money-100:money)+1,
                moneyCount((money-50)>0?money-50:money)+1,
                moneyCount((money-20)>0?money-20:money)+1,
                moneyCount((money-11)>0?money-11:money)+1,
                moneyCount((money-5)>0?money-5:money)+1,
                moneyCount((money-1)>0?money-1:money)+1);

        return count;
    }

    private static int minNum(Integer a,Integer b,Integer c,Integer d,Integer e,Integer f,Integer g){
        int result =Math.min(a,b);
         result =Math.min(result,c);
         result =Math.min(result,d);
         result =Math.min(result,e);
         result =Math.min(result,f);
         return Math.min(result,g);
    }


    public static void main(String[] args) {
        System.out.println(moneyCount(100));
    }

}
