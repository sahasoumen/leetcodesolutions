package com.soumen.leetcodesolutions
package medium.twosumiiinputarrayissorted

import scala.annotation.tailrec

/**
 * <a href="https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/">
 *   167. Two Sum II - Input Array Is Sorted
 * </a>
 * */
object TwoSumIIInputArrayIsSorted {
  def twoSum(numbers: Array[Int], target: Int): Array[Int] = {
    @tailrec
    def helper(i: Int = 1, j: Int = numbers.length): Array[Int] = numbers(i - 1) -> numbers(j - 1) match {
      case x -> y if x + y == target => Array(i, j)
      case x -> y if x + y < target => helper(i + 1, j)
      case _ => helper(i, j - 1)
    }

    helper()
  }


}
//Runtime: 893 ms, faster than 55.83% of Scala online submissions for Two Sum II - Input Array Is Sorted.
//Memory Usage: 80.5 MB, less than 17.50% of Scala online submissions for Two Sum II - Input Array Is Sorted.