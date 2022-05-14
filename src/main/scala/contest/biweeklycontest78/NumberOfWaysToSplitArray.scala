package com.soumen.leetcodesolutions
package contest.biweeklycontest78

object NumberOfWaysToSplitArray extends App {
  def waysToSplitArray(nums: Array[Int]): Int = (0 until nums.length - 1).count(i => (0 to i).map(nums(_)).sum >= (i + 1 until nums.length).map(nums(_)).sum)

  println(waysToSplitArray(Array(10, 4, -8, 7)))
  println(waysToSplitArray(Array(2, 3, 1, 0)))
}
