package test;

import com.yocan.algorithm.practice.IsPalindromeSolution;
import org.junit.Test;
import org.springframework.util.Assert;

/**
 * @author liuyongkang
 */
public class IsPalindromeTest {

    private IsPalindromeSolution isPalindromeSolution =new IsPalindromeSolution();

    /**
     * 测试100
     */
    @Test
    public void test100(){
        Assert.isTrue(!isPalindromeSolution.isPalindrome(100),"测试用例不通过");
    }

    /**
     * 测试2121
     */
    @Test
    public void test2121(){
        Assert.isTrue(!isPalindromeSolution.isPalindrome(2121),"测试用例不通过");
    }
    /**
     * 测试111
     */
    @Test
    public void test111(){
        Assert.isTrue(isPalindromeSolution.isPalindrome(111),"测试用例不通过");
    }
    /**
     * 测试个位数1
     */
    @Test
    public void test1(){
        Assert.isTrue(isPalindromeSolution.isPalindrome(1),"测试用例不通过");
    }

    /**
     * 测试负数1
     */
    @Test
    public void testF1(){
        Assert.isTrue(!isPalindromeSolution.isPalindrome(-1),"测试用例不通过");
    }

    /**
     * 测试负数1
     */
    @Test
    public void testWithoutStringF1(){
        Assert.isTrue(!isPalindromeSolution.isPalindromeWithoutString(-1),"测试用例不通过");
    }

    /**
     * 测试100
     */
    @Test
    public void testWithoutString100(){
        Assert.isTrue(!isPalindromeSolution.isPalindromeWithoutString(100),"测试用例不通过");
    }

    /**
     * 测试121
     */
    @Test
    public void testWithoutString121(){
        Assert.isTrue(isPalindromeSolution.isPalindromeWithoutString(121),"测试用例不通过");
    }

    /**
     * 测试100868001
     */
    @Test
    public void testWithoutString100868001(){
        Assert.isTrue(isPalindromeSolution.isPalindromeWithoutString(100868001),"测试用例不通过");
    }

    /**
     * 测试100868001
     */
    @Test
    public void test100868001(){
        Assert.isTrue(isPalindromeSolution.isPalindrome(100868001),"测试用例不通过");
    }
}
