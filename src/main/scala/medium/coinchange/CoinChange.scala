package com.soumen.leetcodesolutions
package medium.coinchange

/**
 * <a href = "https://leetcode.com/problems/coin-change/">
 * 322. Coin Change
 * </a>
 * */
object CoinChange extends App {
  def coinChange(coins: Array[Int], amount: Int): Int = {
    val dp = Array.fill(amount + 1)(Int.MaxValue)
    dp(0) = 0
    for {
      i <- dp.indices
      c <- coins if c <= i && dp(i - c) != Int.MaxValue
    } yield dp(i) = dp(i).min(dp(i - c) + 1)
    if (dp(amount) == Int.MaxValue) -1 else dp(amount)
  }

  println(coinChange(Array(1, 2, 5), 11))
  println(coinChange(Array(3, 4), 13))
  println(coinChange(Array(3, 4), 22))
  println(coinChange(Array(2), 3))
  println(coinChange(Array(1), 0))
  println(coinChange(Array(186, 419, 83, 408), 6249))
}

//Runtime: 713 ms, faster than 80.00% of Scala online submissions for Coin Change.
//Memory Usage: 54.3 MB, less than 85.45% of Scala online submissions for Coin Change.