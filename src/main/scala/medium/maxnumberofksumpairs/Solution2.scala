package com.soumen.leetcodesolutions
package medium.maxnumberofksumpairs

/**
 * https://leetcode.com/problems/max-number-of-k-sum-pairs/
 * 1679. Max Number of K-Sum Pairs
 * */
object Solution2 extends App {
  @scala.annotation.tailrec
  def maxOperations(nums: Array[Int], k: Int, pos: Int = 0, m: Map[Int, Int] = Map.empty, count: Int = 0): Int = if (pos >= nums.length) count else nums(pos) match {
    case n => m get (k - n) match {
      case None => maxOperations(nums, k, pos + 1, m + (n -> (m.getOrElse(n, 0) + 1)), count)
      case Some(1) => maxOperations(nums, k, pos + 1, m - (k - n), count + 1)
      case Some(o) => maxOperations(nums, k, pos + 1, m + ((k - n) -> (o - 1)), count + 1)
    }
  }

  println(maxOperations(Array(2, 5, 4, 4, 1, 3, 4, 4, 1, 4, 4, 1, 2, 1, 2, 2, 3, 2, 4, 2), 3))
}
//Runtime: 2344 ms, faster than 100.00% of Scala online submissions for Max Number of K-Sum Pairs.
//Memory Usage: 141.3 MB, less than 100.00% of Scala online submissions for Max Number of K-Sum Pairs.