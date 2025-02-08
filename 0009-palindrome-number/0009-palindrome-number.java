class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers and numbers ending with 0 (except 0 itself) are not palindromes
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;

        int reversedHalf = 0;
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }

        // Check if the first half matches the second half (ignoring the middle digit for odd-length numbers)
        return x == reversedHalf || x == reversedHalf / 10;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isPalindrome(121));  // true
        System.out.println(sol.isPalindrome(-121)); // false
        System.out.println(sol.isPalindrome(10));   // false
    }
}
