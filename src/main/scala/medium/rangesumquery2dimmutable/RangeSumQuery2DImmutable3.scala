package com.soumen.leetcodesolutions
package medium.rangesumquery2dimmutable

/**
 * <a href="https://leetcode.com/problems/range-sum-query-2d-immutable/">
 * 304. Range Sum Query 2D - Immutable
 * </a>
 * */

class NumMatrix3(_matrix: Array[Array[Int]]) {
  val dp = Array.ofDim[Int](_matrix.length + 1, _matrix(0).length + 1)
  for (r <- _matrix.indices; c <-_matrix(0).indices) dp(r + 1)(c + 1) = dp(r + 1)(c) + dp(r)(c + 1) + _matrix(r)(c) - dp(r)(c)

  def sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int = dp(row2 + 1)(col2 + 1) - dp(row1)(col2 + 1) - dp(row2 + 1)(col1) + dp(row1)(col1)

}

object RangeSumQuery2DImmutable3 extends App {
  val matrix = new NumMatrix3(Array(Array(3, 0, 1, 4, 2), Array(5, 6, 3, 2, 1), Array(1, 2, 0, 1, 5), Array(4, 1, 0, 1, 7), Array(1, 0, 3, 0, 5)))
  //  println(matrix.sumRegion(2, 1, 4, 3))
  println(matrix.sumRegion(1, 1, 2, 2))
  //  println(matrix.sumRegion(1, 2, 2, 4))
}
//Runtime: 2831 ms, faster than 40.00% of Scala online submissions for Range Sum Query 2D - Immutable.
//Memory Usage: 256.2 MB, less than 30.00% of Scala online submissions for Range Sum Query 2D - Immutable.