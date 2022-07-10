package com.soumen.leetcodesolutions
package simple.mincostclimbingstairs

/**
 * <a href="https://leetcode.com/problems/min-cost-climbing-stairs/">
 * 746. Min Cost Climbing Stairs
 * </a>
 * */
object MinCostClimbingStairs2 extends App {
  def minCostClimbingStairs(cost: Array[Int]): Int = {
    val map = scala.collection.mutable.Map.empty[Int, Int]

    def helper(i: Int): Int =
      if (i <= 1) cost(i)
      else cost(i) + (map get i match {
        case Some(v) => v
        case _ => val v = helper(i - 2) min helper(i - 1)
          map += i -> v
          v
      })

    helper(cost.length - 1) min helper(cost.length - 2)
  }

  println(minCostClimbingStairs(Array(10, 15, 20))) //15
  println(minCostClimbingStairs(Array(1, 100, 1, 1, 1, 100, 1, 1, 100, 1))) //6
}
//Runtime: 593 ms, faster than 92.31% of Scala online submissions for Min Cost Climbing Stairs.
//Memory Usage: 53.5 MB, less than 98.08% of Scala online submissions for Min Cost Climbing Stairs.