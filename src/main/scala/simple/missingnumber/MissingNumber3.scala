package com.soumen.leetcodesolutions
package simple.missingnumber

/**
 * <a href="https://leetcode.com/problems/missing-number/submissions/">
 * 268. Missing Number
 * </a>
 * */
object MissingNumber3 extends App {
  def missingNumber(nums: Array[Int]): Int = (nums ++ (0 to nums.length)).reduce(_ ^ _)

  println(missingNumber(Array(3, 0, 1)))
  println(missingNumber(Array(0, 1)))
  println(missingNumber(Array(9, 6, 4, 2, 3, 5, 7, 0, 1)))
}
//Runtime: 1044 ms, faster than 27.16% of Scala online submissions for Missing Number.
//Memory Usage: 86.2 MB, less than 9.88% of Scala online submissions for Missing Number.