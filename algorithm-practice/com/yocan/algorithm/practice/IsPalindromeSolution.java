package com.yocan.algorithm.practice;

/**
 * @author liuyongkang
 */
public class IsPalindromeSolution {

    public boolean isPalindrome(int x) {
        if(x<0) { return false; }
        String newNum =Integer.toString(x);
        int length =newNum.length();
        for (int size=0;size<length;size++){
            if (newNum.charAt(size)!=newNum.charAt(length-size-1)){return false; }
        }
        return true;
    }

    /**
     * 进阶：不使用string
     * @param  x
     * @return boolean
     */
    public boolean isPalindromeWithoutString(int x) {
        // 边界情况：如果数字的最后一位是 0,为了使该数字为回文,则其第一位数字也应该是0，显然不存在,除了0
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber / 10;
    }
}
