package com.soumen.leetcodesolutions
package medium.minimumoperationstoreducextozero

/**
 * <a href="https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/">
 * 1658. Minimum Operations to Reduce X to Zero
 * </a>
 * */
object MinimumOperationsToReduceXToZero extends App {
  def minOperations(nums: Array[Int], x: Int): Int = nums.sum - x match {
    case target =>
      @scala.annotation.tailrec
      def helper(i: Int = 0, left: Int = 0, max: Int = 0, runningSum: Int = 0): Int =
        if (runningSum == target) helper(i, left + 1, max max (i - left), runningSum - nums(left))
        else if (runningSum < target && i < nums.length) helper(i + 1, left, max, runningSum + nums(i))
        else if (runningSum > target) helper(i, left + 1, max, runningSum - nums(left))
        else max

      if (target < 0) -1 else if (target == 0) nums.length else helper() match {
        case n if n == 0 => -1
        case n => nums.length - n
      }
  }

  println(minOperations(Array(1, 1, 4, 2, 3), 5))
  println(minOperations(Array(3, 2, 20, 1, 1, 3), 10))
  println(minOperations(Array(5, 6, 7, 8, 9), 4))
  println(minOperations(Array(5, 2, 3, 1, 1), 5))
  println(minOperations(Array(5, 1, 4, 2, 3), 6))
  println(minOperations(Array(1, 1), 3))
}
//Runtime: 1572 ms, faster than 100.00% of Scala online submissions for Minimum Operations to Reduce X to Zero.
//Memory Usage: 139.1 MB, less than 100.00% of Scala online submissions for Minimum Operations to Reduce X to Zero.
