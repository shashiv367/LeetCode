class Solution {
    public int arraySign(int[] nums) {
        int negativeCount = 0;

        // Iterate over the array
        for (int num : nums) {
            if (num == 0) {
                return 0;  // If any number is 0, the product will be 0
            } else if (num < 0) {
                negativeCount++;  // Count negative numbers
            }
        }

        // If the count of negative numbers is even, return 1; if odd, return -1
        return (negativeCount % 2 == 0) ? 1 : -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        int[] nums1 = {-1, -2, -3, -4, 3, 2, 1};
        int[] nums2 = {1, 5, 0, 2, -3};
        int[] nums3 = {-1, 1, -1, 1, -1};

        
        System.out.println(solution.arraySign(nums1));  // Output: 1
        System.out.println(solution.arraySign(nums2));  // Output: 0
        System.out.println(solution.arraySign(nums3));  // Output: -1
    }
}