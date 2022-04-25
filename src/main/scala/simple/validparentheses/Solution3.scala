package com.soumen.leetcodesolutions
package simple.validparentheses

object Solution3 extends App {

  def isMatching(open: Char, close: Char) = (open == '(' && close == ')') || (open == '{' && close == '}') || (open == '[' && close == ']')

  @scala.annotation.tailrec
  def isValid(s: String, opened: String = ""): Boolean = if (s.isEmpty) opened.isEmpty else s.head match {
    case c if c == '(' || c == '{' || c == '[' => isValid(s.substring(1), c +: opened)
    case c => if (opened.isEmpty) false else if (isMatching(opened.head, c)) isValid(s.substring(1), opened.substring(1)) else false
  }
}

//Runtime: 695 ms, faster than 60.87% of Scala online submissions for Valid Parentheses.
//Memory Usage: 83.8 MB, less than 13.04% of Scala online submissions for Valid Parentheses.