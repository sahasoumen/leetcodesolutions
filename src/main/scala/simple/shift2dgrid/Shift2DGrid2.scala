package com.soumen.leetcodesolutions
package simple.shift2dgrid

/**
 * https://leetcode.com/problems/shift-2d-grid/
 * 1260. Shift 2D Grid
 */
object Shift2DGrid2 extends App {
  def shiftGrid(grid: Array[Array[Int]], k: Int): List[List[Int]] = (grid.head.length, grid.length) match {
    case (m, n) => m * n match {
      case total => k % total match {
        case 0 => grid.map(_.toList).toList
        case shift => (0 until total).toList.map(_ - shift).map(x => if (x < 0) total + x else x)
          .map(x => grid(x / m)(x % m)).grouped(m).toList
      }
    }
  }
}
//Runtime: 700 ms, faster than 100.00% of Scala online submissions for Shift 2D Grid.
//Memory Usage: 57.4 MB, less than 100.00% of Scala online submissions for Shift 2D Grid.