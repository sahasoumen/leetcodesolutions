package com.soumen.leetcodesolutions
package simple.twosum

/** Complexity O(n) */
object TwoSumWithMap extends App {

  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    @scala.annotation.tailrec
    def twoSum(nums: Seq[Int], target: Int, position: Int = 0, numMap: Map[Int, Int] = Map.empty): Array[Int] = nums match {
      case Nil => Array(0, 0)
      case n1 :: tail => numMap get (target - n1) match {
        case Some(i1) => Array(i1, position)
        case _ => twoSum(tail, target, position + 1, numMap + (n1 -> position))
      }
    }

    twoSum(nums.toList, target)
  }
}
