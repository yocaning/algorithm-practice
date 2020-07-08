package test;

import com.yocan.algorithm.practice.TwoNumSum;
import com.yocan.tencent.discuss.SyncAndLock;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author liuyongkang
 */
public class TwoNumSumTest {

    private TwoNumSum twoNumSum =new TwoNumSum();

    @Test
    public void TwoNumSumTest1()  {
      int[] ints ={2,7,11,15};
      int target =9;
      int[] result =twoNumSum.twoSum(ints,target);
      Assert.assertArrayEquals(result,new  int[]{0,1});
    }

    @Test
    public void TwoNumSumTest2()  {
        int[] ints ={3,7,9,11,12,14};
        int target =17;
        int[] result =twoNumSum.twoSum(ints,target);
        Assert.assertArrayEquals(result,new  int[]{0,5});
    }

    @Test
    public void TwoNumSumTest3()  {
        int[] ints ={0,7,11,15};
        int target =9;
        int[] result =twoNumSum.twoSum(ints,target);
        Assert.assertArrayEquals(result,new  int[]{});
    }
}
