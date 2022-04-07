package com.soumen.leetcodesolutions
package simple.twosum

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should

class TwoSumSortedTest extends AnyFreeSpec with should.Matchers {
  val twoSum = TwoSum

  "Two Sum" - {
    "Should find the sum of 2 elements from an array " in {
      twoSum.twoSum(Array(2, 7, 11, 15), 9) should be(Array(0, 1))
      twoSum.twoSum(Array(3, 2, 4), 6) should be(Array(1, 2))
      twoSum.twoSum(Array(3, 3), 6) should be(Array(0, 1))
    }
  }
}
