package com.soumen.leetcodesolutions
package medium.maxareaofisland

/**
 * <a href="https://leetcode.com/problems/max-area-of-island/">
 * 695. Max Area of Island
 * </a>
 * */
object MaxAreaOfIsland2 extends App {
  def maxAreaOfIsland(grid: Array[Array[Int]]): Int = {
    val (m, n) = (grid(0).length, grid.length)

    def islandSize(x: Int, y: Int): Int =
      if (x < 0 || y < 0 || x == m || y == n || grid(y)(x) == 0) 0
      else {
        grid(y)(x) = 0 //sink the island
        1 + islandSize(x - 1, y) + islandSize(x + 1, y) + islandSize(x, y - 1) + islandSize(x, y + 1)
      }

    var max = 0
    for (x <- 0 until m; y <- 0 until n)
      if (grid(y)(x) == 1) max = max max islandSize(x, y)

    max
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
//Runtime: 926 ms, faster than 81.25% of Scala online submissions for Max Area of Island.
//Memory Usage: 76.7 MB, less than 365.63% of Scala online submissions for Max Area of Island.