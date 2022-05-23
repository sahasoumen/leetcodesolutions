package com.soumen.leetcodesolutions
package medium.onesandzeros

/**
 * <a href="https://leetcode.com/problems/ones-and-zeroes/discuss/1202374/scala-solution">
 * 474. Ones and Zeroes
 * </a> */
object OnesAndZeros extends App {
  def findMaxForm(strs: Array[String], m: Int, n: Int): Int = {
    val dp = Array.ofDim[Int](m + 1, n + 1)
    strs.foreach(_.foldLeft((0, 0)) { case ((m, n), c) => if (c == '0') (m + 1, n) else (m, n + 1) } match {
      case (z, o) => for (i <- m to z by -1; j <- n to o by -1) dp(i)(j) = dp(i)(j) max (dp(i - z)(j - o) + 1)
      println(dp.map(_.toSeq).foreach(println))
    })
    dp(m)(n)
  }

  println(findMaxForm(Array("10", "0001", "111001", "1", "0"), 5, 3))
}
//Runtime: 911 ms, faster than 100.00% of Scala online submissions for Ones and Zeroes.
//Memory Usage: 72.7 MB, less than 100.00% of Scala online submissions for Ones and Zeroes.