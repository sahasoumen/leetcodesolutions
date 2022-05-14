package com.soumen.leetcodesolutions
package contest.biweeklycontest78

/**
 * https://leetcode.com/submissions/detail/699495351/
 * 2270. Number of Ways to Split Array
 * */
object NumberOfWaysToSplitArray3 extends App {
  def waysToSplitArray(nums: Array[Int]): Int = {
    nums.init.foldLeft((0, nums.sum, 0)) { case ((pre, post, count), n) => (pre + n, post - n, if (pre + n >= post - n) count + 1 else count) }._3
  }

  println(waysToSplitArray(Array(10, 4, -8, 7)))
  println(waysToSplitArray(Array(2, 3, 1, 0)))
  println(waysToSplitArray(Array(0, 0)))
}
//Runtime: 1583 ms
//Memory Usage: 170 MB