package com.soumen.leetcodesolutions
package medium.reverseinteger

import scala.annotation.tailrec

/**
 * https://leetcode.com/problems/reverse-integer/
 */
object ReverseInteger extends App {
  @tailrec
  def reverse(x: Int, result: Int = 0): Int = x match {
    case 0 => result
    case _ => if (result * 10 / 10 != result) 0 else reverse(x / 10, result * 10 + x % 10)
  }
}

//Runtime: 677 ms, faster than 51.30% of Scala online submissions for Reverse Integer.
//Memory Usage: 63.3 MB, less than 55.65% of Scala online submissions for Reverse Integer.
