package com.soumen.leetcodesolutions
package simple.mincostclimbingstairs

/**
 * <a href="https://leetcode.com/problems/min-cost-climbing-stairs/">
 * 746. Min Cost Climbing Stairs
 * </a>
 * */
object MinCostClimbingStairs4 extends App {
  def minCostClimbingStairs(cost: Array[Int]): Int = cost.foldLeft(0, 0) { case ((secondLast, last), cost) => last -> (cost + (secondLast min last)) } match {
    case (v1, v2) => v1 min v2
  }


  println(minCostClimbingStairs(Array(10, 15, 20))) //15
  println(minCostClimbingStairs(Array(1, 100, 1, 1, 1, 100, 1, 1, 100, 1))) //6
}
//Runtime: 902 ms, faster than 34.61% of Scala online submissions for Min Cost Climbing Stairs.
//Memory Usage: 73.5 MB, less than 23.08% of Scala online submissions for Min Cost Climbing Stairs.