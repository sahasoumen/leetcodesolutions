package com.soumen.leetcodesolutions
package hard.longestvalidparentheses

/**
 * <a href="https://leetcode.com/problems/longest-valid-parentheses/solution/"
 * 32. Longest Valid Parentheses
 * </a>
 * */
object LongestValidParentheses extends App {
  def longestValidParentheses(s: String): Int = {
    @scala.annotation.tailrec
    def leftScan(pos: Int = 0, left: Int = 0, right: Int = 0, len: Int = 0): Int =
      if (right > left) leftScan(pos, 0, 0, len)
      else if (pos == s.length) len
      else if (s.charAt(pos) == '(') leftScan(pos + 1, left + 1, right, if (left + 1 == right) len max (left + right + 1) else len)
      else leftScan(pos + 1, left, right + 1, if (left == right + 1) len max (left + right + 1) else len)


    @scala.annotation.tailrec
    def rightScan(pos: Int = s.length - 1, left: Int = 0, right: Int = 0, len: Int = 0): Int =
      if (left > right) rightScan(pos, 0, 0, len)
      else if (pos < 0) len
      else if (s.charAt(pos) == ')') rightScan(pos - 1, left, right + 1, if (left == right + 1) len max (left + right + 1) else len)
      else rightScan(pos - 1, left + 1, right, if (left + 1 == right) len max (left + right + 1) else len)

    leftScan() max rightScan()
  }

  println(longestValidParentheses("()"))
  println(longestValidParentheses(")("))
  println(longestValidParentheses("(()"))
  println(longestValidParentheses(")()())"))
  println(longestValidParentheses("()(()"))

}
//Runtime: 534 ms, faster than 93.10% of Scala online submissions for Longest Valid Parentheses.
//Memory Usage: 53.1 MB, less than 93.10% of Scala online submissions for Longest Valid Parentheses.