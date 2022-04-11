package com.soumen.leetcodesolutions
package simple.shift2dgrid

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should

class Shift2DGridTest extends AnyFreeSpec with should.Matchers {
  val shift2DGrid = Shift2DGrid
  "Shift 2D grid" - {
    "should shift 3x3 grid with k=1" in {
      shift2DGrid.shiftGrid(Array(Array(1, 2, 3), Array(4, 5, 6), Array(7, 8, 9)), 1) should be(List(List(9, 1, 2), List(3, 4, 5), List(6, 7, 8)))
    }
    "should shift 4x4 grid with k=4" in {
      shift2DGrid.shiftGrid(Array(Array(3, 8, 1, 9), Array(19, 7, 2, 5), Array(4, 6, 11, 10), Array(12, 0, 21, 13)), 4) should be(List(List(12, 0, 21, 13), List(3, 8, 1, 9), List(19, 7, 2, 5), List(4, 6, 11, 10)))
    }
    "should shift 3x3 grid with k=10" in {
      shift2DGrid.shiftGrid(Array(Array(1, 2, 3), Array(4, 5, 6), Array(7, 8, 9)), 10) should be(List(List(9, 1, 2), List(3, 4, 5), List(6, 7, 8)))
    }
    "should shift 3x3 grid with k=9" in {
      shift2DGrid.shiftGrid(Array(Array(1, 2, 3), Array(4, 5, 6), Array(7, 8, 9)), 9) should be(List(List(1, 2, 3), List(4, 5, 6), List(7, 8, 9)))
    }
    "should shift 7x1 grid with k=23" in {
      shift2DGrid.shiftGrid(Array(Array(1), Array(2), Array(3), Array(4), Array(7), Array(6), Array(5)), 23) should be(List(List(6), List(5), List(1), List(2), List(3), List(4), List(7)))
    }
  }
}
