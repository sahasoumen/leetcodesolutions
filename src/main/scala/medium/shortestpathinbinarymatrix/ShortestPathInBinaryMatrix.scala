package com.soumen.leetcodesolutions
package medium.shortestpathinbinarymatrix

/**
 * https://leetcode.com/problems/shortest-path-in-binary-matrix/
 * 1091. Shortest Path in Binary Matrix
 * */
object ShortestPathInBinaryMatrix extends App {
  def shortestPathBinaryMatrix(grid: Array[Array[Int]]): Int = {
    case class Point(x: Int, y: Int) {
      def v = grid(y)(x)

      def neighbours(exclude: Seq[Point] = Nil): Seq[Point] = (for {
        i <- x - 1 to x + 1 if i >= 0 && i < grid(0).length
        j <- y - 1 to y + 1 if j >= 0 && j < grid.length
      } yield Point(i, j)).filterNot(_ == this).filter(_.v == 0).filterNot(exclude.contains)
    }
    val start = Point(0, 0)
    val destination = Point(grid(0).length - 1, grid.length - 1)

    def minPath(p: Point = start, path: Seq[Point] = Nil, len: Int = 1): Int = if (p == destination) len else p.neighbours(path) match {
      case Nil => Int.MaxValue
      case s => path :+ p match {
        case np => s.map(minPath(_, np, len + 1)).min
      }
    }

    if (start.v == 1 || destination.v == 1) -1 else minPath(start) match {
      case r if r == Int.MaxValue => -1
      case r => r
    }
  }

  println(shortestPathBinaryMatrix(Array(Array(0, 1), Array(1, 0))))
  println(shortestPathBinaryMatrix(Array(Array(0, 0, 0), Array(1, 1, 0), Array(1, 1, 0))))
  println(shortestPathBinaryMatrix(Array(Array(1, 0, 0), Array(1, 1, 0), Array(1, 1, 0))))
  println(shortestPathBinaryMatrix(Array(Array(0,0,1,1,0,0),Array(0,0,0,0,1,1),Array(1,0,1,1,0,0),Array(0,0,1,1,0,0),Array(0,0,0,0,0,0),Array(0,0,1,0,0,0))))
}
//Memory Limit Exceeded