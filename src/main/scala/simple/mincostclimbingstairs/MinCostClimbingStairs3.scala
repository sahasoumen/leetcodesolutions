package com.soumen.leetcodesolutions
package simple.mincostclimbingstairs

/**
 * <a href="https://leetcode.com/problems/min-cost-climbing-stairs/">
 * 746. Min Cost Climbing Stairs
 * </a>
 * */
object MinCostClimbingStairs3 extends App {
  def minCostClimbingStairs(cost: Array[Int]): Int = {
    val dp = Array.ofDim[Int](cost.length + 2)
    for (i <- cost.indices) dp(i + 2) = cost(i) + (dp(i) min dp(i + 1))

    dp(cost.length + 1) min dp(cost.length)
  }

  println(minCostClimbingStairs(Array(10, 15, 20))) //15
  println(minCostClimbingStairs(Array(1, 100, 1, 1, 1, 100, 1, 1, 100, 1))) //6
}
//Runtime: 777 ms, faster than 73.08% of Scala online submissions for Min Cost Climbing Stairs.
//Memory Usage: 70.4 MB, less than 59.62% of Scala online submissions for Min Cost Climbing Stairs.