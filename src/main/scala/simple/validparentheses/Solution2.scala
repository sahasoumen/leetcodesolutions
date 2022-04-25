package com.soumen.leetcodesolutions
package simple.validparentheses

object Solution2 extends App {

  def isMatching(open: Char, close: Char) = (open == '(' && close == ')') || (open == '{' && close == '}') || (open == '[' && close == ']')

  @scala.annotation.tailrec
  def isValid(s: String, opened: Seq[Char] = Nil): Boolean = if (s.isEmpty) opened.isEmpty else s.head match {
    case c if c == '(' || c == '{' || c == '[' => isValid(s.substring(1), c +: opened)
    case c => opened match {
      case Nil => false
      case open :: remaining => if (isMatching(open, c)) isValid(s.substring(1), remaining) else false
    }
  }
}

//Runtime: 714 ms, faster than 58.50% of Scala online submissions for Valid Parentheses.
//Memory Usage: 84.2 MB, less than 11.86% of Scala online submissions for Valid Parentheses.