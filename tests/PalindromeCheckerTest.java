package tests;

import org.junit.Assert;
import org.junit.Test;
import palindrome.PalindromeChecker;

public class PalindromeCheckerTest {
    @Test
    public void palindromeTestWithNegativeNumbers(){
        PalindromeChecker palindromeChecker = new PalindromeChecker();
        boolean result = palindromeChecker.isPalindrome(-121);
        Assert.assertTrue("True", result);
    }

    @Test
    public void palindromeTestWithPositiveNumbers(){
        PalindromeChecker palindromeChecker = new PalindromeChecker();
        boolean result = palindromeChecker.isPalindrome(555);
        Assert.assertTrue("True", result);
    }

    @Test
    public void palindromeTestWithNotPalindromeNumbers(){
        PalindromeChecker palindromeChecker = new PalindromeChecker();
        boolean result = palindromeChecker.isPalindrome(500);
        Assert.assertFalse("False", result);
    }

}
