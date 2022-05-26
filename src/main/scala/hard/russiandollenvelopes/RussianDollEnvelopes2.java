package com.soumen.leetcodesolutions.hard.russiandollenvelopes;

import java.util.Arrays;

/**
 * <a href = "https://leetcode.com/problems/russian-doll-envelopes/submissions/">
 * 354. Russian Doll Envelopes
 * </a>
 */
public class RussianDollEnvelopes2 {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (e1, e2) -> e1[0] == e2[0] ? e2[1] - e1[1] : e1[0] - e2[0]);
        int max = 1;
        int[] dp = new int[envelopes.length + 1];
        Arrays.fill(dp, 1);
        for (int i = 0; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][1] > envelopes[j][1] && dp[i] <= dp[j]) {
                    dp[i]++;
                    max = Math.max(dp[i], max);
                }
            }
        }
        return max;
    }

}
//Runtime: 93 ms, faster than 22.55% of Java online submissions for Russian Doll Envelopes.
//Memory Usage: 79.9 MB, less than 72.60% of Java online submissions for Russian Doll Envelopes.