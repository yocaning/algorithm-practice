package com.yocan.tencent.interview;

import java.util.HashMap;
import java.util.Map;

public class Test {
        public static void main(String[] args) {
            //期望输出99
            int[] arr ={3,1,1,1,3,3,99};
            Map<Integer,Integer> map =new HashMap(8);
            for(int num :arr){
                Integer integer =1;
                if(map.containsKey(num)){
                    integer =map.get(num);
                    map.put(num,++integer);
                }else {
                    map.put(num,integer);
                }

            }
            for(int num :arr){
                int size =map.get(num);
                if(size ==1){
                    System.out.println(num);

                }
            }
        }
}
