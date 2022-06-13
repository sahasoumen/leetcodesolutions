package com.soumen.leetcodesolutions
package medium.triangle

/**
 * <a href="https://leetcode.com/problems/triangle/">
 * 120. Triangle
 * </a>
 * */
object Triangle extends App {
  def minimumTotal(triangle: List[List[Int]]): Int =
    triangle.tail.foldLeft((triangle.head.head, 0)) { case ((sum, i), arr) => if (arr(i) > arr(i + 1)) (sum + arr(i + 1), i + 1) else (sum + arr(i), i) }._1

  println(minimumTotal(List(List(2), List(3, 4), List(6, 5, 7), List(4, 1, 8, 3))))
  println(minimumTotal(List(List(-10))))
  println(minimumTotal(List(List(-1), List(2, 3), List(1, -1, -3)))) //should be -1

}
//Wrong Answer