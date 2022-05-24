package com.soumen.leetcodesolutions
package hard.longestvalidparentheses

/**
 * <a href="https://leetcode.com/problems/longest-valid-parentheses/solution/"
 * 32. Longest Valid Parentheses
 * </a>
 * */
object LongestValidParentheses2 extends App {
  def longestValidParentheses(s: String): Int = {
    val stack = scala.collection.mutable.Stack[Int](-1)
    (0 until s.length).foldLeft(0) { case (max, i) =>
      if (s.charAt(i) == '(') {
        stack.push(i)
        max
      } else {
        stack.pop()
        if (stack.isEmpty) {
          stack.push(i)
          max
        } else
          max max (i - stack.top)
      }
    }
  }

  println(longestValidParentheses("())((())"))
  println(longestValidParentheses("()"))
  println(longestValidParentheses(")("))
  println(longestValidParentheses("(()"))
  println(longestValidParentheses(")()())"))
  println(longestValidParentheses("()(()"))
}
//Runtime: 910 ms, faster than 44.83% of Scala online submissions for Longest Valid Parentheses.
//Memory Usage: 73.1 MB, less than 44.83% of Scala online submissions for Longest Valid Parentheses.