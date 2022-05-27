package com.soumen.leetcodesolutions
package simple.numberofstepstoreduceanumbertozero

/**
 * <a href="https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/">
 * 1342. Number of Steps to Reduce a Number to Zero
 * </a>
 * */
object NumberOfStepsToReduceANumberToZero4 extends App {
  @scala.annotation.tailrec
  def numberOfSteps(num: Int, steps: Int = 0): Int = num match {
    case 0 | 1 => steps + num
    case _ => numberOfSteps(num >>> 1, steps + (num & 1) + 1)
  }

  println(numberOfSteps(0))
  println(numberOfSteps(14))
  println(numberOfSteps(8))
  println(numberOfSteps(123))

}
//Runtime: 609 ms, faster than 55.00% of Scala online submissions for Number of Steps to Reduce a Number to Zero.
//Memory Usage: 62.8 MB, less than 35.00% of Scala online submissions for Number of Steps to Reduce a Number to Zero.