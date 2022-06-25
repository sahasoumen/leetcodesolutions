package com.soumen.leetcodesolutions
package contest.biweeklycontest81.maximumxorafteroperations

/**
 * <a href="https://leetcode.com/contest/biweekly-contest-81/problems/maximum-xor-after-operations/">
 *    6105. Maximum XOR After Operations
 * </a>
 * */
object MaximumXORAfterOperations extends App {
  def maximumXOR(nums: Array[Int]): Int = nums.reduce(_ | _)

  println(maximumXOR(Array(3, 2, 4, 6))) //7
  println(maximumXOR(Array(1, 2, 3, 9, 2))) //11
  //1023
  println(maximumXOR(Array(316, 596, 98, 287, 341, 246, 386, 916, 758, 258, 341, 580, 31, 59, 41, 739, 262, 32, 93, 209, 562, 854, 641, 533, 275, 96, 815, 176, 524, 629, 698, 299, 148, 791, 951, 11, 653, 890, 53, 309, 642, 355, 694, 496, 124, 114, 67, 77, 172, 520, 129, 912, 421, 834, 375, 823, 172, 546, 269, 851, 452, 321, 357, 371, 812, 715, 598, 18, 988, 844, 4, 198, 596, 830, 865, 433, 645, 665)))
}

//Runtime: 1313 ms, faster than 100.00% of Scala online submissions for Maximum XOR After Operations .
//Memory Usage: 92.7 MB, less than 100.00% of Scala online submissions for Maximum XOR After Operations .