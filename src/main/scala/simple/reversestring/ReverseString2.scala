package com.soumen.leetcodesolutions
package simple.reversestring

/**
 * https://leetcode.com/problems/reverse-string/
 * 344. Reverse String
 */
object ReverseString2 extends App {
  def reverseString(s: Array[Char]): Unit = s.length - 1 match {
    case l => (0 to l / 2).foreach { i =>
      s(i) match {
        case c => s(i) = s(l - i)
          s(l - i) = c
      }
    }
  }

  val s = "hello".toArray
  reverseString(s)
  println(s.toList)
}
//Runtime: 662 ms, faster than 71.25% of Scala online submissions for Reverse String.
//Memory Usage: 58.5 MB, less than 78.75% of Scala online submissions for Reverse String.