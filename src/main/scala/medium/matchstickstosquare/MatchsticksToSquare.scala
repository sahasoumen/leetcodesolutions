package com.soumen.leetcodesolutions
package medium.matchstickstosquare

/**
 * <a href="https://leetcode.com/problems/matchsticks-to-square/">
 * 473. Matchsticks to Square
 * </a>
 * */
object MatchsticksToSquare extends App {
  def makesquare(matchsticks: Array[Int]): Boolean = {
    def helper(remaining: Array[Int], target: Int): Boolean =
      remaining.isEmpty || (1 to remaining.length).exists(remaining.combinations(_).exists(c => c.sum == target && helper(remaining.diff(c), target)))

    matchsticks.length >= 4 && matchsticks.sum % 4 == 0 && helper(matchsticks, matchsticks.sum / 4)
  }

  println(makesquare(Array(1, 1, 2, 2, 2))) //true
  println(makesquare(Array(3, 3, 3, 3, 4))) //false
  println(makesquare(Array(1, 2, 3, 4, 5, 6))) //false
}
//Runtime: 1944 ms, faster than 100.00% of Scala online submissions for Matchsticks to Square.
//Memory Usage: 124.1 MB, less than 100.00% of Scala online submissions for Matchsticks to Square.