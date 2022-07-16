package com.soumen.leetcodesolutions
package medium.outofboundarypaths

/**
 * <a href="https://leetcode.com/problems/out-of-boundary-paths/">
 * 576. Out of Boundary Paths
 * </a>
 * */
object OutOfBoundaryPaths4 extends App {
  def findPaths(m: Int, n: Int, maxMove: Int, startRow: Int, startColumn: Int): Int = {
    val map = Array.ofDim[Int](m, n)
    if (startRow < 0 || startRow == m || startColumn < 0 || startColumn == n) 1
    else if (maxMove == 0) 0
    else map(startRow)(startColumn) match {
      case 0 => val v = (findPaths(m, n, maxMove - 1, startRow - 1, startColumn)
        + findPaths(m, n, maxMove - 1, startRow + 1, startColumn)
        + findPaths(m, n, maxMove - 1, startRow, startColumn - 1)
        + findPaths(m, n, maxMove - 1, startRow, startColumn + 1)) % 1000_000_007
        map(startRow)(startColumn) = v
        v
      case v => v
    }
  }

  println(findPaths(m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0)) //6
  println(findPaths(m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1)) //12
}
// Memory Limit Exceeded