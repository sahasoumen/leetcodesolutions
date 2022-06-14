package com.soumen.leetcodesolutions
package medium.triangle

/**
 * <a href="https://leetcode.com/problems/triangle/">
 * 120. Triangle
 * </a>
 * */
object Triangle4 extends App {
  def minimumTotal(triangle: List[List[Int]]): Int = triangle.tail.foldLeft(triangle.head) { case (last, l) => l.zipWithIndex.map { case (n, j) => n + (if (j == 0) last(j) else if (j == last.length) last(j - 1) else last(j) min last(j - 1)) } }.min


  println(minimumTotal(List(List(2), List(3, 4), List(6, 5, 7), List(4, 1, 8, 3))))
  println(minimumTotal(List(List(-10))))
  println(minimumTotal(List(List(-1), List(2, 3), List(1, -1, -3))))
}
//Runtime: 985 ms, faster than 23.08% of Scala online submissions for Triangle.
//Memory Usage: 74.1 MB, less than 34.61% of Scala online submissions for Triangle.