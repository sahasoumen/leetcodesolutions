package com.soumen.leetcodesolutions
package medium.minimummovestoequalarrayelementsii

/**
 * <a href="https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/">
 * 462. Minimum Moves to Equal Array Elements II
 * </a>
 * */
object MinimumMovesToEqualArrayElementsII extends App {

  def minMoves2(nums: Array[Int]): Int = nums.sorted(Ordering.Int)(nums.length / 2) match {
    case mid => nums.map(n => Math.abs(mid - n)).sum
  }

  println(minMoves2(Array(1, 2, 3))) //2
  println(minMoves2(Array(1, 10, 2, 9))) //16
  println(minMoves2(Array(1, 0, 0, 8, 6))) //14
}
//Runtime: 1056 ms, faster than 50.00% of Scala online submissions for Minimum Moves to Equal Array Elements II.
//Memory Usage: 79.4 MB, less than 50.00% of Scala online submissions for Minimum Moves to Equal Array Elements II.