package com.soumen.leetcodesolutions
package simple.runningsumof1darray

/**
 * <a href="https://leetcode.com/problems/running-sum-of-1d-array/">
 * 1480. Running Sum of 1d Array
 * </a>
 * */
object RunningSumOf1dArray5 extends App {
  def runningSum(nums: Array[Int]): Array[Int] = {
    for (i <- 1 until nums.length) nums(i) += nums(i - 1)
    nums
  }

  println(runningSum(Array(1, 2, 3, 4)).toSeq)
  println(runningSum(Array(1, 1, 1, 1, 1)).toSeq)
  println(runningSum(Array(3, 1, 2, 10, 1)).toSeq)
}
//Runtime: 829 ms, faster than 42.86% of Scala online submissions for Running Sum of 1d Array.
//Memory Usage: 68.4 MB, less than 23.81% of Scala online submissions for Running Sum of 1d Array.