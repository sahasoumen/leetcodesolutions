package com.soumen.leetcodesolutions
package medium.reverseinteger

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should

class ReverseIntegerTest extends AnyFreeSpec with should.Matchers {
  val reverseInteger = ReverseInteger
  "Reverse Integer " - {
    "reverse string of digits into integer" in {
      reverseInteger.reverse(123) should be(321)
    }
    "should remove leading zeros" in {
      reverseInteger.reverse(120) should be(21)
    }
    "should keep signs" in {
      reverseInteger.reverse(-123) should be(-321)
      reverseInteger.reverse(-1463847412) should be(-2147483641)
    }
    "should be zero when exceeds max value" in {
      reverseInteger.reverse(1534236469) should be(0)
    }
  }
}
