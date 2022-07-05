package com.soumen.leetcodesolutions
package medium.longestconsecutivesequence

/**
 * <a href="https://leetcode.com/problems/longest-consecutive-sequence/">
 * 128. Longest Consecutive Sequence
 * </a>
 * */
object LongestConsecutiveSequence extends App {
  def longestConsecutive(nums: Array[Int]): Int = {
    val set = Set.from(nums)

    @scala.annotation.tailrec
    def longest(n: Int, count: Int = 1): Int = if (set.contains(n - 1)) longest(n - 1, count + 1) else count

    nums.foldLeft(0)((max, n) => max max longest(n))
  }

  println(longestConsecutive(Array(100, 4, 200, 1, 3, 2))) //4
  println(longestConsecutive(Array(0, 3, 7, 2, 5, 8, 4, 6, 0, 1))) //9
  println(longestConsecutive(Array())) //0
}
//Memory Limit Exceeded