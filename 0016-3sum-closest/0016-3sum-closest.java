import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums); // Sort the array to use the two-pointer approach
        int closestSum = nums[0] + nums[1] + nums[2]; // Initialize with first three elements
        
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                // If exact target is found, return immediately
                if (sum == target) return sum;
                
                // Update closest sum if the new sum is closer to target
                if (Math.abs(target - sum) < Math.abs(target - closestSum)) {
                    closestSum = sum;
                }
                
                // Move pointers based on sum comparison
                if (sum < target) {
                    left++;  // Increase sum
                } else {
                    right--; // Decrease sum
                }
            }
        }
        
        return closestSum; // Return the closest sum found
    }
}
