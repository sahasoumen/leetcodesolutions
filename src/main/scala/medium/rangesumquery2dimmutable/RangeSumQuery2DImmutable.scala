package com.soumen.leetcodesolutions
package medium.rangesumquery2dimmutable

/**
 * <a href="https://leetcode.com/problems/range-sum-query-2d-immutable/">
 * 304. Range Sum Query 2D - Immutable
 * </a>
 * */

class NumMatrix(_matrix: Array[Array[Int]]) {

  def sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int = {
    var sum = 0
    for (i <- row1 to row2; j <- col1 to col2) sum += _matrix(i)(j)
    sum
  }

}

object RangeSumQuery2DImmutable extends App {
  val matrix = new NumMatrix(Array(Array(3, 0, 1, 4, 2), Array(5, 6, 3, 2, 1), Array(1, 2, 0, 1, 5), Array(4, 1, 0, 1, 7), Array(1, 0, 3, 0, 5)))
  println(matrix.sumRegion(2, 1, 4, 3))
  println(matrix.sumRegion(1, 1, 2, 2))
  println(matrix.sumRegion(1, 2, 2, 4))
}
//Runtime: 4152 ms, faster than 20.00% of Scala online submissions for Range Sum Query 2D - Immutable.
//Memory Usage: 93.7 MB, less than 100.00% of Scala online submissions for Range Sum Query 2D - Immutable.