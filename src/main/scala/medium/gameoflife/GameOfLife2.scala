package com.soumen.leetcodesolutions
package medium.gameoflife

/**
 * https://leetcode.com/problems/game-of-life/
 * 289. Game of Life
 */
object GameOfLife2 extends App {
  def gameOfLife(board: Array[Array[Int]]): Unit = (board.length, board(0).length) match {
    case (m, n) =>
      def neighbors(x: Int, y: Int) = (for {
        i <- x - 1 to x + 1 if i >= 0 && i < m
        j <- y - 1 to y + 1 if j >= 0 && j < n
      } yield board(i)(j)).count(_ == 1) - board(x)(y)

      (for {
        i <- 0 until m
        j <- 0 until n
      } yield neighbors(i, j) match {
        case 3 => (i, j, 1)
        case 2 => (i, j, board(i)(j))
        case _ => (i, j, 0)
      }).foreach { case (i, j, x) => board(i)(j) = x }
  }

  val board = Array(Array(0, 1, 0), Array(0, 0, 1), Array(1, 1, 1), Array(0, 0, 0))
  gameOfLife(board)
  for {
    i <- board.indices
    j <- board(0).indices
  } yield println(s"$i, $j, ${board(i)(j)}")
}
//Runtime: 570 ms, faster than 100.00% of Scala online submissions for Game of Life.
//Memory Usage: 53.8 MB, less than 100.00% of Scala online submissions for Game of Life.
