package com.soumen.leetcodesolutions
package hard.candy

/**
 * <a href="https://leetcode.com/problems/candy/">
 * 135. Candy
 * </a>
 * */
object Candy2 extends App {
  def candy(ratings: Array[Int]): Int = {
    val leftScan = ratings.tail.scanLeft(1, ratings.head) { case ((lastCandy, lastRating), rating) =>
      if (rating > lastRating) lastCandy + 1 -> rating else 1 -> rating
    }

    ratings.init.scanRight(leftScan.last._1, ratings.last, ratings.length - 2) { case (rating, (lastCandy, lastRating, i)) =>
      if (rating > lastRating) ((lastCandy + 1).max(leftScan(i)._1), rating, i - 1) else (leftScan(i)._1, rating, i - 1)
    }.map(_._1).sum

  }

  println(candy(Array(1, 0, 2))) //5
  println(candy(Array(1, 2, 2))) //4
}
//Runtime: 1111 ms, faster than 33.33% of Scala online submissions for Candy.
//Memory Usage: 85.5 MB, less than 66.67% of Scala online submissions for Candy.