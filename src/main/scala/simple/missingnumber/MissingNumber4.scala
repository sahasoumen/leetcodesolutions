package com.soumen.leetcodesolutions
package simple.missingnumber

/**
 * <a href="https://leetcode.com/problems/missing-number/submissions/">
 * 268. Missing Number
 * </a>
 * */
object MissingNumber4 extends App {
  def missingNumber(nums: Array[Int]): Int = nums.foldLeft(nums.length * (nums.length + 1) / 2)(_ - _)

  println(missingNumber(Array(3, 0, 1)))
  println(missingNumber(Array(0, 1)))
  println(missingNumber(Array(9, 6, 4, 2, 3, 5, 7, 0, 1)))
}
//Runtime: 622 ms, faster than 83.95% of Scala online submissions for Missing Number.
//Memory Usage: 54.7 MB, less than 96.30% of Scala online submissions for Missing Number.