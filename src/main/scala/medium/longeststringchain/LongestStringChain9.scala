package com.soumen.leetcodesolutions
package medium.longeststringchain

import scala.collection.mutable

/**
 * <a href="https://leetcode.com/problems/longest-string-chain/">
 * 1048. Longest String Chain
 * </a>
 * */
object LongestStringChain9 extends App {
  def longestStrChain(words: Array[String]): Int = {
    def isSuccessor(p: String, s: String) = p.length + 1 == s.length && s.indices.exists(i => new mutable.StringBuilder(s).deleteCharAt(i).toString == p)

    words.sortBy(_.length).foldLeft((1, Map.empty[String, Int])) { case ((maxLen, dp), word) =>
      val l = words.filter(isSuccessor(_, word)).map(dp(_)).maxOption.getOrElse(0) + 1
      (maxLen max l) -> (dp + (word -> l))
    }._1
  }

  println(longestStrChain(Array("a", "b", "ba", "bca", "bda", "bdca")))
  println(longestStrChain(Array("xbc", "pcxbcf", "xb", "cxbc", "pcxbc")))
  println(longestStrChain(Array("abcd", "dbqca")))
  println(longestStrChain(Array("a", "ab", "ac", "bd", "abc", "abd", "abdd")))
}
//Runtime: 1196 ms, faster than 64.29% of Scala online submissions for Longest String Chain.
//Memory Usage: 57.6 MB, less than 64.29% of Scala online submissions for Longest String Chain.