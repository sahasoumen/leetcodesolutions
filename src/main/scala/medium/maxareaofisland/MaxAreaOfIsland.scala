package com.soumen.leetcodesolutions
package medium.maxareaofisland

/**
 * <a href="https://leetcode.com/problems/max-area-of-island/">
 * 695. Max Area of Island
 * </a>
 * */
object MaxAreaOfIsland extends App {
  def maxAreaOfIsland(grid: Array[Array[Int]]): Int = {
    val (m, n) = (grid(0).length, grid.length)

    def islandSize(x: Int, y: Int): Int = {
      val current = grid(y)(x)
      grid(y)(x) = 0 //sink the island
      current + Seq((x - 1, y), (x + 1, y), (x, y - 1), (x, y + 1))
        .filter { case (i, j) => i >= 0 && j >= 0 && i < m && j < n && grid(j)(i) == 1 }
        .map { case (i, j) => islandSize(i, j) }
        .sum
    }

    @scala.annotation.tailrec
    def findMaxSize(x: Int = 0, y: Int = 0, max: Int = 0): Int =
      if (x == m) if (y == n - 1) max else findMaxSize(0, y + 1, max)
      else if (grid(y)(x) == 1) findMaxSize(x + 1, y, max max islandSize(x, y))
      else findMaxSize(x + 1, y, max)

    findMaxSize()
  }

  val grid = Array(
    Array(0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0),
    Array(0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0),
    Array(0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0),
    Array(0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0),
    Array(0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0),
    Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0),
    Array(0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0),
    Array(0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0)
  )
  println(maxAreaOfIsland(grid)) //6
  println(maxAreaOfIsland(Array(Array(0, 0, 0, 0, 0, 0, 0, 0)))) //0

  val grid2 = Array(Array(1, 1, 0, 0, 0), Array(1, 1, 0, 0, 0), Array(0, 0, 0, 1, 1), Array(0, 0, 0, 1, 1))
  println(maxAreaOfIsland(grid2)) //4

}
//Runtime: 1290 ms, faster than 25.00% of Scala online submissions for Max Area of Island.
//Memory Usage: 87.8 MB, less than 37.50% of Scala online submissions for Max Area of Island.