package com.soumen.leetcodesolutions
package contest.biweeklycontest78

/**
 * https://leetcode.com/submissions/detail/699495351/
 * 2270. Number of Ways to Split Array
 * */
object NumberOfWaysToSplitArray2 extends App {
  def waysToSplitArray(nums: Array[Int]): Int = {
    @scala.annotation.tailrec
    def split(i: Int = 0, pre: Long = 0, post: Long = nums.foldLeft(0L)(_ + _), count: Int = 0): Int = if (i == nums.length - 1) count else
      split(i + 1, pre + nums(i), post - nums(i), if (pre + nums(i) >= post - nums(i)) count + 1 else count)

    split()
  }

  println(waysToSplitArray(Array(10, 4, -8, 7)))
  println(waysToSplitArray(Array(2, 3, 1, 0)))
  println(waysToSplitArray(Array(0, 0)))
}

//Runtime: 1004 ms
//Memory Usage: 76.5 MB