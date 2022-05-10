package com.soumen.leetcodesolutions
package medium.combinationsumiii

/**
 * https://leetcode.com/problems/combination-sum-iii/
 * 216. Combination Sum III
 * */
object Solution3 extends App {
  def combinationSum3(k: Int, n: Int): List[List[Int]] = {
    val nums = (1 to 9).toList

    @scala.annotation.tailrec
    def combinations(l: List[List[Int]] = nums.filter(_ < n).map(List(_))): List[List[Int]] = if (l.isEmpty || l.head.length == k)
      l.filter(_.sum == n)
    else combinations(l.flatMap(sl => nums.filterNot(sl contains _).map(_ +: sl).filter(_.sum <= n).filter(_.nonEmpty).map(_.sorted)).distinct)

    combinations()
  }

  println(combinationSum3(3, 7))
  println(combinationSum3(3, 9))
  println(combinationSum3(4, 1))
}
//Runtime: 952 ms, faster than 22.22% of Scala online submissions for Combination Sum III.
//Memory Usage: 70.8 MB, less than 11.11% of Scala online submissions for Combination Sum III.