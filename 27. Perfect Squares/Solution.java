class Solution {
    public int numSquares(int n) {
       int[] dp = new int[n + 1];
        int near, min;
        for (int i = 1; i <= n; i++) {
            near = (int) Math.sqrt(i);    //find sqrt less than and nearest to i
            min = dp[i - 1];
            for (int j = near; j > 0; j--) {
                min = Math.min(dp[i - j * j], min);     //find diff
            }
            dp[i] = min + 1;
        }
    return dp[n];
    }
}
