package com.soumen.leetcodesolutions
package simple.runningsumof1darray

/**
 * <a href="https://leetcode.com/problems/running-sum-of-1d-array/">
 * 1480. Running Sum of 1d Array
 * </a>
 * */
object RunningSumOf1dArray extends App {
  def runningSum(nums: Array[Int]): Array[Int] = nums.foldLeft(Array.ofDim[Int](nums.length) -> 0) {
    case ((arr, i), n) => arr(i) = if (i == 0) n else arr(i - 1) + n
      arr -> (i + 1)
  }._1

  println(runningSum(Array(1, 2, 3, 4)).toSeq)
  println(runningSum(Array(1, 1, 1, 1, 1)).toSeq)
  println(runningSum(Array(3, 1, 2, 10, 1)).toSeq)
}
//Runtime: 819 ms, faster than 42.86% of Scala online submissions for Running Sum of 1d Array.
//Memory Usage: 68.3 MB, less than 23.81% of Scala online submissions for Running Sum of 1d Array.