package com.soumen.leetcodesolutions
package medium.lettercombinationofaphonenumber

object Solution2 extends App {
  val map = Map(2 -> Seq('a', 'b', 'c'), 3 -> Seq('d', 'e', 'f'), 4 -> Seq('g', 'h', 'i'), 5 -> Seq('j', 'k', 'l'),
    6 -> Seq('m', 'n', 'o'), 7 -> Seq('p', 'q', 'r', 's'), 8 -> Seq('t', 'u', 'v'), 9 -> Seq('w', 'x', 'y', 'z'))

  def letterCombinations(digits: String): List[String] = digits.toList.foldLeft(Seq[String]()) { (list, char) => map(char - '0').flatMap(d => if (list.isEmpty) Seq(d.toString) else list.map(s => s"$s$d")) }.toList

  letterCombinations("23").foreach(println)
}

//Runtime: 717 ms, faster than 53.01% of Scala online submissions for Letter Combinations of a Phone Number.
//Memory Usage: 66.8 MB, less than 28.92% of Scala online submissions for Letter Combinations of a Phone Number.