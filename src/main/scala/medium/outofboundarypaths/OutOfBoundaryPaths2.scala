package com.soumen.leetcodesolutions
package medium.outofboundarypaths

/**
 * <a href="https://leetcode.com/problems/out-of-boundary-paths/">
 * 576. Out of Boundary Paths
 * </a>
 * */
object OutOfBoundaryPaths2 extends App {
  def findPaths(m: Int, n: Int, maxMove: Int, startRow: Int, startColumn: Int): Int = {
    val map = scala.collection.mutable.Map.empty[(Int, Int, Int), Long]
    val M = 1000_000_007

    def helper(remainingMoves: Int = maxMove, x: Int = startRow, y: Int = startColumn): Long =
      if (x < 0 || x == m || y < 0 || y == n) 1
      else if (remainingMoves == 0) 0
      else map get(x, y, remainingMoves) match {
        case Some(v) => v
        case _ => val v = (helper(remainingMoves - 1, x - 1, y) % M
          + helper(remainingMoves - 1, x + 1, y) % M
          + helper(remainingMoves - 1, x, y - 1) % M
          + helper(remainingMoves - 1, x, y + 1) % M) % M
          map += (x, y, remainingMoves) -> v
          v
      }

    (helper() % M).toInt
  }

  println(findPaths(m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0)) //6
  println(findPaths(m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1)) //12
  println(findPaths(36, 5, 50, 15, 3)) //390153306
}
// Runtime: 884 ms, faster than 100.00% of Scala online submissions for Out of Boundary Paths.
// Memory Usage: 81.6 MB, less than 100.00% of Scala online submissions for Out of Boundary Paths.