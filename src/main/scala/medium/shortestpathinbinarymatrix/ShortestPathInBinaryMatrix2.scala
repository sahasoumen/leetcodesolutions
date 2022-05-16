package com.soumen.leetcodesolutions
package medium.shortestpathinbinarymatrix

/**
 * https://leetcode.com/problems/shortest-path-in-binary-matrix/
 * 1091. Shortest Path in Binary Matrix
 * */
object ShortestPathInBinaryMatrix2 extends App {
  def shortestPathBinaryMatrix(grid: Array[Array[Int]]): Int = {

    def neighbours(x: Int, y: Int): Seq[(Int, Int)] = for {
      i <- x - 1 to x + 1 if i >= 0 && i < grid(0).length
      j <- y - 1 to y + 1 if j >= 0 && j < grid.length && !(i == x && j == y) && grid(j)(i) == 0
    } yield (i, j)

    val start = (0, 0)
    val destination = (grid(0).length - 1, grid.length - 1)
    val nMap = (for (i <- grid(0).indices; j <- grid.indices if grid(j)(i) == 0) yield (i, j)).map(p => p -> neighbours(p._1, p._2)).toMap

    def minPath(p: (Int, Int) = start, path: Seq[(Int, Int)] = Nil, len: Int = 1): Int = if (p == destination) len else nMap(p).filterNot(path.contains) match {
      case Nil => Int.MaxValue
      case s => path :+ p match {
        case np => s.map(minPath(_, np, len + 1)).min
      }
    }

    if (grid(start._2)(start._1) == 1 || grid(destination._2)(destination._1) == 1) -1 else minPath() match {
      case r if r == Int.MaxValue => -1
      case r => r
    }
  }

  println(shortestPathBinaryMatrix(Array(Array(0, 1), Array(1, 0))))
  println(shortestPathBinaryMatrix(Array(Array(0, 0, 0), Array(1, 1, 0), Array(1, 1, 0))))
  println(shortestPathBinaryMatrix(Array(Array(1, 0, 0), Array(1, 1, 0), Array(1, 1, 0))))
  println(shortestPathBinaryMatrix(Array(Array(0, 0, 1, 1, 0, 0), Array(0, 0, 0, 0, 1, 1), Array(1, 0, 1, 1, 0, 0), Array(0, 0, 1, 1, 0, 0), Array(0, 0, 0, 0, 0, 0), Array(0, 0, 1, 0, 0, 0))))
}
//Time Limit Exceeded