package com.soumen.leetcodesolutions
package hard.longestincreasingpathinamatrix

/**
 * <a href="https://leetcode.com/problems/longest-increasing-path-in-a-matrix/submissions/">
 * 329. Longest Increasing Path in a Matrix
 * </a>
 * */
object LongestIncreasingPathInAMatrix extends App {
  def longestIncreasingPath(matrix: Array[Array[Int]]): Int = matrix(0).length -> matrix.length match {
    case (m, n) =>
      case class Point(x: Int, y: Int) {
        def v = matrix(y)(x)

        def valid(p: Point) = p.v > v

        def left = if (x > 0) Some(copy(x = x - 1)).filter(valid) else None

        def right = if (x < m - 1) Some(copy(x = x + 1)).filter(valid) else None

        def up = if (y > 0) Some(copy(y = y - 1)).filter(valid) else None

        def down = if (y < n - 1) Some(copy(y = y + 1)).filter(valid) else None

        def next = Seq(left, right, up, down).flatten
      }
      val pathCount = scala.collection.mutable.Map.empty[Point, Int]

      def maxLen(step: Point, path: Seq[Point] = Nil): Int = step.next match {
        case Nil => pathCount += (step -> (pathCount.getOrElse(step, 1) max (path.length + 1)))
          pathCount(step)
        case next => next.map(maxLen(_, step +: path)).max
      }

      (for (x <- 0 until m; y <- 0 until n) yield Point(x, y)).map(maxLen(_)).max
  }
}
//Memory Limit Exceeded