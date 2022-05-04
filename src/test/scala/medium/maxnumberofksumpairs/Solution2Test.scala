package com.soumen.leetcodesolutions
package medium.maxnumberofksumpairs

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should

class Solution2Test extends AnyFreeSpec with should.Matchers {
  val solution = Solution2
  "Max Number of K-Sum Pairs" - {
    "should work with simple example" in {
      solution.maxOperations(Array(1, 2, 3, 4), 5) should be(2)
    }
    "should work with duplicate" in {
      solution.maxOperations(Array(3, 1, 3, 4, 3), 6) should be(1)
    }

    "should be able to detect trivial arrays" in {
      solution.maxOperations(Array(), 2) should be(0)
      solution.maxOperations(Array(1), 2) should be(0)
    }
    "should be able to detect many duplicate elements" in {
      solution.maxOperations(Array(2, 5, 4, 4, 1, 3, 4, 4, 1, 4, 4, 1, 2, 1, 2, 2, 3, 2, 4, 2), 3) should be(4)
      solution.maxOperations(Array(2, 2, 2, 3, 1, 1, 4, 1), 4) should be(2)
      solution.maxOperations(Array(2, 5, 4, 4, 1, 3, 4, 4, 1, 4, 4, 1, 2, 1, 2, 2, 3, 2, 4, 2), 3) should be(4)

    }

  }
}