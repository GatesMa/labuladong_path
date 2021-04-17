// 暴力递归，超时
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        else if (amount < 0) return -1;

        int res = Integer.MAX_VALUE;
        for (int i = 0;i < coins.length;i++) {
            int sub = coinChange(coins, amount - coins[i]);
            if (sub != -1) res = Math.min(res, sub + 1);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}  


// 备忘录递归
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount < 0) return -1;
        int[] memo = new int[amount+1];
        return helper(coins, amount, memo);
    }
    public int helper(int[] coins, int amount, int[] memo) {
        if (amount == 0) return 0;
        else if (amount < 0) return -1;
        if (memo[amount] != 0) return memo[amount];

        int res = Integer.MAX_VALUE;
        for (int i = 0;i < coins.length;i++) {
            int sub = helper(coins, amount - coins[i], memo);
            if (sub != -1) res = Math.min(res, sub + 1);
        }
        memo[amount] = res == Integer.MAX_VALUE ? -1 : res;
        return memo[amount];
    }
}

// 迭代
class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount < 0) return -1;
        else if (amount == 0) return 0;

        int[] dp = new int[amount + 1];
        for (int i = 0;i < amount + 1;i++) {
            dp[i] = amount + 1;
        }
        dp[0] = 0;
        for (int i = 0;i <= amount;i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
