package com.soumen.leetcodesolutions
package contest.weeklycontest298.greatestenglishletterinupperandlowercase

/**
 * <a href="https://leetcode.com/contest/weekly-contest-298/problems/greatest-english-letter-in-upper-and-lower-case/">
 * 5242. Greatest English Letter in Upper and Lower Case
 * </a>
 * */
object GreatestEnglishLetterInUpperAndLowerCase2 extends App {
  def greatestLetter(s: String): String = ('Z'.toInt to 'A'.toInt by -1).map(_.toChar).find(c => s.contains(c) && s.contains(c.toLower)).map(_.toString).getOrElse("")


  println(greatestLetter("abcDeAdc"))
}
//Runtime: 752 ms, faster than 100.00% of Scala online submissions for Greatest English Letter in Upper and Lower Case.
//Memory Usage: 66.7 MB, less than 100.00% of Scala online submissions for Greatest English Letter in Upper and Lower Case.