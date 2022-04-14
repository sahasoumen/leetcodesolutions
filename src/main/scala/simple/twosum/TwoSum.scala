package com.soumen.leetcodesolutions
package simple.twosum

/**
 * https://leetcode.com/problems/two-sum/
 * 1. Two Sum
 * */

/** Complexity O(n&#94;2) */
object TwoSum extends App {

  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    @scala.annotation.tailrec
    def twoSum(nums: Seq[(Int, Int)], target: Int): Seq[Int] = nums match {
      case _ :: Nil => Seq(0, 0)
      case (n1, i1) :: tail => tail.find { case (n2, _) => n1 + n2 == target } match {
        case Some((_, i2)) => Seq(i1, i2)
        case _ => twoSum(tail, target)
      }
    }

    twoSum(nums.toList.zipWithIndex, target).toArray
  }
}
