package com.soumen.leetcodesolutions
package simple.countsortedvowelstring

/**
 * https://leetcode.com/problems/count-sorted-vowel-strings
 * 1641. Count Sorted Vowel Strings
 * */
object Solution extends App {
  val vowels = Seq('a', 'e', 'i', 'o', 'u')

  def countVowelStrings(n: Int): Int = {
    def countVowel(s: Seq[String] = vowels.map(_.toString)): Int = if (s.isEmpty) 0
    else if (s.head.length == n) s.size
    else vowels.map(v => countVowel(s.filter(_.head <= v).map(v + _))).sum

    countVowel()
  }

  println(countVowelStrings(1))
  println(countVowelStrings(2))
  println(countVowelStrings(33))
}
//Runtime: 6331 ms, faster than 50.00% of Scala online submissions for Count Sorted Vowel Strings.
//Memory Usage: 734.6 MB, less than 50.00% of Scala online submissions for Count Sorted Vowel Strings.