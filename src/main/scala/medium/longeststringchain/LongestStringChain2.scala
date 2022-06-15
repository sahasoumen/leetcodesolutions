package com.soumen.leetcodesolutions
package medium.longeststringchain

import scala.collection.mutable

/**
 * <a href="https://leetcode.com/problems/longest-string-chain/">
 * 1048. Longest String Chain
 * </a>
 * */
object LongestStringChain2 extends App {
  def longestStrChain(words: Array[String]): Int = {

    def isSuccessor(p: String, s: String) = p.length + 1 == s.length && s.indices.exists(i => new mutable.StringBuilder(s).deleteCharAt(i).toString == p)

    val dp = scala.collection.mutable.Map.empty[String, Int]

    words.sortBy(_.length).foreach { word =>
      val l = dp get word match {
        case None => dp += word -> 1
          1
        case Some(len) => len
      }
      words.filter(isSuccessor(word, _)).foreach(w => dp += w -> (l + 1 max dp.getOrElse(w, l + 1)))
    }
    dp.values.max
  }

  println(longestStrChain(Array("a", "b", "ba", "bca", "bda", "bdca")))
  println(longestStrChain(Array("xbc", "pcxbcf", "xb", "cxbc", "pcxbc")))
  println(longestStrChain(Array("abcd", "dbqca")))
  println(longestStrChain(Array("a", "ab", "ac", "bd", "abc", "abd", "abdd")))
}
//Runtime: 1746 ms, faster than 14.29% of Scala online submissions for Longest String Chain.
//Memory Usage: 186.8 MB, less than 14.29% of Scala online submissions for Longest String Chain.