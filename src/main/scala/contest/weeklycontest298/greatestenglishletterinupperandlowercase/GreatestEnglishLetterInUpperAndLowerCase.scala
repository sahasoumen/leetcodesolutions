package com.soumen.leetcodesolutions
package contest.weeklycontest298.greatestenglishletterinupperandlowercase

/**
 * <a href="https://leetcode.com/contest/weekly-contest-298/problems/greatest-english-letter-in-upper-and-lower-case/">
 * 5242. Greatest English Letter in Upper and Lower Case
 * </a>
 * */
object GreatestEnglishLetterInUpperAndLowerCase extends App {
  def greatestLetter(s: String): String = s.groupBy(c => if (c >= 'a') c - 'a' else c - 'A')
    .filter(_._2.distinct.length > 1)
    .toSeq.sortBy(_._1)(Ordering.Int.reverse)
    .headOption.map(_._2.min.toString)
    .getOrElse("")


  println(greatestLetter("abcDeAdc"))
}
//Runtime: 937 ms, faster than 100.00% of Scala online submissions for Greatest English Letter in Upper and Lower Case.
//Memory Usage: 66.6 MB, less than 100.00% of Scala online submissions for Greatest English Letter in Upper and Lower Case.