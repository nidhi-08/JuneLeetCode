class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[2][n + 1];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 || j == 0)
                    dp[i % 2][j] = 1;
                else dp[i % 2][j] = dp[(i - 1) % 2][j] + dp[i % 2][j - 1];
            }
        }
        
        return dp[(m - 1) % 2][n - 1];
    }
}
