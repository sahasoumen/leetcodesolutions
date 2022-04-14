package com.soumen.leetcodesolutions
package simple.reversestring

/**
 * https://leetcode.com/problems/reverse-string/
 * 344. Reverse String
 */
object ReverseString extends App {
  def reverseString(s: Array[Char]): Unit = s.length - 1 match {
    case l => s.zipWithIndex.foreach { case (c, i) => s(l - i) = c }
  }

  val s = "hello".toArray
  reverseString(s)
  println(s.toList)
}
//Runtime: 711 ms, faster than 71.25% of Scala online submissions for Reverse String.
//Memory Usage: 61.1 MB, less than 71.25% of Scala online submissions for Reverse String.