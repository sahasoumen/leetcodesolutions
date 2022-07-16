package com.soumen.leetcodesolutions
package medium.outofboundarypaths

/**
 * <a href="https://leetcode.com/problems/out-of-boundary-paths/">
 * 576. Out of Boundary Paths
 * </a>
 * */
object OutOfBoundaryPaths extends App {
  def findPaths(m: Int, n: Int, maxMove: Int, startRow: Int, startColumn: Int): Int =
    if (startRow < 0 || startRow == m || startColumn < 0 || startColumn == n) 1
    else if (maxMove == 0) 0
    else (findPaths(m, n, maxMove - 1, startRow - 1, startColumn)
      + findPaths(m, n, maxMove - 1, startRow + 1, startColumn)
      + findPaths(m, n, maxMove - 1, startRow, startColumn - 1)
      + findPaths(m, n, maxMove - 1, startRow, startColumn + 1)) % 1000_000_007

  println(findPaths(m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0)) //6
}
// Time Limit Exceeded