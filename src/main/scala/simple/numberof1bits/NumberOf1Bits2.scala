package com.soumen.leetcodesolutions
package simple.numberof1bits

/**
 * <a href ="https://leetcode.com/problems/number-of-1-bits/submissions/">
 * 191. Number of 1 Bits
 * </a> */
object NumberOf1Bits2 extends App {
  // you need treat n as an unsigned value
  @scala.annotation.tailrec
  def hammingWeight(n: Int, weight: Int = 0): Int = if (n == 0) weight else hammingWeight(n & n - 1, weight + 1)

  println(hammingWeight("00000000000000000000000000001011".toInt))
}
//Runtime: 723 ms, faster than 34.04% of Scala online submissions for Number of 1 Bits.
//Memory Usage: 63.8 MB, less than 19.15% of Scala online submissions for Number of 1 Bits.