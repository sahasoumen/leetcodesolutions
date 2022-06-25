package com.soumen.leetcodesolutions
package medium.nondecreasingarray

/**
 * <a href="https://leetcode.com/problems/non-decreasing-array/">
 * 665. Non-decreasing Array
 * </a>
 * */
object NonDecreasingArray extends App {
  def checkPossibility(nums: Array[Int]): Boolean = {

    @scala.annotation.tailrec
    def helper(i: Int = 1, mismatch: Int = 0, last: Int = nums.head): Boolean =
      if (i == nums.length) true
      else if (nums(i) >= last) helper(i + 1, mismatch, nums(i))
      else if (mismatch > 0) false
      else if (i == nums.length - 1) true
      else if (nums(i - 1) <= nums(i + 1)) helper(i + 1, mismatch + 1, nums(i))
      else if (i == 1 && nums(i) <= nums(i + 1)) helper(i + 1, mismatch + 1, nums(i))
      else if (i > 1 && nums(i - 2) <= nums(i)) helper(i + 1, mismatch + 1, nums(i))
      else false


    helper()
  }

  println(checkPossibility(Array(4, 2, 3))) //true
  println(checkPossibility(Array(4, 2, 1))) // false
  println(checkPossibility(Array(-1, 4, 2, 3))) //true
  println(checkPossibility(Array(1, 1, 1))) //true
  println(checkPossibility(Array(5, 7, 1, 8))) //true
  println(checkPossibility(Array(3, 4, 2, 3))) //false
  println(checkPossibility(Array(1, 4, 1, 2))) //false
}
//Runtime: 1217 ms, faster than 100.00% of Scala online submissions for Non-decreasing Array.
//Memory Usage: 85 MB, less than 100.00% of Scala online submissions for Non-decreasing Array.