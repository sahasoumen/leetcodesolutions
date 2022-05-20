package com.soumen.leetcodesolutions
package hard.longestincreasingpathinamatrix

/**
 * <a href="https://leetcode.com/problems/longest-increasing-path-in-a-matrix/submissions/">
 * 329. Longest Increasing Path in a Matrix
 * </a>
 * */
object LongestIncreasingPathInAMatrix3 extends App {
  def longestIncreasingPath(matrix: Array[Array[Int]]): Int = matrix(0).length -> matrix.length match {
    case (m, n) =>
      case class Point(x: Int, y: Int) {
        lazy val v = matrix(y)(x)

        def valid(p: Point) = p.v > v

      }
      val allPoints = (for (x <- 0 until m; y <- 0 until n) yield (x -> y) -> Point(x, y)).toMap

      def left(p: Point) = allPoints.get(p.x - 1, p.y).filter(p.valid)

      def right(p: Point) = allPoints.get(p.x + 1, p.y).filter(p.valid)

      def up(p: Point) = allPoints.get(p.x, p.y - 1).filter(p.valid)

      def down(p: Point) = allPoints.get(p.x, p.y + 1).filter(p.valid)

      def next(p: Point) = Seq(left(p), right(p), up(p), down(p)).flatten

      val lenCount = scala.collection.mutable.Map.empty[Point, Int]

      def maxLen(step: Point, path: Seq[Point] = Nil): Int = lenCount get step match {
        case Some(c) => c
        case None => next(step) match {
          case Nil => lenCount += (step -> 1)
            1
          case n => val len = n.filterNot(path.contains).map(maxLen(_, step +: path)).max + 1
            lenCount += (step -> (lenCount.getOrElse(step, 1) max len))
            len
        }
      }

      allPoints.values.map(maxLen(_)).max
  }

  println(longestIncreasingPath(Array(Array(9, 9, 4), Array(6, 6, 8), Array(2, 1, 1))))
  println(longestIncreasingPath(Array(Array(3, 4, 5), Array(3, 2, 6), Array(2, 2, 1))))
}
//Runtime: 3296 ms, faster than 20.00% of Scala online submissions for Longest Increasing Path in a Matrix.
//Memory Usage: 130.8 MB, less than 25.00% of Scala online submissions for Longest Increasing Path in a Matrix.