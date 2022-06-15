package com.soumen.leetcodesolutions
package medium.longeststringchain

/**
 * <a href="https://leetcode.com/problems/longest-string-chain/">
 * 1048. Longest String Chain
 * </a>
 * */
object LongestStringChain11 extends App {
  def longestStrChain(words: Array[String]): Int = {
    def isSuccessor(p: String, s: String) = p.length + 1 == s.length && s.indices.exists(i => s.substring(0, i) + s.substring(i + 1) == p)

    words.sortBy(_.length).foldLeft(Map.empty[String, Int])((dp, word) => dp + (word -> (words.filter(isSuccessor(_, word)).map(dp(_)).maxOption.getOrElse(0) + 1))).values.max
  }

  println(longestStrChain(Array("a", "b", "ba", "bca", "bda", "bdca")))
  println(longestStrChain(Array("xbc", "pcxbcf", "xb", "cxbc", "pcxbc")))
  println(longestStrChain(Array("abcd", "dbqca")))
  println(longestStrChain(Array("a", "ab", "ac", "bd", "abc", "abd", "abdd")))
}
//Runtime: 1392 ms, faster than 50.00% of Scala online submissions for Longest String Chain.
//Memory Usage: 58.3 MB, less than 75.00% of Scala online submissions for Longest String Chain.