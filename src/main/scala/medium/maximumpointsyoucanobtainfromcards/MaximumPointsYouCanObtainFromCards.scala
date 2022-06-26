package com.soumen.leetcodesolutions
package medium.maximumpointsyoucanobtainfromcards

/**
 * <a href="https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/">
 * 1423. Maximum Points You Can Obtain from Cards
 * </a>
 * */
object MaximumPointsYouCanObtainFromCards extends App {
  def maxScore(cardPoints: Array[Int], k: Int): Int = {
    val sliceSize = cardPoints.length - k

    @scala.annotation.tailrec
    def helper(i: Int = 0, sum: Int = 0, slicedSum: Int = 0, min: Int = 0): Int =
      if (i == cardPoints.length) sum - (min min slicedSum)
      else if (i < sliceSize) helper(i + 1, sum + cardPoints(i), sum + cardPoints(i), sum + cardPoints(i))
      else helper(i + 1, sum + cardPoints(i), slicedSum + cardPoints(i) - cardPoints(i - sliceSize), min min slicedSum)

    helper()
  }

  println(maxScore(Array(1, 2, 3, 4, 5, 6, 1), 3)) //12
  println(maxScore(Array(2, 2, 2), 2)) //4
  println(maxScore(Array(9, 7, 7, 9, 7, 7, 9), 7)) //55
}

//Runtime: 996 ms, faster than 75.00% of Scala online submissions for Maximum Points You Can Obtain from Cards.
//Memory Usage: 91.5 MB, less than 16.67% of Scala online submissions for Maximum Points You Can Obtain from Cards.