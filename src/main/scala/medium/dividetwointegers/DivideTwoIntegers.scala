package com.soumen.leetcodesolutions
package medium.dividetwointegers

/**
 * <a href = "https://leetcode.com/problems/divide-two-integers/">
 * 29. Divide Two Integers
 * </a>
 * */
object DivideTwoIntegers extends App {

  def divide(dividend: Int, divisor: Int): Int = {
    @scala.annotation.tailrec
    def divide(dividend: Long, divisor: Int, quotient: Int = 0): Int = if (dividend < divisor) quotient else divide(dividend - divisor, divisor, quotient + 1)

    def negate(n: Int) = if (n == Int.MinValue) Int.MaxValue else -n

    dividend -> divisor match {
      case (0, _) => 0
      case (_, 1) => dividend
      case (_, -1) => negate(dividend)
      case (Int.MinValue, Int.MinValue) => 1
      case (_, Int.MinValue) => 0
      case (Int.MinValue, divisor) if divisor > 0 => -divide(Int.MaxValue - divisor + 1, divisor, 1)
      case (Int.MinValue, divisor) if divisor < 0 => divide(Int.MaxValue - negate(divisor) + 1, negate(divisor), 1)
      case (dividend, divisor) if dividend > 0 && divisor > 0 => divide(dividend, divisor)
      case (dividend, divisor) if dividend > 0 && divisor < 0 => -divide(dividend, negate(divisor))
      case (dividend, divisor) if dividend < 0 && divisor < 0 => divide(negate(dividend), negate(divisor))
      case (dividend, divisor) if dividend < 0 && divisor > 0 => -divide(negate(dividend), divisor)
    }
  }


  println(divide(10, 3))
  println(divide(7, -3))
  println(divide(-2147483648, -1))
  println(divide(-2147483648, 2))
  println(divide(-2147483648, -2))
  println(divide(2147483647, -2147483648))
  println(divide(-2147483648, -2147483648))
}
//Runtime: 2564 ms, faster than 25.00% of Scala online submissions for Divide Two Integers.
//Memory Usage: 63.6 MB, less than 58.33% of Scala online submissions for Divide Two Integers.