package com.soumen.leetcodesolutions
package medium.uniquepathsII

/**
 * <a href="https://leetcode.com/problems/unique-paths-ii/">
 * 63. Unique Paths II
 * </a> */
object UniquePathsII extends App {
  def uniquePathsWithObstacles(obstacleGrid: Array[Array[Int]]): Int = obstacleGrid(0).length -> obstacleGrid.length match {
    case (m, n) =>
      case class Point(x: Int, y: Int) {
        def isFree = obstacleGrid(y)(x) == 0

        def right = if (x + 1 < m) Some(copy(x = x + 1)) else None

        def down = if (y + 1 < n) Some(copy(y = y + 1)) else None

        def next = Seq(right, down).flatten.filter(_.isFree)
      }
      val start = Point(0, 0)
      val finish = Point(m - 1, n - 1)

      def search(step: Point = start): Int = if (step == finish) 1 else step.next.map(search).sum

      if (start.isFree && finish.isFree) search() else 0
  }
}
//Memory Limit Exceeded