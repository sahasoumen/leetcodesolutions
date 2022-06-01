package com.soumen.leetcodesolutions
package simple.runningsumof1darray

/**
 * <a href="https://leetcode.com/problems/running-sum-of-1d-array/">
 * 1480. Running Sum of 1d Array
 * </a>
 * */
object RunningSumOf1dArray2 extends App {
  def runningSum(nums: Array[Int]): Array[Int] = {
    val arr = Array.ofDim[Int](nums.length)
    arr(0) = nums(0)
    nums.tail.foldLeft(arr -> 1) { case ((arr, i), n) => arr(i) = arr(i - 1) + n; arr -> (i + 1) }._1
  }

  println(runningSum(Array(1, 2, 3, 4)).toSeq)
  println(runningSum(Array(1, 1, 1, 1, 1)).toSeq)
  println(runningSum(Array(3, 1, 2, 10, 1)).toSeq)
}
//Runtime: 847 ms, faster than 28.57% of Scala online submissions for Running Sum of 1d Array.
//Memory Usage: 68.2 MB, less than 38.10% of Scala online submissions for Running Sum of 1d Array.