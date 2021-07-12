package palindrome;

public class PalindromeChecker implements Palindrome{
    @Override
    public boolean isPalindrome(int x) {
        int input = Math.abs(x);
        int temp = input;
        int separate_digit, reversed = 0;
        while (input > 0){
            separate_digit = input % 10;
            reversed = (reversed * 10) + separate_digit;
            input = input / 10;
        }
        if(reversed == temp){
            return true;
        } else {
            return false;
        }
    }
}
