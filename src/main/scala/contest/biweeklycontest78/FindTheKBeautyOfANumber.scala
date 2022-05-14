package com.soumen.leetcodesolutions
package contest.biweeklycontest78

/**
 * https://leetcode.com/contest/biweekly-contest-78/problems/find-the-k-beauty-of-a-number/
 * 5299. Find the K-Beauty of a Number
 * */
object FindTheKBeautyOfANumber extends App {
  def divisorSubstrings(num: Int, k: Int): Int = num.toString.sliding(k).map(_.toInt).filterNot(_ == 0).count(num % _ == 0)

  println(divisorSubstrings(240, 2))
  println(divisorSubstrings(430043, 2))
}
