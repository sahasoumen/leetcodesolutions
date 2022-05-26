package com.soumen.leetcodesolutions.hard.russiandollenvelopes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href = "https://leetcode.com/problems/russian-doll-envelopes/submissions/">
 * 354. Russian Doll Envelopes
 * </a>
 */
public class RussianDollEnvelopes3 {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (e1, e2) -> (e1[0] == e2[0]) ? e2[1] - e1[1] : e1[0] - e2[0]);

        List<Integer> l = new ArrayList<>();
        l.add(envelopes[0][1]);
        for (int i = 1; i < envelopes.length; i++) {
            if (envelopes[i][1] > l.get(l.size() - 1))
                l.add(envelopes[i][1]);
            else
                l.set(bisearch(l, envelopes, i), envelopes[i][1]);
        }
        return l.size();
    }

    public int bisearch(List<Integer> l, int[][] envelopes, int i) {
        int left = 0;
        int right = l.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (envelopes[i][1] > l.get(mid))
                left = mid + 1;
            else
                right = mid - 1;
        }
        return left == envelopes.length ? envelopes.length - 1 : left;
    }
}
