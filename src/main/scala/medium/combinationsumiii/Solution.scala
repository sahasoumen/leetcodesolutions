package com.soumen.leetcodesolutions
package medium.combinationsumiii

/**
 * https://leetcode.com/problems/combination-sum-iii/
 * 216. Combination Sum III */
object Solution extends App {
  def combinationSum3(k: Int, n: Int): List[List[Int]] = {
    val nums = (1 to 9).toList

    @scala.annotation.tailrec
    def combinations(l: List[List[Int]] = nums.map(List(_))): List[List[Int]] = if (l.head.length == k)
      l.filter(_.sum == n)
    else combinations(l.flatMap(sl => nums.filterNot(sl contains _).map(_ +: sl).map(_.sorted)).distinct)

    combinations()
  }

  println(combinationSum3(3, 7))
  println(combinationSum3(3, 9))
}
//Runtime: 605 ms, faster than 88.89% of Scala online submissions for Combination Sum III.
//Memory Usage: 52.8 MB, less than 100.00% of Scala online submissions for Combination Sum III.