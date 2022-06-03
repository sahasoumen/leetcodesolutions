package com.soumen.leetcodesolutions
package medium.rangesumquery2dimmutable

/**
 * <a href="https://leetcode.com/problems/range-sum-query-2d-immutable/">
 * 304. Range Sum Query 2D - Immutable
 * </a>
 * */

class NumMatrix2(_matrix: Array[Array[Int]]) {
  val sumMap = scala.collection.mutable.Map.empty[(Int, Int, Int, Int), Int]

  def sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int = {
    def helper(r: Int = row1, c: Int = col1): Int = sumMap get(r, c, row2, col2) match {
      case Some(s) => s
      case _ =>
        var sum = 0
        if (r == row2) {
          for (j <- c to col2) sum += _matrix(r)(j)
        } else if (c == col2) {
          for (i <- r to row2) sum += _matrix(i)(c)
        } else {
          for (i <- r to row2) sum += _matrix(i)(c)
          for (j <- c + 1 to col2) sum += _matrix(r)(j)
          sum += helper(r + 1, c + 1)
        }
        sumMap += (r, c, row2, col2) -> sum
        sum
    }

    helper()
  }

}

object RangeSumQuery2DImmutable2 extends App {
  val matrix = new NumMatrix2(Array(Array(3, 0, 1, 4, 2), Array(5, 6, 3, 2, 1), Array(1, 2, 0, 1, 5), Array(4, 1, 0, 1, 7), Array(1, 0, 3, 0, 5)))
  println(matrix.sumRegion(2, 1, 4, 3))
  println(matrix.sumRegion(1, 1, 2, 2))
  println(matrix.sumRegion(1, 2, 2, 4))
}
//Runtime: 8662 ms, faster than 10.00% of Scala online submissions for Range Sum Query 2D - Immutable.
//Memory Usage: 531.6 MB, less than 10.00% of Scala online submissions for Range Sum Query 2D - Immutable.