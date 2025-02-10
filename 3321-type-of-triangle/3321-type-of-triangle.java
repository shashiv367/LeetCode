class Solution {
    public String triangleType(int[] nums) {
        int x = nums[0], y = nums[1], z = nums[2];
        if (x + y <= z || y + z <= x || z + x <= y) {
            return "none";
        }

        if (x == y && y == z) {
            return "equilateral";
        } else if (x == y || y == z || z == x) {
            return "isosceles";
        } else {
            return "scalene";
        }
    }
}