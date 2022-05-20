package com.soumen.leetcodesolutions
package hard.longestincreasingpathinamatrix

/**
 * <a href="https://leetcode.com/problems/longest-increasing-path-in-a-matrix/submissions/">
 * 329. Longest Increasing Path in a Matrix
 * </a>
 * */
object LongestIncreasingPathInAMatrix2 extends App {
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
      val lenCount = scala.collection.mutable.Map.empty[Point, Int]

      def maxLen(step: Point, path: Seq[Point] = Nil): Int = lenCount get step match {
        case Some(c) => c
        case None => step.next match {
          case Nil => lenCount += (step -> 1)
            1
          case next => val len = next.filterNot(path.contains).map(maxLen(_, step +: path)).max + 1
            lenCount += (step -> (lenCount.getOrElse(step, 1) max len))
            len
        }
      }

      (for (x <- 0 until m; y <- 0 until n) yield Point(x, y)).map(maxLen(_)).max
  }

  println(longestIncreasingPath(Array(Array(9, 9, 4), Array(6, 6, 8), Array(2, 1, 1))))
  println(longestIncreasingPath(Array(Array(3, 4, 5), Array(3, 2, 6), Array(2, 2, 1))))
}
//Runtime: 2122 ms, faster than 30.00% of Scala online submissions for Longest Increasing Path in a Matrix.
//Memory Usage: 115.6 MB, less than 30.00% of Scala online submissions for Longest Increasing Path in a Matrix.