package com.soumen.leetcodesolutions
package hard.longestvalidparentheses

/**
 * <a href="https://leetcode.com/problems/longest-valid-parentheses/solution/"
 * 32. Longest Valid Parentheses
 * </a>
 * */
object LongestValidParentheses3 extends App {
  def longestValidParentheses(s: String): Int = {
    val dp = Array.fill[Int](s.length)(0)
    (1 until s.length).foldLeft(0) { case (m, i) =>
      if (s.charAt(i) == ')')
        if (s.charAt(i - 1) == '(')
          dp(i) = (if (i >= 2) dp(i - 2) else 0) + 2
        else if (i - dp(i - 1) > 0 && s.charAt(i - dp(i - 1) - 1) == '(')
          dp(i) = dp(i - 1) + (if (i - dp(i - 1) >= 2) dp(i - dp(i - 1) - 2) else 0) + 2
      m max dp(i)
    }
  }

  println(longestValidParentheses("())((())"))
  println(longestValidParentheses("()"))
  println(longestValidParentheses(")("))
  println(longestValidParentheses("(()"))
  println(longestValidParentheses(")()())"))
  println(longestValidParentheses("()(()"))
}
//Runtime: 643 ms, faster than 72.00% of Scala online submissions for Longest Valid Parentheses.
//Memory Usage: 70 MB, less than 60.00% of Scala online submissions for Longest Valid Parentheses.