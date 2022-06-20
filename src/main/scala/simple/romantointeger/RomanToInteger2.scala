package com.soumen.leetcodesolutions
package simple.romantointeger

/**
 * <a href="https://leetcode.com/problems/roman-to-integer/">
 * 13. Roman to Integer
 * </a>
 * */
object RomanToInteger2 extends App {
  def romanToInt(s: String): Int = {
    val map = Map('I' -> 1, 'V' -> 5, 'X' -> 10, 'L' -> 50, 'C' -> 100, 'D' -> 500, 'M' -> 1000)
    s.map(map).foldRight((0, 0)) { case (c, (v, lastVal)) => (if (c < lastVal) v - c else v + c, c) }._1
  }

  println(romanToInt("III")) //3
  println(romanToInt("LVIII")) //58
  println(romanToInt("MCMXCIV")) //1994
}
//Runtime: 897 ms, faster than 51.04% of Scala online submissions for Roman to Integer.
//Memory Usage: 74.9 MB, less than 34.72% of Scala online submissions for Roman to Integer.