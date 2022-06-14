package com.soumen.leetcodesolutions
package medium.triangle

/**
 * <a href="https://leetcode.com/problems/triangle/">
 * 120. Triangle
 * </a>
 * */
object Triangle7 extends App {
  def minimumTotal(triangle: List[List[Int]]): Int = triangle.init.reverse.foldLeft(triangle.last) { case (last, list) =>
    last.sliding(2).map(l => l.head min l.last).zip(list).map(t => t._1 + t._2).toList
  }.head


  println(minimumTotal(List(List(2), List(3, 4), List(6, 5, 7), List(4, 1, 8, 3))))
  println(minimumTotal(List(List(-10))))
  println(minimumTotal(List(List(-1), List(2, 3), List(1, -1, -3))))

}
//Runtime: 1527 ms, faster than 7.69% of Scala online submissions for Triangle.
//Memory Usage: 89.6 MB, less than 7.69% of Scala online submissions for Triangle.