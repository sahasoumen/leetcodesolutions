package com.soumen.leetcodesolutions
package medium.atoi

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should

class StringToIntegerTest extends AnyFreeSpec with should.Matchers {
  "ATOI" - {
    "parse an string to integer" in {
      StringToInteger.myAtoi("42") should be(42)
      StringToInteger.myAtoi("-42") should be(-42)
      StringToInteger.myAtoi(Int.MaxValue.toString) should be(Int.MaxValue)
      StringToInteger.myAtoi(Int.MinValue.toString) should be(Int.MinValue)
    }

    "parse an string with spaces to integer" in {
      StringToInteger.myAtoi("   42") should be(42)
      StringToInteger.myAtoi("   42  ") should be(42)
      StringToInteger.myAtoi("   -42") should be(-42)
      StringToInteger.myAtoi("   -42  ") should be(-42)
      StringToInteger.myAtoi("   +0 123") should be(0)
      StringToInteger.myAtoi("00000-42a1234") should be(0)
    }
    "parse an string with signs to integer" in {
      StringToInteger.myAtoi("   +42") should be(42)
      StringToInteger.myAtoi("   +42+") should be(42)
      StringToInteger.myAtoi("   -42") should be(-42)
      StringToInteger.myAtoi("   -42-") should be(-42)
      StringToInteger.myAtoi("-+12") should be(0)
      StringToInteger.myAtoi("-5-") should be(-5)
      StringToInteger.myAtoi("-13+8") should be(-13)
    }
    "parse an string with alphabets to integer" in {
      StringToInteger.myAtoi("4193 with words") should be(4193)
      StringToInteger.myAtoi("words and 987") should be(0)
      StringToInteger.myAtoi("3.14159") should be(3)
      StringToInteger.myAtoi("  -0012a42") should be(-12)
    }
    "parse an string with edge cases to integer" in {
      StringToInteger.myAtoi(Int.MaxValue.toString) should be(Int.MaxValue)
      StringToInteger.myAtoi(Int.MinValue.toString) should be(Int.MinValue)
      StringToInteger.myAtoi((Int.MaxValue - 1).toString) should be(Int.MaxValue - 1)
      StringToInteger.myAtoi((Int.MinValue + 1).toString) should be(Int.MinValue + 1)
      StringToInteger.myAtoi((Int.MaxValue.toLong + 1).toString) should be(Int.MaxValue)
      StringToInteger.myAtoi((Int.MinValue.toLong - 1).toString) should be(Int.MinValue)
    }
    "parse an string with boundary cases to integer" in {
      StringToInteger.myAtoi("-91283472332") should be(-2147483648)
      StringToInteger.myAtoi("2147483648") should be(2147483647)
    }
  }
}
