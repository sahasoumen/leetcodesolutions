package com.soumen.leetcodesolutions
package medium.numberofislands

/**
 * https://leetcode.com/problems/number-of-islands/
 * 200. Number of Islands
 * */
object NumberOfIsland extends App {
  def numIslands(grid: Array[Array[Char]]): Int = (grid.length, grid.head.length) match {
    case (depth, breadth) =>
      def sinkIsland(x: Int, y: Int): Unit = {
        grid(y)(x) = '0'
        Seq((x - 1, y), (x + 1, y), (x, y - 1), (x, y + 1))
          .filter { case (x, y) => x >= 0 && x < breadth && y >= 0 && y < depth && grid(y)(x) == '1' }
          .foreach { case (x, y) => sinkIsland(x, y) }
      }

      var islandCount = 0
      for {
        y <- 0 until depth
        x <- 0 until breadth
      } yield if (grid(y)(x) == '1') {
        islandCount += 1
        sinkIsland(x, y)
      }
      islandCount
  }

  println(numIslands(Array(Array('1', '1', '1', '1', '0'), Array('1', '1', '0', '1', '0'), Array('1', '1', '0', '0', '0'), Array('0', '0', '0', '0', '0'))))
}
//Runtime: 1117 ms, faster than 29.63% of Scala online submissions for Number of Islands.
//Memory Usage: 86.7 MB, less than 70.37% of Scala online submissions for Number of Islands.