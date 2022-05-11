package com.soumen.leetcodesolutions
package simple.countsortedvowelstring

/**
 * https://leetcode.com/problems/count-sorted-vowel-strings
 * 1641. Count Sorted Vowel Strings
 * */

object Solution3 extends App {

  def countVowelStrings(n: Int): Int = {
    val vowels = Seq('a', 'e', 'i', 'o', 'u')

    def countVowel(s: Seq[Seq[Char]] = vowels.map(Seq(_))): Int = if (s.isEmpty) 0
    else if (s.head.length == n) s.size
    else vowels.map(v => countVowel(s.filter(_.head <= v).map(v +: _))).sum

    countVowel()
  }

  println(countVowelStrings(1))
  println(countVowelStrings(2))
  println(countVowelStrings(33))
}
//Runtime: 6364 ms, faster than 50.00% of Scala online submissions for Count Sorted Vowel Strings.
//Memory Usage: 737.4 MB, less than 50.00% of Scala online submissions for Count Sorted Vowel Strings.