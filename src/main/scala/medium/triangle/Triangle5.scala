package com.soumen.leetcodesolutions
package medium.triangle

/**
 * <a href="https://leetcode.com/problems/triangle/">
 * 120. Triangle
 * </a>
 * */
object Triangle5 extends App {
  def minimumTotal(triangle: List[List[Int]]): Int = triangle.tail.iterator.foldLeft(triangle.head.toArray) { case (last, l) => l.zipWithIndex.map { case (n, j) => n + (if (j == 0) last(j) else if (j == last.length) last(j - 1) else last(j) min last(j - 1)) }.toArray }.min


  println(minimumTotal(List(List(2), List(3, 4), List(6, 5, 7), List(4, 1, 8, 3))))
  println(minimumTotal(List(List(-10))))
  println(minimumTotal(List(List(-1), List(2, 3), List(1, -1, -3))))

}
//Runtime: 960 ms, faster than 23.08% of Scala online submissions for Triangle.
//Memory Usage: 75.9 MB, less than 15.38% of Scala online submissions for Triangle.