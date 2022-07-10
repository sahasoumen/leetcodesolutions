package com.soumen.leetcodesolutions
package simple.mincostclimbingstairs

/**
 * <a href="https://leetcode.com/problems/min-cost-climbing-stairs/">
 * 746. Min Cost Climbing Stairs
 * </a>
 * */
object MinCostClimbingStairs extends App {
  def minCostClimbingStairs(cost: Array[Int]): Int = {

    def helper(i: Int): Int = if (i <= 1) cost(i) else cost(i) + (helper(i - 2) min helper(i - 1))

    helper(cost.length - 1) min helper(cost.length - 2)
  }

  println(minCostClimbingStairs(Array(10, 15, 20))) //15
  println(minCostClimbingStairs(Array(1, 100, 1, 1, 1, 100, 1, 1, 100, 1))) //6
}
//Memory Limit Exceeded