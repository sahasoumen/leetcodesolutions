package com.soumen.leetcodesolutions
package simple.missingnumber

/**
 * <a href="https://leetcode.com/problems/missing-number/submissions/">
 * 268. Missing Number
 * </a>
 * */
object MissingNumber2 extends App {
  def missingNumber(nums: Array[Int]): Int = nums.length * (nums.length + 1) / 2 - nums.sum

  println(missingNumber(Array(3, 0, 1)))
  println(missingNumber(Array(0, 1)))
  println(missingNumber(Array(9, 6, 4, 2, 3, 5, 7, 0, 1)))
}
//Runtime: 1059 ms, faster than 25.92% of Scala online submissions for Missing Number.
//Memory Usage: 84.8 MB, less than 58.02% of Scala online submissions for Missing Number.