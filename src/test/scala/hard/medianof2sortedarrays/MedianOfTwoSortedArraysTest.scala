package com.soumen.leetcodesolutions
package hard.medianof2sortedarrays

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should

class MedianOfTwoSortedArraysTest extends AnyFreeSpec with should.Matchers {
  val medianOfTwoSortedArrays = MedianOfTwoSortedArrays
  "MedianOfTwoSortedArrays" - {
    "Should find the median for total odd length array" in {
      medianOfTwoSortedArrays.findMedianSortedArrays(Array(1, 3), Array(2)) should be(2.0)
      medianOfTwoSortedArrays.findMedianSortedArrays(Array(1, 3, 5, 7, 9), Array(2, 4)) should be(4.0)
    }
    "Should find the median for total even length array" in {
      medianOfTwoSortedArrays.findMedianSortedArrays(Array(1, 2), Array(3, 4)) should be(2.5)
    }
  }
}
