package com.soumen.leetcodesolutions
package simple.numberofstepstoreduceanumbertozero

/**
 * <a href="https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/">
 * 1342. Number of Steps to Reduce a Number to Zero
 * </a>
 * */
object NumberOfStepsToReduceANumberToZero2 extends App {
  def numberOfSteps(num: Int): Int = if (num == 0) 0 else {
    @scala.annotation.tailrec
    def steps(num: Int, step: Int = 0): Int = if (num == 0) step - 1 else steps(num >>> 1, step + (num & 1) + 1)

    steps(num)
  }

  println(numberOfSteps(14))
  println(numberOfSteps(8))
  println(numberOfSteps(123))

}
//Runtime: 655 ms, faster than 30.00% of Scala online submissions for Number of Steps to Reduce a Number to Zero.
//Memory Usage: 63.1 MB, less than 5.00% of Scala online submissions for Number of Steps to Reduce a Number to Zero.