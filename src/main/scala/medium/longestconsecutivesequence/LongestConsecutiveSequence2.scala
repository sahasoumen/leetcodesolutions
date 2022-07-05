package com.soumen.leetcodesolutions
package medium.longestconsecutivesequence

/**
 * <a href="https://leetcode.com/problems/longest-consecutive-sequence/">
 * 128. Longest Consecutive Sequence
 * </a>
 * */
object LongestConsecutiveSequence2 extends App {
  def longestConsecutive(nums: Array[Int]): Int = {
    val map = scala.collection.mutable.Map.from(nums.map(_ -> 1))

    def longest(n: Int): Int = map get n match {
      case None => 0
      case Some(1) => map += n -> (1 + longest(n - 1))
        map(n)
      case Some(v) => v
    }

    nums.foldLeft(0)((max, n) => max max longest(n))
  }

  println(longestConsecutive(Array(100, 4, 200, 1, 3, 2))) //4
  println(longestConsecutive(Array(0, 3, 7, 2, 5, 8, 4, 6, 0, 1))) //9
  println(longestConsecutive(Array())) //0
}
//Runtime: 1503 ms, faster than 48.57% of Scala online submissions for Longest Consecutive Sequence.
//Memory Usage: 105.3 MB, less than 42.86% of Scala online submissions for Longest Consecutive Sequence.