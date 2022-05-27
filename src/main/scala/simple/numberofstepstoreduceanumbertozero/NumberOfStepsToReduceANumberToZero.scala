package com.soumen.leetcodesolutions
package simple.numberofstepstoreduceanumbertozero

/**
 * <a href="https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/">
 * 1342. Number of Steps to Reduce a Number to Zero
 * </a>
 * */
object NumberOfStepsToReduceANumberToZero extends App {
  @scala.annotation.tailrec
  def numberOfSteps(num: Int, step: Int = 0): Int = if (num == 0) step else numberOfSteps(if ((num & 1) == 0) num / 2 else num - 1, step + 1)

  println(numberOfSteps(14))
  println(numberOfSteps(8))
  println(numberOfSteps(123))

  println(14.toBinaryString)
  println(8.toBinaryString)
  println(123.toBinaryString)
}
//Runtime: 586 ms, faster than 65.00% of Scala online submissions for Number of Steps to Reduce a Number to Zero.
//Memory Usage: 62.9 MB, less than 35.00% of Scala online submissions for Number of Steps to Reduce a Number to Zero.