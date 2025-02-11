class Solution {
    public int xorOperation(int n, int start) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            result ^= start + 2 * i;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.xorOperation(5, 0)); // Output: 8
        System.out.println(sol.xorOperation(4, 3)); // Output: 8
    }
}