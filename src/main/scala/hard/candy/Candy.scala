package com.soumen.leetcodesolutions
package hard.candy

/**
 * <a href="https://leetcode.com/problems/candy/">
 * 135. Candy
 * </a>
 * */
object Candy extends App {
  def candy(ratings: Array[Int]): Int = {
    val leftScan = ratings.indices.tail.scan(1) {
      case (lastCandy, i) => if (ratings(i) > ratings(i - 1)) lastCandy + 1 else 1
    }

    ratings.indices.init.scanRight(leftScan.last) { case (i, lastCandy) =>
      if (ratings(i) > ratings(i + 1)) (lastCandy + 1).max(leftScan(i)) else leftScan(i)
    }.sum
  }

  println(candy(Array(1, 0, 2))) //5
  println(candy(Array(1, 2, 2))) //4
}
//Runtime: 1216 ms, faster than 33.33% of Scala online submissions for Candy.
//Memory Usage: 86.9 MB, less than 33.33% of Scala online submissions for Candy.