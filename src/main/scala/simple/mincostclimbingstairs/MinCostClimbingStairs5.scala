package com.soumen.leetcodesolutions
package simple.mincostclimbingstairs

/**
 * <a href="https://leetcode.com/problems/min-cost-climbing-stairs/">
 * 746. Min Cost Climbing Stairs
 * </a>
 * */
object MinCostClimbingStairs5 extends App {
  def minCostClimbingStairs(cost: Array[Int]): Int = {
    @scala.annotation.tailrec
    def helper(i: Int = 2, v1: Int = cost(0), v2: Int = cost(1)): Int = {
      if (i == cost.length) v1 min v2
      else helper(i + 1, v2, cost(i) + (v1 min v2))
    }

    helper()
  }


  println(minCostClimbingStairs(Array(10, 15, 20))) //15
  println(minCostClimbingStairs(Array(1, 100, 1, 1, 1, 100, 1, 1, 100, 1))) //6
}
//Runtime: 813 ms, faster than 63.46% of Scala online submissions for Min Cost Climbing Stairs.
//Memory Usage: 71.7 MB, less than 40.38% of Scala online submissions for Min Cost Climbing Stairs.