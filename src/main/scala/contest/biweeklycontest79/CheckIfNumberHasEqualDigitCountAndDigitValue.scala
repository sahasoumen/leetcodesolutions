package com.soumen.leetcodesolutions
package contest.biweeklycontest79

/**
 * <a href = "https://leetcode.com/contest/biweekly-contest-79/problems/check-if-number-has-equal-digit-count-and-digit-value/">
 * 6083. Check if Number Has Equal Digit Count and Digit Value
 * </a> */
object CheckIfNumberHasEqualDigitCountAndDigitValue extends App {
  @scala.annotation.tailrec
  def digitCount(num: String, i: Int = 0): Boolean =
    if (i == num.length) true
    else if (num(i) - '0' == num.count(_.toInt - '0' == i)) digitCount(num, i + 1)
    else false

  println(digitCount("1210"))
  println(digitCount("030"))
}
