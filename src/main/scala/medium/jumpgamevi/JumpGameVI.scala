package com.soumen.leetcodesolutions
package medium.jumpgamevi

/**
 * <a href="https://leetcode.com/problems/jump-game-vi/">
 * 1696. Jump Game VI
 * </a>
 * */
object JumpGameVI extends App {
  def maxResult(nums: Array[Int], k: Int): Int = {
    val dp = Array.ofDim[Int](nums.length)
    for (i <- nums.indices) {
      var max = Int.MinValue
      for (j <- 0 until (k min i))
        max = max max dp(i - j - 1)
      dp(i) = nums(i) + (if (max == Int.MinValue) 0 else max)
    }
    dp.last
  }

  println(maxResult(Array(1, -1, -2, 4, -7, 3), 2)) //7
  println(maxResult(Array(10, -5, -2, 4, 0, 3), 3)) //17
  println(maxResult(Array(1, -5, -20, 4, -1, 3, -6, -3), 2)) //0

}
//Runtime: 7732 ms, faster than 50.00% of Scala online submissions for Jump Game VI.
//Memory Usage: 81.8 MB, less than 100.00% of Scala online submissions for Jump Game VI.