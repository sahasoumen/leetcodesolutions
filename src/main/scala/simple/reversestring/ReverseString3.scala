package com.soumen.leetcodesolutions
package simple.reversestring

/**
 * https://leetcode.com/problems/reverse-string/
 * 344. Reverse String
 */
object ReverseString3 extends App {
  @scala.annotation.tailrec
  def reverseString(s: Array[Char], pos: Int = 0): Unit = (pos, s.length - 1) match {
    case (p, l) if p >= l / 2 => //return
    case (p, l) => s(p) match {
      case c => s(p) = s(l - p)
        s(l - p) = c
        reverseString(s, p + 1)
    }
  }


  val s = "hello".toArray
  reverseString(s)
  println(s.toList)
}
//Runtime: 680 ms, faster than 71.25% of Scala online submissions for Reverse String.
//Memory Usage: 59 MB, less than 74.38% of Scala online submissions for Reverse String.