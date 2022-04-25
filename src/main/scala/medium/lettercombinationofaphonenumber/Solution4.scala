package com.soumen.leetcodesolutions
package medium.lettercombinationofaphonenumber

object Solution4 extends App {
  val map = Map('2' -> List("a", "b", "c"), '3' -> List("d", "e", "f"), '4' -> List("g", "h", "i"), '5' -> List("j", "k", "l"),
    '6' -> List("m", "n", "o"), '7' -> List("p", "q", "r", "s"), '8' -> List("t", "u", "v"), '9' -> List("w", "x", "y", "z"))

  def letterCombinations(digits: String): List[String] = if (digits.isEmpty) List() else digits.tail.iterator.foldLeft(map(digits.head))((list, digit) => map(digit).flatMap(d => list.map(s => s"$s$d")))

  letterCombinations("23").foreach(println)
}

//Runtime: 701 ms, faster than 54.22% of Scala online submissions for Letter Combinations of a Phone Number.
//Memory Usage: 66.2 MB, less than 65.06% of Scala online submissions for Letter Combinations of a Phone Number.