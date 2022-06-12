package com.soumen.leetcodesolutions
package medium.maximumerasurevalue

/**
 * <a href="https://leetcode.com/problems/maximum-erasure-value/">
 * 1695. Maximum Erasure Value
 * </a>
 * */
object MaximumErasureValue extends App {
  def maximumUniqueSubarray(nums: Array[Int]): Int = {
    @scala.annotation.tailrec
    def helper(i: Int = 0, l1: Int = 0, l2: Int = 0, runningSum: Int = 0, maxSum: Int = 0, m: Map[Int, Int] = Map.empty): Int =
      if (i == nums.length) maxSum
      else if (l1 < l2) helper(i, l1 + 1, l2, runningSum - nums(l1), maxSum, m - nums(l1))
      else m get nums(i) match {
        case None => helper(i + 1, l1, l2, runningSum + nums(i), maxSum max (runningSum + nums(i)), m + (nums(i) -> i))
        case Some(l) => helper(i, l1, l + 1, runningSum, maxSum, m)
      }

    helper()
  }


  println(maximumUniqueSubarray(Array(4, 2, 4, 5, 6)))
  println(maximumUniqueSubarray(Array(1, 2, 3, 4, 2, 3, 4, 1, 10)))
  println(maximumUniqueSubarray(Array(5, 2, 1, 2, 5, 2, 1, 2, 5)))
  //16911
  println(maximumUniqueSubarray(Array(187, 470, 25, 436, 538, 809, 441, 167, 477, 110, 275, 133, 666, 345, 411, 459, 490, 266, 987, 965, 429, 166, 809, 340, 467, 318, 125, 165, 809, 610, 31, 585, 970, 306, 42, 189, 169, 743, 78, 810, 70, 382, 367, 490, 787, 670, 476, 278, 775, 673, 299, 19, 893, 817, 971, 458, 409, 886, 434)))
}
//Runtime: 2163 ms, faster than 100.00% of Scala online submissions for Maximum Erasure Value.
//Memory Usage: 318.9 MB, less than 100.00% of Scala online submissions for Maximum Erasure Value.