package com.soumen.leetcodesolutions
package simple.runningsumof1darray

/**
 * <a href="https://leetcode.com/problems/running-sum-of-1d-array/">
 * 1480. Running Sum of 1d Array
 * </a>
 * */
object RunningSumOf1dArray3 extends App {
  def runningSum(nums: Array[Int]): Array[Int] = nums.tail.scanLeft(nums.head)(_ + _)

  println(runningSum(Array(1, 2, 3, 4)).toSeq)
  println(runningSum(Array(1, 1, 1, 1, 1)).toSeq)
  println(runningSum(Array(3, 1, 2, 10, 1)).toSeq)
}
//Runtime: 847 ms, faster than 28.57% of Scala online submissions for Running Sum of 1d Array.
//Memory Usage: 68.2 MB, less than 38.10% of Scala online submissions for Running Sum of 1d Array.