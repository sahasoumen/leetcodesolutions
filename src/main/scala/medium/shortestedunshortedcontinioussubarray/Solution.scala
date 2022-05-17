package com.soumen.leetcodesolutions
package medium.shortestedunshortedcontinioussubarray

/*
* <a heref="https://leetcode.com/problems/shortest-unsorted-continuous-subarray/">
*   581. Shortest Unsorted Continuous Subarray
* </a>
* */
object Solution extends App {
  def findUnsortedSubarray(nums: Array[Int]): Int = {
    @scala.annotation.tailrec
    def find(start: Int = 0, end: Int = nums.length - 1, sorted: Array[Int] = nums.sorted): Int = {
      if (start >= end) 0
      else if (nums(start) != sorted(start))
        if (nums(end) != sorted(end)) end - start + 1
        else find(start, end - 1, sorted)
      else find(start + 1, end, sorted)
    }

    find()
  }

  val nums = Array(1, 3, 4, 2, 5)
  println(findUnsortedSubarray(nums))
}
//Runtime: 1104 ms, faster than 46.81% of Scala online submissions for Shortest Unsorted Continuous Subarray.
//Memory Usage: 86.2 MB, less than 36.17% of Scala online submissions for Shortest Unsorted Continuous Subarray.