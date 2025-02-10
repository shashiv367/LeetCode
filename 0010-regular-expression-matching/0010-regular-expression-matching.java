class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[] dp = new boolean[n + 1];
        
        // Base case: empty string and empty pattern match
        dp[0] = true;

        // Handle patterns with '*' (matching empty string)
        for (int j = 2; j <= n; j += 2) {
            if (p.charAt(j - 1) == '*') {
                dp[j] = dp[j - 2];
            }
        }

        for (int i = 1; i <= m; i++) {
            boolean prev = dp[0];  // Store previous row's dp[j-1]
            dp[0] = false;
            for (int j = 1; j <= n; j++) {
                boolean temp = dp[j];  // Store current value before update
                char sc = s.charAt(i - 1), pc = p.charAt(j - 1);

                if (pc == sc || pc == '.') {  // Direct match
                    dp[j] = prev;
                } else if (pc == '*') {  // Handle '*'
                    char preceding = p.charAt(j - 2);
                    dp[j] = dp[j - 2] || ((preceding == '.' || preceding == sc) && dp[j]);
                } else {
                    dp[j] = false;
                }

                prev = temp;  // Update previous for next iteration
            }
        }

        return dp[n];
    }
}