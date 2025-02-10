class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        // Base case: empty string and empty pattern match
        dp[0][0] = true;

        // Handle patterns with '*' (matching empty string)
        for (int j = 2; j <= n; j += 2) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        // Fill DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1), pc = p.charAt(j - 1);

                if (pc == sc || pc == '.') { // Direct match
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') { // Handle '*'
                    char preceding = p.charAt(j - 2);
                    dp[i][j] = dp[i][j - 2] || ((preceding == '.' || preceding == sc) && dp[i - 1][j]);
                }
            }
        }

        return dp[m][n];
    }
}