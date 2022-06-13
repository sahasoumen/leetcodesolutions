package com.soumen.leetcodesolutions
package medium.triangle

/**
 * <a href="https://leetcode.com/problems/triangle/">
 * 120. Triangle
 * </a>
 * */
object Triangle3 extends App {
  def minimumTotal(triangle: List[List[Int]]): Int = {
    val dp = Array.ofDim[Int](triangle.length + 1, triangle.length + 1)
    for (i <- triangle.length - 1 to 0 by -1; j <- 0 to i)
      dp(i)(j) = triangle(i)(j) + (dp(i + 1)(j) min dp(i + 1)(j + 1))
    dp(0)(0)
  }

  println(minimumTotal(List(List(2), List(3, 4), List(6, 5, 7), List(4, 1, 8, 3))))
  println(minimumTotal(List(List(-10))))
  println(minimumTotal(List(List(-1), List(2, 3), List(1, -1, -3))))

}
//Runtime: 987 ms, faster than 23.08% of Scala online submissions for Triangle.
//Memory Usage: 73.5 MB, less than 38.46% of Scala online submissions for Triangle.