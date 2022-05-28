package com.soumen.leetcodesolutions
package simple.missingnumber

/**
 * <a href="https://leetcode.com/problems/missing-number/submissions/">
 * 268. Missing Number
 * </a>
 * */
object MissingNumber extends App {
  def missingNumber(nums: Array[Int]): Int = {
    val dp = Array.fill[Int](nums.length + 1)(Int.MinValue)
    nums.foreach(n => dp(n) = 1)
    (0 to nums.length).find(i => dp(i) < 0).get
  }

  println(missingNumber(Array(3, 0, 1)))
  println(missingNumber(Array(0, 1)))
  println(missingNumber(Array(9, 6, 4, 2, 3, 5, 7, 0, 1)))
}
//Runtime: 1223 ms, faster than 6.17% of Scala online submissions for Missing Number.
//Memory Usage: 85.3 MB, less than 41.98% of Scala online submissions for Missing Number.