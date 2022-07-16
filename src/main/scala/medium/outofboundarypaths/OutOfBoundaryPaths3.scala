package com.soumen.leetcodesolutions
package medium.outofboundarypaths

/**
 * <a href="https://leetcode.com/problems/out-of-boundary-paths/">
 * 576. Out of Boundary Paths
 * </a>
 * */
object OutOfBoundaryPaths3 extends App {
  def findPaths(m: Int, n: Int, maxMove: Int, startRow: Int, startColumn: Int): Int = {
    val mem = Array.fill(m, n, maxMove + 1)(-1L)
    val M = 1000_000_007

    def helper(remainingMoves: Int = maxMove, x: Int = startRow, y: Int = startColumn): Long =
      if (x < 0 || x == m || y < 0 || y == n) 1
      else if (remainingMoves == 0) 0
      else if (mem(x)(y)(remainingMoves) > -1) mem(x)(y)(remainingMoves)
      else {
        mem(x)(y)(remainingMoves) = (helper(remainingMoves - 1, x - 1, y) % M
          + helper(remainingMoves - 1, x + 1, y) % M
          + helper(remainingMoves - 1, x, y - 1) % M
          + helper(remainingMoves - 1, x, y + 1) % M) % M
        mem(x)(y)(remainingMoves)
      }

    (helper() % M).toInt
  }

  println(findPaths(m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0)) //6
  println(findPaths(m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1)) //12
  println(findPaths(36, 5, 50, 15, 3)) //390153306
}
// Runtime: 750 ms, faster than 100.00% of Scala online submissions for Out of Boundary Paths.
// Memory Usage: 65.7 MB, less than 100.00% of Scala online submissions for Out of Boundary Paths.