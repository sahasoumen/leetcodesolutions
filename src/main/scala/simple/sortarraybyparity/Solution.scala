package com.soumen.leetcodesolutions
package simple.sortarraybyparity

/**
 * https://leetcode.com/problems/sort-array-by-parity/
 * 905. Sort Array By Parity
 * */
object Solution extends App {
  def sortArrayByParity(nums: Array[Int]): Array[Int] = nums.sortBy(_ % 2)

  val nums = Array(3, 1, 2, 4)
  val sorted = sortArrayByParity(nums)
  println(sorted.toList)
}

//Runtime: 947 ms, faster than 32.14% of Scala online submissions for Sort Array By Parity.
//Memory Usage: 78.1 MB, less than 17.86% of Scala online submissions for Sort Array By Parity.
