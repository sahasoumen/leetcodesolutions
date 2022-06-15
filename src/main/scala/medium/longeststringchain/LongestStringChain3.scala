package com.soumen.leetcodesolutions
package medium.longeststringchain

import scala.collection.mutable

/**
 * <a href="https://leetcode.com/problems/longest-string-chain/">
 * 1048. Longest String Chain
 * </a>
 * */
object LongestStringChain3 extends App {
  def longestStrChain(words: Array[String]): Int = {

    def isSuccessor(p: String, s: String) = p.length + 1 == s.length && s.indices.exists(i => new mutable.StringBuilder(s).deleteCharAt(i).toString == p)

    val dp = scala.collection.mutable.Map.empty[String, Int]
    var maxLen = 1
    words.sortBy(_.length).foreach { word =>
      val l = dp.getOrElse(word, 1)
      words.filter(isSuccessor(word, _)).foreach { w =>
        val m = l + 1 max dp.getOrElse(w, 1)
        maxLen = maxLen max m
        dp += w -> m
      }
    }
    maxLen
  }

  println(longestStrChain(Array("a", "b", "ba", "bca", "bda", "bdca")))
  println(longestStrChain(Array("xbc", "pcxbcf", "xb", "cxbc", "pcxbc")))
  println(longestStrChain(Array("abcd", "dbqca")))
  println(longestStrChain(Array("a", "ab", "ac", "bd", "abc", "abd", "abdd")))
}
//Runtime: 1157 ms, faster than 64.29% of Scala online submissions for Longest String Chain.
//Memory Usage: 54.3 MB, less than 100.00% of Scala online submissions for Longest String Chain.