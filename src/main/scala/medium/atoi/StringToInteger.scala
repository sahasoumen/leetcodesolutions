package com.soumen.leetcodesolutions
package medium.atoi

/**
 * https://leetcode.com/problems/string-to-integer-atoi/
 */
object StringToInteger extends App {
  def myAtoi(s: String): Int = {
    @scala.annotation.tailrec
    def atoi(s: String, pos: Int = 0, result: Int = 0, negate: Boolean = false, first: Boolean = true, hasChar: Boolean = false, hasSign: Boolean = false): Int = {
      def res = if (negate) -result else result

      if (s.length == pos) res else s.charAt(pos) match {
        case ' ' => atoi(s, pos + 1, result, negate, first, !first)
        case '.' => res
        case '-' => if (hasSign) res else atoi(s, pos + 1, result, negate = true, first = false, hasChar = hasChar, hasSign = true)
        case '+' => if (hasSign) res else atoi(s, pos + 1, result, first = false, hasChar = hasChar, hasSign = true)
        case d if d.isDigit => if (hasChar) res else {
          val r = d - '0' + result * 10
          if (r / 10 != result) if (negate) Int.MinValue else Int.MaxValue else atoi(s, pos + 1, r, negate, first = false, hasChar = hasChar, hasSign = true)
        }
        case _ => if (first) 0 else atoi(s, pos + 1, result, negate, first = false, hasChar = true, hasSign = true)
      }
    }

    atoi(s)
  }
}
//Runtime: 642 ms, faster than 80.85% of Scala online submissions for String to Integer (atoi).
//Memory Usage: 66 MB, less than 80.85% of Scala online submissions for String to Integer (atoi).