package com.soumen.leetcodesolutions
package contest.weeklycontest298.sellingpiecesofwood

/**
 * <a href="https://leetcode.com/contest/weekly-contest-298/problems/selling-pieces-of-wood/">
 * 5254. Selling Pieces of Wood
 * </a>
 * */
object SellingPiecesOfWood extends App {
  def sellingWood(m: Int, n: Int, prices: Array[Array[Int]]): Long = {
    val dp = Array.ofDim[Long](m + 1, n + 1)
    prices.foreach(p => dp(p(0))(p(1)) = p(2))
    for (w <- 1 to m; h <- 1 to n) {
      for (a <- 1 to w / 2) dp(w)(h) = dp(w)(h) max dp(a)(h) + dp(w - a)(h)
      for (a <- 1 to h / 2) dp(w)(h) = dp(w)(h) max dp(w)(a) + dp(w)(h - a)
    }
    dp(m)(n)
  }

  println(sellingWood(3, 5, Array(Array(1, 4, 2), Array(2, 2, 7), Array(2, 1, 3))))
}
//Runtime: 867 ms, faster than 100.00% of Scala online submissions for Selling Pieces of Wood.
//Memory Usage: 65.1 MB, less than 100.00% of Scala online submissions for Selling Pieces of Wood.