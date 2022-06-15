package com.soumen.leetcodesolutions
package medium.longeststringchain

import scala.collection.mutable

/**
 * <a href="https://leetcode.com/problems/longest-string-chain/">
 * 1048. Longest String Chain
 * </a>
 * */
object LongestStringChain4 extends App {
  def longestStrChain(words: Array[String]): Int = {

    def isSuccessor(p: String, s: String) = p.length + 1 == s.length && s.indices.exists(i => new mutable.StringBuilder(s).deleteCharAt(i).toString == p)

    val dp = scala.collection.mutable.Map.empty[String, Int]
    words.sortBy(_.length).foldLeft(0) { case (max, word) =>
      val m = dp.keys.map(w => if (isSuccessor(w, word)) dp(w) + 1 else 1).maxOption.getOrElse(1)
      dp += word -> m
      max max m
    }
  }

  println(longestStrChain(Array("a", "b", "ba", "bca", "bda", "bdca")))
  println(longestStrChain(Array("xbc", "pcxbcf", "xb", "cxbc", "pcxbc")))
  println(longestStrChain(Array("abcd", "dbqca")))
  println(longestStrChain(Array("a", "ab", "ac", "bd", "abc", "abd", "abdd")))
}
//Runtime: 2531 ms, faster than 7.14% of Scala online submissions for Longest String Chain.
//Memory Usage: 186.3 MB, less than 14.29% of Scala online submissions for Longest String Chain.