package com.soumen.leetcodesolutions
package hard.russiandollenvelopes

import java.time.Duration

/**
 * <a href = "https://leetcode.com/problems/russian-doll-envelopes/submissions/">
 * 354. Russian Doll Envelopes
 * </a>
 * */
object RussianDollEnvelopes extends App {

  def maxEnvelopes(envelopes: Array[Array[Int]]): Int = envelopes.sortBy(e => e(0) -> -e(1)).map(_ (1)) match {
    case sorted => val dp = Array.fill[Int](envelopes.length)(1)
      (1 until sorted.length).foldLeft(1) { case (max, i) =>
        for (j <- 0 until i if sorted(i) > sorted(j) && dp(i) <= dp(j)) dp(i) = dp(i) + 1
        max max dp(i)
      }
  }

  //  println(maxEnvelopes(Array(Array(5, 4), Array(6, 4), Array(6, 7), Array(2, 3))))
  //  println(maxEnvelopes(Array(Array(1, 1), Array(1, 1), Array(1, 1), Array(1, 1))))
  //  println(maxEnvelopes(Array(Array(4, 5), Array(4, 6), Array(6, 7), Array(2, 3), Array(1, 1))))
  val envelopes = (1 to 100000).map(i => Array(i, i)).toArray
  val start = System.currentTimeMillis
  println(maxEnvelopes(envelopes))
  println(s"Time Taken: ${Duration.ofMillis(System.currentTimeMillis - start)}")
}
//Time Limit Exceeded