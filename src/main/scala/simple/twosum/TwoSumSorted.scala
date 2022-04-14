package com.soumen.leetcodesolutions
package simple.twosum

/**
 * https://leetcode.com/problems/two-sum/
 * 1. Two Sum
 * */

/** Complexity O(n log(n) + n) */
object TwoSumSorted extends App {


  def twoSumSorted(nums: Array[Int], target: Int): Array[Int] = {
    @scala.annotation.tailrec
    def twoSumSortedHelper(nums: Seq[(Int, Int)], target: Int): Seq[Int] = nums match {
      case (n1, i1) :: tail => val total = n1 + tail.last._1 - target
        if (total == 0) Seq(i1, tail.last._2)
        else if (total > 0) twoSumSortedHelper((n1, i1) +: tail.init, target)
        else twoSumSortedHelper(tail, target)
    }

    twoSumSortedHelper(nums.toList.zipWithIndex.sortBy(_._1), target).toArray
  }
}
