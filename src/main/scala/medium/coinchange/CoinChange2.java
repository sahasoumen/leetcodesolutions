package com.soumen.leetcodesolutions.medium.coinchange;

import java.util.Arrays;

public class CoinChange2 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i <= amount; i++)
            for (int j : coins)
                if (j <= i && dp[i - j] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i - j] + 1, dp[i]);
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        CoinChange2 c = new CoinChange2();
        System.out.println(c.coinChange(new int[]{1, 2, 5}, 11));
    }
}
//Runtime: 25 ms, faster than 55.57% of Java online submissions for Coin Change.
//Memory Usage: 44.9 MB, less than 57.32% of Java online submissions for Coin Change.