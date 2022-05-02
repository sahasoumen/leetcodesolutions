package com.soumen.leetcodesolutions
package simple.backspacestringcompare

/**
 * https://leetcode.com/problems/backspace-string-compare/submissions/
 * 844. Backspace String Compare
 * */
object Solution extends App {
  @scala.annotation.tailrec
  def backspaceString(s: String, pos: Int, backspaceCount: Int = 0, response: Seq[Char] = Nil): Seq[Char] = if (pos < 0) response else s.charAt(pos) match {
    case '#' => backspaceString(s, pos - 1, backspaceCount + 1, response)
    case c => if (backspaceCount == 0) backspaceString(s, pos - 1, 0, response :+ c) else backspaceString(s, pos - 1, backspaceCount - 1, response)
  }

  def backspaceCompare(s: String, t: String): Boolean = backspaceString(s, s.length - 1) == backspaceString(t, t.length - 1)
}

//Runtime: 553 ms, faster than 80.43% of Scala online submissions for Backspace String Compare.
//Memory Usage: 52.8 MB, less than 84.78% of Scala online submissions for Backspace String Compare.
