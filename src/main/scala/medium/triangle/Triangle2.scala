package com.soumen.leetcodesolutions
package medium.triangle

/**
 * <a href="https://leetcode.com/problems/triangle/">
 * 120. Triangle
 * </a>
 * */
object Triangle2 extends App {
  def minimumTotal(triangle: List[List[Int]]): Int = {
    def helper(i: Int = 0, j: Int = 0): Int = if (i == triangle.length) 0 else triangle(i) match {
      case arr if j + 1 == arr.length => triangle(i)(j) + helper(i + 1, j)
      case _ => triangle(i) match {
        case row => (row(j) + helper(i + 1, j)) min (row(j + 1) + helper(i + 1, j + 1))
      }
    }

    helper()
  }

  println(minimumTotal(List(List(2), List(3, 4), List(6, 5, 7), List(4, 1, 8, 3))))
  println(minimumTotal(List(List(-10))))
  println(minimumTotal(List(List(-1), List(2, 3), List(1, -1, -3))))

}
//Memory Limit Exceeded