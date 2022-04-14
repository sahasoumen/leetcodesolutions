package com.soumen.leetcodesolutions
package simple.shift2dgrid

/**
 * https://leetcode.com/problems/shift-2d-grid/
 * 1260. Shift 2D Grid
 */
object Shift2DGrid extends App {
  def shiftGrid(grid: Array[Array[Int]], k: Int): List[List[Int]] = grid.head.length * grid.length match {
    case total => k % total match {
      case 0 => grid.map(_.toList).toList
      case shift => grid.flatten match {
        case s => (s.takeRight(shift).toList ++ s.take(total - shift)).grouped(grid.head.length).toList
      }
    }
  }
}
//Runtime: 1124 ms, faster than 100.00% of Scala online submissions for Shift 2D Grid.
//Memory Usage: 88.2 MB, less than 100.00% of Scala online submissions for Shift 2D Grid.