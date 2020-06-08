class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount]; 
    }
}
    
    
    
    /*
    //USING TOP DOWN DP
    private Integer[][] dp;
    
    public int change(int amount, int[] coins) {
        dp = new Integer[coins.length + 1][amount + 1];     //dp
        return recur(amount, coins, 0);     //recursive helper function
    }
    
    private int recur(int amount, int[] coins, int i) {
        if (amount < 0) 
            return 0;       //if amount is neg which means invalid change
        if (amount == 0) 
            return 1;       //if amt is zero i.e. we got perfect change
                            //increment number of ways
        
        if (dp[i][amount] != null) {
            return dp[i][amount];
        }
        
        if (i == coins.length && amount > 0) //coins over yet amount is not zero
            //(coins over means used all types of coins not number of coins exhausted)
            return 0;
        
        dp[i][amount] = recur(amount - coins[i], coins, i) + recur(amount, coins, i + 1);
                            // include + exclude
        return dp[i][amount];
    }*/
