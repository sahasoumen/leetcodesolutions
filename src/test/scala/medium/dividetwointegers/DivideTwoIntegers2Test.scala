package com.soumen.leetcodesolutions
package medium.dividetwointegers

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should

class DivideTwoIntegers2Test extends AnyFreeSpec with should.Matchers {

  "Divide" - {
    "Should be able to handle 0" in {
      DivideTwoIntegers2.divide(0, 1) should be(0)
      DivideTwoIntegers2.divide(0, -1) should be(0)
    }
    "Should be able to handle Int.MinValue" in {
      DivideTwoIntegers2.divide(Int.MinValue, 1) should be(Int.MinValue)
      DivideTwoIntegers2.divide(Int.MinValue, -1) should be(Int.MaxValue)
      DivideTwoIntegers2.divide(Int.MinValue, Int.MinValue) should be(1)
      DivideTwoIntegers2.divide(Int.MinValue, -2) should be(1073741824)
      DivideTwoIntegers2.divide(Int.MinValue, 2) should be(-1073741824)
    }
    "Should be able to handle division by -2" in {
      DivideTwoIntegers2.divide(1, -1) should be(-1)
    }
    "Should be able to handle positive integers" in{
      DivideTwoIntegers2.divide(10, 3) should be(3)
    }
    "Should be able to handle negative divisors" in{
      DivideTwoIntegers2.divide(7, -3) should be(-2)
    }
  }
}
