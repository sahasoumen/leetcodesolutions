package com.soumen.leetcodesolutions
package simple.sortarraybyparity

/**
 * https://leetcode.com/problems/sort-array-by-parity/
 * 905. Sort Array By Parity
 * */
object Solution2 extends App {
  def sortArrayByParity(nums: Array[Int]): Array[Int] = {
    nums.indices.foreach { i =>
      if (nums(i) % 2 != 0) {
        (i + 1 until nums.length).find(nums(_) % 2 == 0) match {
          case None =>
          case Some(j) => val t = nums(j)
            nums(j) = nums(i)
            nums(i) = t
        }
      }
    }
    nums
  }

  val nums = Array(3, 1, 2, 4)
  val sorted = sortArrayByParity(nums)
  println(sorted.toList)
}

//Runtime: 921 ms, faster than 35.71% of Scala online submissions for Sort Array By Parity.
//Memory Usage: 56.8 MB, less than 64.29% of Scala online submissions for Sort Array By Parity.