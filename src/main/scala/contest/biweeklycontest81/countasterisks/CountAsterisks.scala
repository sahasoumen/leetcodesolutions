package com.soumen.leetcodesolutions
package contest.biweeklycontest81.countasterisks

/**
 * <a href="https://leetcode.com/contest/biweekly-contest-81/problems/count-asterisks/">
 * 2315. Count Asterisks
 * </a>
 * */
object CountAsterisks extends App {
  def countAsterisks(s: String): Int =
    s.foldLeft((false, 0)) { case ((pair, count), c) =>
      c match {
        case '|' => !pair -> count
        case '*' => pair -> (if (pair) count else count + 1)
        case _ => pair -> count
      }
    }._2

  println(countAsterisks("l|*e*et|c**o|*de|")) //2
  println(countAsterisks("iamprogrammer")) //0
  println(countAsterisks("yo|uar|e**|b|e***au|tifu|l")) //5
}
