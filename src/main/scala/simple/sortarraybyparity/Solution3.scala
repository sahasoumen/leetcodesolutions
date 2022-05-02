package com.soumen.leetcodesolutions
package simple.sortarraybyparity

/**
 * https://leetcode.com/problems/sort-array-by-parity/
 * 905. Sort Array By Parity
 * */
object Solution3 extends App {
  def sortArrayByParity(nums: Array[Int]): Array[Int] = nums.foldLeft((Array.empty[Int], Array.empty[Int])) { case ((s1, s2), n) => if (n % 2 == 0) (s1 :+ n, s2) else (s1, s2 :+ n) } match {
    case (s1, s2) => s1 ++ s2
  }

  val nums = Array(3, 1, 2, 4)
  val sorted = sortArrayByParity(nums)
  println(sorted.toList)
}

//Runtime: 1152 ms, faster than 7.14% of Scala online submissions for Sort Array By Parity.
//Memory Usage: 120.6 MB, less than 14.29% of Scala online submissions for Sort Array By Parity.