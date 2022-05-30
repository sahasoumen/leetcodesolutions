package com.soumen.leetcodesolutions
package medium.dividetwointegers

/**
 * <a href = "https://leetcode.com/problems/divide-two-integers/">
 * 29. Divide Two Integers
 * </a>
 * */
object DivideTwoIntegers2 extends App {

  def divide(dividend: Int, divisor: Int): Int = {
    @scala.annotation.tailrec
    def divide(dividend: Long, divisor: Int, quotient: Int = 0): Int = if (dividend < divisor) quotient else divide(dividend - divisor, divisor, quotient + 1)

    if (dividend == 0) 0
    else if (divisor == 1) dividend
    else if (dividend == divisor) 1
    else if (divisor == Int.MinValue) 0
    else if (dividend == Int.MinValue)
      if (divisor == -1) Int.MaxValue
      else if (divisor > 0) -divide(Int.MaxValue - divisor + 1, divisor, 1)
      else divide(Int.MaxValue + divisor + 1, -divisor, 1)
    else if (divisor == -1) -dividend
    else if (dividend > 0 && divisor > 0) divide(dividend, divisor)
    else if (dividend > 0 && divisor < 0) -divide(dividend, -divisor)
    else if (dividend < 0 && divisor < 0) divide(-dividend, -divisor)
    else -divide(-dividend, divisor)
  }


  println(divide(1, -1))
  println(divide(10, 3))
  println(divide(7, -3))
  println(divide(-2147483648, -1))
  println(divide(-2147483648, 2))
  println(divide(-2147483648, -2))
  println(divide(2147483647, -2147483648))
  println(divide(-2147483648, -2147483648))
}
//Runtime: 2947 ms, faster than 25.00% of Scala online submissions for Divide Two Integers.
//Memory Usage: 63.5 MB, less than 58.33% of Scala online submissions for Divide Two Integers.