package com.soumen.leetcodesolutions
package simple

/**
 * https://leetcode.com/problems/two-sum/
 */

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

  println(twoSumSorted(Array(2, 7, 11, 15), 9).toSeq)
  println(twoSumSorted(Array(3, 2, 4), 6).toSeq)
  println(twoSumSorted(Array(3, 3), 6).toSeq)
}

//Runtime: 796 ms, faster than 76.24% of Scala online submissions for Two Sum.
//Memory Usage: 53.8 MB, less than 89.83% of Scala online submissions for Two Sum.