package com.soumen.leetcodesolutions
package simple.numberof1bits

/**
 * <a href ="https://leetcode.com/problems/number-of-1-bits/submissions/">
 * 191. Number of 1 Bits
 * </a> */
object NumberOf1Bits extends App {
  // you need treat n as an unsigned value
  @scala.annotation.tailrec
  def hammingWeight(n: Int, weight: Int = 0): Int = if (n == 0) weight else hammingWeight(n >>> 1, weight + (n & 1))

  println(hammingWeight("00000000000000000000000000001011".toInt))
}
//Runtime: 620 ms, faster than 55.32% of Scala online submissions for Number of 1 Bits.
//Memory Usage: 63.6 MB, less than 34.04% of Scala online submissions for Number of 1 Bits.