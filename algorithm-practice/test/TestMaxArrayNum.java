package test;


import com.yocan.algorithm.practice.MaxArrayNum;
import org.junit.Test;
import org.springframework.util.Assert;

public class TestMaxArrayNum {

    MaxArrayNum maxArrayNum =new MaxArrayNum();

    /**
     * 全负数数组
     * 结果为最大负数
     */
    @Test
    public void test1(){
        int[] nums ={-1,-2,-3,-5};
        Assert.isTrue(maxArrayNum.maxSubArray(nums)==-1,"测试用例不通过");
    }


    /**
     * 全正数数组
     * 结果为和
     */
    @Test
    public void test2(){
        int[] nums ={1,2,3,5};
        Assert.isTrue(maxArrayNum.maxSubArray(nums)==11,"测试用例不通过");
    }

    /**
     * 一正一负
     * 结果为正数
     */
    @Test
    public void test3(){
        int[] nums ={1,-2};
        Assert.isTrue(maxArrayNum.maxSubArray(nums)==1,"测试用例不通过");
    }/**
     * 夹带负数的情况
     *
     */
    @Test
    public void test4(){
        int[] nums ={4,-2,3,-5};
        Assert.isTrue(maxArrayNum.maxSubArray(nums)==5,"测试用例不通过");
    }/**
     * 夹带负数的情况
     *
     */
    @Test
    public void test5(){
        int[] nums ={4,-2,3,5};
        Assert.isTrue(maxArrayNum.maxSubArray(nums)==10,"测试用例不通过");
    }
}
