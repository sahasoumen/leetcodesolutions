package com.soumen.leetcodesolutions
package medium.lettercombinationofaphonenumber

object Solution extends App {
  val map = Map(2 -> Seq('a', 'b', 'c'), 3 -> Seq('d', 'e', 'f'), 4 -> Seq('g', 'h', 'i'), 5 -> Seq('j', 'k', 'l'),
    6 -> Seq('m', 'n', 'o'), 7 -> Seq('p', 'q', 'r', 's'), 8 -> Seq('t', 'u', 'v'), 9 -> Seq('w', 'x', 'y', 'z'))

  def letterCombinations(digits: String): List[String] = {
    @scala.annotation.tailrec
    def helper(digits: Seq[Int], result: Seq[String] = Nil): Seq[String] = digits match {
      case Nil => result
      case digit :: tail => result match {
        case Nil => helper(tail, map(digit).map(_.toString))
        case _ => helper(tail, result.flatMap(r => map(digit).map(l => s"$r$l")))
      }
    }

    helper(digits.toList.map(_ - '0')).toList
  }

  letterCombinations("23").foreach(println)
}

//Runtime: 706 ms, faster than 54.22% of Scala online submissions for Letter Combinations of a Phone Number.
//Memory Usage: 66.8 MB, less than 36.14% of Scala online submissions for Letter Combinations of a Phone Number.