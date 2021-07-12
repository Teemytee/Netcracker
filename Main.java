import palindrome.PalindromeChecker;

public class Main {

    public static void main(String[] args) {
        PalindromeChecker palindromeChecker = new PalindromeChecker();
        System.out.println(palindromeChecker.isPalindrome(100));
        System.out.println(palindromeChecker.isPalindrome(-78987));
    }
}
