package com.soumen.leetcodesolutions
package simple.validparentheses

object Solution4 extends App {

  def isMatching(open: Char, close: Char) = open == '(' && close == ')' || open == '{' && close == '}' || open == '[' && close == ']'

  def isOpen(c: Char) = c == '(' || c == '{' || c == '['

  def isValid(s: String): Boolean = if (s.isEmpty) true else {
    var opened = ""
    s.foldLeft(true) { (valid, c) =>
      if (isOpen(c)) {
        opened = s"$c$opened"
        valid
      } else if (opened.isEmpty) {
        false
      } else if (isMatching(opened.head, c)) {
        opened = opened.substring(1)
        valid
      } else {
        false
      }
    } && opened.isEmpty
  }
  println(isValid("{[]}"))
}

//Runtime: 829 ms, faster than 29.25% of Scala online submissions for Valid Parentheses.
//Memory Usage: 82.4 MB, less than 14.62% of Scala online submissions for Valid Parentheses.