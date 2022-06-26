package com.soumen.leetcodesolutions
package medium.maximumpointsyoucanobtainfromcards

/**
 * <a href="https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/">
 * 1423. Maximum Points You Can Obtain from Cards
 * </a>
 * */
object MaximumPointsYouCanObtainFromCards2 extends App {
  def maxScore(cardPoints: Array[Int], k: Int): Int = {
    val sliceSize = cardPoints.length - k

    @scala.annotation.tailrec
    def helper(i: Int = 0, sum: Int = 0, slicedSum: Int = 0, min: Int = 0): Int =
      if (i == cardPoints.length) sum - (min min slicedSum)
      else sum + cardPoints(i) match {
        case s => if (i < sliceSize) helper(i + 1, s, s, s) else helper(i + 1, s, slicedSum + cardPoints(i) - cardPoints(i - sliceSize), min min slicedSum)
      }

    helper()
  }

  println(maxScore(Array(1, 2, 3, 4, 5, 6, 1), 3)) //12
  println(maxScore(Array(2, 2, 2), 2)) //4
  println(maxScore(Array(9, 7, 7, 9, 7, 7, 9), 7)) //55
}
//Runtime: 1343 ms, faster than 33.33% of Scala online submissions for Maximum Points You Can Obtain from Cards.
//Memory Usage: 91.9 MB, less than 8.33% of Scala online submissions for Maximum Points You Can Obtain from Cards.