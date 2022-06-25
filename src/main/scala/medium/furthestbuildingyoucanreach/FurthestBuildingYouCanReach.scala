package com.soumen.leetcodesolutions
package medium.furthestbuildingyoucanreach

/**
 * <a href="https://leetcode.com/problems/furthest-building-you-can-reach/">
 * 1642. Furthest Building You Can Reach
 * </a>
 * */
object FurthestBuildingYouCanReach extends App {
  def furthestBuilding(heights: Array[Int], bricks: Int, ladders: Int): Int = {
    val q = scala.collection.mutable.PriorityQueue.empty[Int]

    @scala.annotation.tailrec
    def helper(i: Int = 1, bricksRemaining: Int = bricks, ladderRemaining: Int = ladders, last: Int = heights.head): Int =
      if (i == heights.length) i
      else if (heights(i) <= last) helper(i + 1, bricksRemaining, ladderRemaining, heights(i))
      else if (bricksRemaining >= heights(i) - last) {
        q.enqueue(heights(i) - last)
        helper(i + 1, bricksRemaining - heights(i) + last, ladderRemaining, heights(i))
      } else if (ladderRemaining > 0)
        if (q.isEmpty || q.head < heights(i) - last) helper(i + 1, bricksRemaining, ladderRemaining - 1, heights(i))
        else helper(i, bricksRemaining + q.dequeue(), ladderRemaining - 1, last)
      else i

    helper() - 1
  }

  println(furthestBuilding(Array(4, 2, 7, 6, 9, 14, 12), 5, 1)) //4
  println(furthestBuilding(Array(4, 12, 2, 7, 3, 18, 20, 3, 19), 10, 2)) //7
  println(furthestBuilding(Array(14, 3, 19, 3), 17, 0)) //3
}
//Runtime: 1249 ms, faster than 77.46% of Scala online submissions for Furthest Building You Can Reach.
//Memory Usage: 107.2 MB, less than 42.25% of Scala online submissions for Furthest Building You Can Reach.