package com.soumen.leetcodesolutions
package medium.longeststringchain

import scala.collection.mutable

/**
 * <a href="https://leetcode.com/problems/longest-string-chain/">
 * 1048. Longest String Chain
 * </a>
 * */
object LongestStringChain5 extends App {
  def longestStrChain(words: Array[String]): Int = {

    def isSuccessor(p: String, s: String) = s.indices.exists(i => new mutable.StringBuilder(s).deleteCharAt(i).toString == p)

    words.sortBy(_.length).foldLeft((0, Map.empty[String, Int])) { case ((max, dp), word) =>
      val m = words.filter(_.length == word.length - 1).filter(isSuccessor(_, word)).map(dp(_) + 1).maxOption.getOrElse(1)
      (m max max) -> (dp + (word -> m))
    }._1
  }

  println(longestStrChain(Array("a", "b", "ba", "bca", "bda", "bdca")))
  println(longestStrChain(Array("xbc", "pcxbcf", "xb", "cxbc", "pcxbc")))
  println(longestStrChain(Array("abcd", "dbqca")))
  println(longestStrChain(Array("a", "ab", "ac", "bd", "abc", "abd", "abdd")))
}
//Runtime: 1292 ms, faster than 50.00% of Scala online submissions for Longest String Chain.
//Memory Usage: 57.3 MB, less than 64.29% of Scala online submissions for Longest String Chain.