package com.soumen.leetcodesolutions
package medium.maximumproductofwordlengths

/**
 * <a href="https://leetcode.com/problems/maximum-product-of-word-lengths/">
 * 318. Maximum Product of Word Lengths
 * </a> */
object MaximumProductOfWordLengths extends App {
  @scala.annotation.tailrec
  def uniqueChars(s1: String, s2: String, i: Int = 0, unique: Boolean = true): Boolean =
    if (!unique || i == s1.length) unique
    else uniqueChars(s1, s2, i + 1, unique && !s2.contains(s1.charAt(i)))

  def maxProduct(words: Array[String]): Int = {
    var max = 0
    for (i <- words.indices; j <- i until words.length if uniqueChars(words(i), words(j)))
      max = max max words(i).length * words(j).length
    max
  }

  println(maxProduct(Array("abcw", "baz", "foo", "bar", "xtfn", "abcdef")))
  println(maxProduct(Array("a", "ab", "abc", "d", "cd", "bcd", "abcd")))
  println(maxProduct(Array("a", "aa", "aaa", "aaaa")))
}
//Runtime: 1504 ms, faster than 100.00% of Scala online submissions for Maximum Product of Word Lengths.
//Memory Usage: 53.9 MB, less than 100.00% of Scala online submissions for Maximum Product of Word Lengths.
