package com.soumen.leetcodesolutions
package simple.romantointeger

/**
 * <a href="https://leetcode.com/problems/roman-to-integer/">
 * 13. Roman to Integer
 * </a>
 * */
object RomanToInteger extends App {
  def romanToInt(s: String): Int = {
    val map = Map('I' -> 1, 'V' -> 5, 'X' -> 10, 'L' -> 50, 'C' -> 100, 'D' -> 500, 'M' -> 1000, '0' -> 0)
    s.foldRight((0, '0')) { case (c, (v, last)) =>
      (c -> last match {
        case ('I', 'V' | 'X') => v - 1
        case ('X', 'L' | 'C') => v - 10
        case ('C', 'D' | 'M') => v - 100
        case (c, _) => v + map(c)
      }) -> c
    }._1
  }

  println(romanToInt("III")) //3
  println(romanToInt("LVIII")) //58
  println(romanToInt("MCMXCIV")) //1994
}
//Runtime: 991 ms, faster than 34.73% of Scala online submissions for Roman to Integer.
//Memory Usage: 77.3 MB, less than 25.70% of Scala online submissions for Roman to Integer.